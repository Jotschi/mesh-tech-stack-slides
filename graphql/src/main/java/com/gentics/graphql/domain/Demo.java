package com.gentics.graphql.domain;

/**
 * Simple POJO which can be referenced in a query data fetcher
 */
public class Demo {

	private final String name;
	private final String id;

	public Demo(String id, String name) {
		this.id = id;
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public String getId() {
		return id;
	}
}
