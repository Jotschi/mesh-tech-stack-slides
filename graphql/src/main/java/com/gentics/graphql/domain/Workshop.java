package com.gentics.graphql.domain;

/**
 * Simple POJO which can be referenced in a query data fetcher
 */
public class Workshop {

	private final String name;
	private final long id;

	public Workshop(long id, String name) {
		this.id = id;
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public long getId() {
		return id;
	}
}
