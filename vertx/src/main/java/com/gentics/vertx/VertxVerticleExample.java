package com.gentics.vertx;

import io.vertx.core.AbstractVerticle;
import io.vertx.core.Future;
import io.vertx.core.Vertx;
import io.vertx.core.logging.Logger;
import io.vertx.core.logging.LoggerFactory;

public class VertxVerticleExample {

	public static void main(String[] args) {
		Vertx vertx = Vertx.vertx();
		vertx.deployVerticle(new TestVerticle());
	}

}

class TestVerticle extends AbstractVerticle {

	private static final Logger log = LoggerFactory.getLogger(TestVerticle.class);

	@Override
	public void start(Future<Void> startFuture) throws Exception {
		log.info("Started");
		startFuture.complete();
	}

	@Override
	public void stop(Future<Void> stopFuture) throws Exception {
		log.info("Stopped");
		stopFuture.complete();
	}
}
