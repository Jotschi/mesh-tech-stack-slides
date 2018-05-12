package com.gentics.dagger2;

import javax.inject.Inject;
import javax.inject.Singleton;

import io.vertx.core.json.JsonObject;

@Singleton
public class HelloService {

	@Inject
	JsonObject configuration;

	@Inject
	public HelloService() {
	}

	public String getResult() {
		return configuration.getString("hello");
	}

}
