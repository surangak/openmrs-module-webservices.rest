/**
 * The contents of this file are subject to the OpenMRS Public License
 * Version 1.0 (the "License"); you may not use this file except in
 * compliance with the License. You may obtain a copy of the License at
 * http://license.openmrs.org
 *
 * Software distributed under the License is distributed on an "AS IS"
 * basis, WITHOUT WARRANTY OF ANY KIND, either express or implied. See the
 * License for the specific language governing rights and limitations
 * under the License.
 *
 * Copyright (C) OpenMRS, LLC.  All Rights Reserved.
 */
package org.openmrs.module.webservices.rest.web.v1_0.resource;

import org.openmrs.Field;
import org.openmrs.FieldAnswer;
import org.openmrs.api.context.Context;
import org.openmrs.module.webservices.rest.web.resource.impl.BaseDelegatingResourceTest;

public class FieldAnswerResourceTest extends BaseDelegatingResourceTest<FieldAnswerResource, FieldAnswer> {
	
	private String fieldAnswerUUID;
	
	/**
	 * @see org.openmrs.module.webservices.rest.web.resource.impl.BaseDelegatingResourceTest#newObject()
	 */
	@Override
	public FieldAnswer newObject() {
		Field field = Context.getFormService().getFieldByUuid(ResourceTestConstants.FIELD_UUID);
		FieldAnswer fieldAnswer = new FieldAnswer();
		fieldAnswer.setConcept(Context.getConceptService().getConceptByUuid(ResourceTestConstants.CONCEPT_UUID));
		field.addAnswer(fieldAnswer);
		
		fieldAnswerUUID = fieldAnswer.getUuid();
		
		return fieldAnswer;
	}
	
	/**
	 * @see org.openmrs.module.webservices.rest.web.resource.impl.BaseDelegatingResourceTest#getDisplayProperty()
	 */
	@Override
	public String getDisplayProperty() {
		return "Null Field - YES";
	}
	
	/**
	 * @see org.openmrs.module.webservices.rest.web.resource.impl.BaseDelegatingResourceTest#getUuidProperty()
	 */
	@Override
	public String getUuidProperty() {
		return fieldAnswerUUID;
	}
	
}
