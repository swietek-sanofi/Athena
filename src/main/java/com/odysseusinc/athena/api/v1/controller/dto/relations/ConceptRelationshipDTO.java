/*
 *
 * Copyright 2018 Odysseus Data Services, inc.
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *
 * Company: Odysseus Data Services, Inc.
 * Product Owner/Architecture: Gregory Klebanov
 * Authors: Pavel Grafkin, Vitaly Koulakov, Maria Pozhidaeva
 * Created: April 4, 2018
 *
 */

package com.odysseusinc.athena.api.v1.controller.dto.relations;

public class ConceptRelationshipDTO {

    private Long targetConceptId;
    private String targetConceptName;
    private String targetVocabularyId;

    private String relationshipId;
    private String relationshipName;

    public Long getTargetConceptId() {

        return targetConceptId;
    }

    public void setTargetConceptId(Long targetConceptId) {

        this.targetConceptId = targetConceptId;
    }

    public String getTargetConceptName() {

        return targetConceptName;
    }

    public void setTargetConceptName(String targetConceptName) {

        this.targetConceptName = targetConceptName;
    }

    public String getTargetVocabularyId() {

        return targetVocabularyId;
    }

    public void setTargetVocabularyId(String targetVocabularyId) {

        this.targetVocabularyId = targetVocabularyId;
    }

    public String getRelationshipId() {

        return relationshipId;
    }

    public void setRelationshipId(String relationshipId) {

        this.relationshipId = relationshipId;
    }

    public String getRelationshipName() {

        return relationshipName;
    }

    public void setRelationshipName(String relationshipName) {

        this.relationshipName = relationshipName;
    }
}
