package com.odysseusinc.athena.api.v1.controller.conceptSolrQueryCreator;

import static org.junit.Assert.assertEquals;

import com.odysseusinc.athena.api.v1.controller.converter.ConceptSolrQueryCreator;
import com.odysseusinc.athena.api.v1.controller.dto.ConceptSearchDTO;
import org.junit.Test;

public class ConceptSolrQueryCreatorTest {

    private ConceptSolrQueryCreator conceptSolrQueryCreator = new ConceptSolrQueryCreator();
    @Test
    public void createSolrQueryString_withoutExactTerms() {

        ConceptSearchDTO searchDTO = new ConceptSearchDTO();
        searchDTO.setQuery("java is awesome");
        String queryString = conceptSolrQueryCreator.createSolrQueryString(searchDTO);
        assertEquals(
                "(concept_name_ci:java\\ is\\ awesome^9 OR concept_code_ci:java\\ is\\ awesome^8 OR id:java\\ is\\ awesome^8 OR concept_code:java\\ is\\ awesome^8 OR concept_name:java\\ is\\ awesome^8 OR concept_class_id:java\\ is\\ awesome^8 OR domain_id:java\\ is\\ awesome^8 OR vocabulary_id:java\\ is\\ awesome^8 OR standard_concept:java\\ is\\ awesome^8 OR invalid_reason:java\\ is\\ awesome^8 OR concept_synonym_name:java\\ is\\ awesome^8 OR concept_name_text:(java~ AND is~ AND awesome~)^7) OR " +
                        "(" +
                        "(concept_name_ci:java^6 OR concept_name_ci:java~0.6^5 OR concept_name_text:java^4 OR concept_name_text:java~^3 OR concept_code_text:java^3 OR concept_code_text:*java*^2 OR query_wo_symbols:java*) AND " +
                        "(concept_name_ci:is^6 OR concept_name_ci:is~0.6^5 OR concept_name_text:is^4 OR concept_name_text:is~^3 OR concept_code_text:is^3 OR concept_code_text:*is*^2 OR query_wo_symbols:is*) AND " +
                        "(concept_name_ci:awesome^6 OR concept_name_ci:awesome~0.6^5 OR concept_name_text:awesome^4 OR concept_name_text:awesome~^3 OR concept_code_text:awesome^3 OR concept_code_text:*awesome*^2 OR query_wo_symbols:awesome*)" +
                        ")",
                queryString);
    }

    @Test
    public void createSolrQueryString_exactTermIsFirst() {

        ConceptSearchDTO searchDTO = new ConceptSearchDTO();
        searchDTO.setQuery("\"java\" is awesome");
        String queryString = conceptSolrQueryCreator.createSolrQueryString(searchDTO);
        assertEquals(
                "(concept_name_ci:java\\ is\\ awesome^9 OR concept_code_ci:java\\ is\\ awesome^8 OR id:java\\ is\\ awesome^8 OR concept_code:java\\ is\\ awesome^8 OR concept_name:java\\ is\\ awesome^8 OR concept_class_id:java\\ is\\ awesome^8 OR domain_id:java\\ is\\ awesome^8 OR vocabulary_id:java\\ is\\ awesome^8 OR standard_concept:java\\ is\\ awesome^8 OR invalid_reason:java\\ is\\ awesome^8 OR concept_synonym_name:java\\ is\\ awesome^8 OR concept_name_text:(java AND is~ AND awesome~)^7) OR " +
                        "(" +
                        "(concept_name_ci:java^6 OR concept_code_ci:java^5 OR id:java^4 OR concept_code:java^4 OR concept_name:java^4 OR concept_class_id:java^4 OR domain_id:java^4 OR vocabulary_id:java^4 OR standard_concept:java^4 OR invalid_reason:java^4 OR concept_synonym_name:java^4) AND " +
                        "(concept_name_ci:is^6 OR concept_name_ci:is~0.6^5 OR concept_name_text:is^4 OR concept_name_text:is~^3 OR concept_code_text:is^3 OR concept_code_text:*is*^2 OR query_wo_symbols:is*) AND " +
                        "(concept_name_ci:awesome^6 OR concept_name_ci:awesome~0.6^5 OR concept_name_text:awesome^4 OR concept_name_text:awesome~^3 OR concept_code_text:awesome^3 OR concept_code_text:*awesome*^2 OR query_wo_symbols:awesome*)" +
                        ")",
                queryString);
    }

