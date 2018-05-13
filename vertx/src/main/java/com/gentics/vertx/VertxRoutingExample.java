package com.gentics.vertx;

import io.vertx.core.Vertx;
import io.vertx.ext.web.Router;

/**#
 * Provides endpoint using subrouters:
 * 
 * http://localhost:8080/test/hello
 *
 */
public class VertxRoutingExample {

	public static void main(String[] args) {

		Vertx vertx = Vertx.vertx();

		Router router = Router.router(vertx);

		Router subRouter = Router.router(vertx);
		router.mountSubRouter("/test/", subRouter);

		subRouter.route("/hello").handler(rc -> {
			rc.response().end("World");
		});

		vertx.createHttpServer()
			.requestHandler(router::accept)
			.listen(8080);
	}
}
