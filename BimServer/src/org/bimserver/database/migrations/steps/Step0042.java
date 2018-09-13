package org.bimserver.database.migrations.steps;

/******************************************************************************
 * Copyright (C) 2009-2018  BIMserver.org
 * 
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Affero General Public License as
 * published by the Free Software Foundation, either version 3 of the
 * License, or (at your option) any later version.
 * 
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Affero General Public License for more details.
 * 
 * You should have received a copy of the GNU Affero General Public License
 * along with this program.  If not, see {@literal<http://www.gnu.org/licenses/>}.
 *****************************************************************************/

import org.bimserver.database.DatabaseSession;
import org.bimserver.database.migrations.Migration;
import org.bimserver.database.migrations.Schema;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EcorePackage;

public class Step0042 extends Migration {

	@Override
	public void migrate(Schema schema, DatabaseSession databaseSession) {
		EAttribute projectUuid = schema.createEAttribute(schema.getEClass("store", "Project"), "uuid", EcorePackage.eINSTANCE.getEString());
		projectUuid.getEAnnotations().add(createUniqueAnnotation());
		schema.addIndex(projectUuid);
		
		EAttribute userUuid = schema.createEAttribute(schema.getEClass("store", "User"), "uuid", EcorePackage.eINSTANCE.getEString());
		userUuid.getEAnnotations().add(createUniqueAnnotation());
		schema.addIndex(userUuid);
		
		// Disabled for revisions for now, caused weird error
		
//		EAttribute revisionUuid = schema.createEAttribute(schema.getEClass("store", "Revision"), "uuid", EcorePackage.eINSTANCE.getEString());
//		revisionUuid.getEAnnotations().add(createUniqueAnnotation());
//		schema.addIndex(revisionUuid);
	}

	@Override
	public String getDescription() {
		return "Added indexed UUID fields to a few classes";
	}
}