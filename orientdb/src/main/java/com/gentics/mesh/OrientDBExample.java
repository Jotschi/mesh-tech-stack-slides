package com.gentics.mesh;

import com.orientechnologies.orient.core.db.ODatabaseType;
import com.orientechnologies.orient.core.db.OrientDB;
import com.orientechnologies.orient.core.db.OrientDBConfig;
import com.orientechnologies.orient.core.db.document.ODatabaseDocument;
import com.orientechnologies.orient.core.record.OVertex;

public class OrientDBExample {

	public static void main(String[] args) {

		try (OrientDB orientDB = new OrientDB("embedded:target/", OrientDBConfig.defaultConfig())) {
			orientDB.drop("test");

			orientDB.create("test", ODatabaseType.PLOCAL);

			try (ODatabaseDocument db = orientDB.open("test", "admin", "admin");) {
				OVertex v = db.newVertex();
				v.setProperty("hello", "world");
				String value = v.getProperty("hello");
				System.out.println(value);
			}

		}

	}
}
