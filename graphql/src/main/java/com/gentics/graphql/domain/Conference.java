package com.gentics.graphql.domain;

/**
 * Root element of our domain model.
 */
public class Conference {

	private final Workshop workshop;

	public Conference(Workshop workshop) {
		this.workshop = workshop;
	}

	public Workshop getWorkshop() {
		return workshop;
	}
}
