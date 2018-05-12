package com.gentics.vertx;

import java.io.IOException;

import org.junit.Ignore;
import org.junit.Test;

import io.vertx.core.Vertx;
import io.vertx.core.eventbus.EventBus;

@Ignore
public class VertxPitfallTest {

	@Test
	public void testInstanceLoop() throws IOException {
		System.in.read();
		for (int i = 0; i < 10000; i++) {
			Vertx.vertx();
		}
		System.in.read();
	}

	@Test
	public void testMsgLoop() throws IOException {
		System.in.read();
		final String ADDR = "dummy";
		Vertx vertx = Vertx.vertx();
		EventBus bus = vertx.eventBus();

		bus.consumer(ADDR, rh -> {
			bus.publish(ADDR, "hello-world");
			bus.publish(ADDR, "hello-world");
		});

		bus.publish(ADDR, "hello-world");
		System.in.read();
	}
}
