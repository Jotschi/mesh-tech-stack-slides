package com.gentics.graphql.domain;

/**
 * Root element of our domain model.
 */
public class RootElement {

	private final Demo demo;

	public RootElement(Demo demo) {
		this.demo = demo;
	}

	public Demo getDemo() {
		return demo;
	}
}
