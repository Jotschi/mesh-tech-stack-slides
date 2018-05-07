package com.gentics.mesh;

import io.vertx.reactivex.core.Vertx;
import io.vertx.reactivex.ext.web.Router;

public class RxJavaVertxExamples {

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
