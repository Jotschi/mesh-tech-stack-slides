package com.gentics.vertx;

import io.vertx.core.Vertx;
import io.vertx.ext.web.Router;

public class VertxWebExample {

	public static void main(String[] args) {

		Vertx vertx = Vertx.vertx();

		Router router = Router.router(vertx);

		router.route("/hello").handler(rc -> {
			rc.response().end("World");
		});

		vertx.createHttpServer()
			.requestHandler(router::accept)
			.listen(8080);
	}
}