    @Test
    public void createSolrQueryString_exactTermIsInTheMiddle() {

        ConceptSearchDTO searchDTO = new ConceptSearchDTO();
        searchDTO.setQuery("java \"is\" awesome");
        String queryString = conceptSolrQueryCreator.createSolrQueryString(searchDTO);
        assertEquals(
                "(concept_name_ci:java\\ is\\ awesome^9 OR concept_code_ci:java\\ is\\ awesome^8 OR id:java\\ is\\ awesome^8 OR concept_code:java\\ is\\ awesome^8 OR concept_name:java\\ is\\ awesome^8 OR concept_class_id:java\\ is\\ awesome^8 OR domain_id:java\\ is\\ awesome^8 OR vocabulary_id:java\\ is\\ awesome^8 OR standard_concept:java\\ is\\ awesome^8 OR invalid_reason:java\\ is\\ awesome^8 OR concept_synonym_name:java\\ is\\ awesome^8 OR concept_name_text:(is AND java~ AND awesome~)^7) OR " +
                        "(" +
                        "(concept_name_ci:is^6 OR concept_code_ci:is^5 OR id:is^4 OR concept_code:is^4 OR concept_name:is^4 OR concept_class_id:is^4 OR domain_id:is^4 OR vocabulary_id:is^4 OR standard_concept:is^4 OR invalid_reason:is^4 OR concept_synonym_name:is^4) AND " +
                        "(concept_name_ci:java^6 OR concept_name_ci:java~0.6^5 OR concept_name_text:java^4 OR concept_name_text:java~^3 OR concept_code_text:java^3 OR concept_code_text:*java*^2 OR query_wo_symbols:java*) AND " +
                        "(concept_name_ci:awesome^6 OR concept_name_ci:awesome~0.6^5 OR concept_name_text:awesome^4 OR concept_name_text:awesome~^3 OR concept_code_text:awesome^3 OR concept_code_text:*awesome*^2 OR query_wo_symbols:awesome*)" +
                        ")",
                queryString);
    }

    @Test
    public void createSolrQueryString_exactTermIsLast() {

        ConceptSearchDTO searchDTO = new ConceptSearchDTO();
        searchDTO.setQuery("java is \"awesome\"");
        String queryString = conceptSolrQueryCreator.createSolrQueryString(searchDTO);
        assertEquals(
                "(concept_name_ci:java\\ is\\ awesome^9 OR concept_code_ci:java\\ is\\ awesome^8 OR id:java\\ is\\ awesome^8 OR concept_code:java\\ is\\ awesome^8 OR concept_name:java\\ is\\ awesome^8 OR concept_class_id:java\\ is\\ awesome^8 OR domain_id:java\\ is\\ awesome^8 OR vocabulary_id:java\\ is\\ awesome^8 OR standard_concept:java\\ is\\ awesome^8 OR invalid_reason:java\\ is\\ awesome^8 OR concept_synonym_name:java\\ is\\ awesome^8 OR concept_name_text:(awesome AND java~ AND is~)^7) OR " +
                        "(" +
                        "(concept_name_ci:awesome^6 OR concept_code_ci:awesome^5 OR id:awesome^4 OR concept_code:awesome^4 OR concept_name:awesome^4 OR concept_class_id:awesome^4 OR domain_id:awesome^4 OR vocabulary_id:awesome^4 OR standard_concept:awesome^4 OR invalid_reason:awesome^4 OR concept_synonym_name:awesome^4) AND " +
                        "(concept_name_ci:java^6 OR concept_name_ci:java~0.6^5 OR concept_name_text:java^4 OR concept_name_text:java~^3 OR concept_code_text:java^3 OR concept_code_text:*java*^2 OR query_wo_symbols:java*) AND " +
                        "(concept_name_ci:is^6 OR concept_name_ci:is~0.6^5 OR concept_name_text:is^4 OR concept_name_text:is~^3 OR concept_code_text:is^3 OR concept_code_text:*is*^2 OR query_wo_symbols:is*)" +

                        ")",
                queryString);
    }

    @Test
    public void createSolrQueryString_wholePhraseIsExactTerm() {

        ConceptSearchDTO searchDTO = new ConceptSearchDTO();
        searchDTO.setQuery("\"java is awesome\"");
        String queryString = conceptSolrQueryCreator.createSolrQueryString(searchDTO);
        assertEquals(
                "(concept_name_ci:java\\ is\\ awesome^9 OR concept_code_ci:java\\ is\\ awesome^8 OR id:java\\ is\\ awesome^8 OR concept_code:java\\ is\\ awesome^8 OR concept_name:java\\ is\\ awesome^8 OR concept_class_id:java\\ is\\ awesome^8 OR domain_id:java\\ is\\ awesome^8 OR vocabulary_id:java\\ is\\ awesome^8 OR standard_concept:java\\ is\\ awesome^8 OR invalid_reason:java\\ is\\ awesome^8 OR concept_synonym_name:java\\ is\\ awesome^8 OR concept_name_text:(java\\ is\\ awesome)^7) OR " +
                        "(" +
                        "(concept_name_ci:java\\ is\\ awesome^6 OR concept_code_ci:java\\ is\\ awesome^5 OR id:java\\ is\\ awesome^4 OR concept_code:java\\ is\\ awesome^4 OR concept_name:java\\ is\\ awesome^4 OR concept_class_id:java\\ is\\ awesome^4 OR domain_id:java\\ is\\ awesome^4 OR vocabulary_id:java\\ is\\ awesome^4 OR standard_concept:java\\ is\\ awesome^4 OR invalid_reason:java\\ is\\ awesome^4 OR concept_synonym_name:java\\ is\\ awesome^4)" +
                        ")",
                queryString);
    }
}