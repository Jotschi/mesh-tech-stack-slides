package com.gentics.mesh;

import io.vertx.core.json.JsonObject;

public class DaggerApp {

	public static void main(String[] args) {
		JsonObject config = new JsonObject();
		config.put("hello", "world");
		AppComponent app = DaggerAppComponent.builder().configuration(config).build();
		System.out.println(app.configuration().getString("hello"));
	}

}
