package com.gentics.mesh;

import io.reactivex.Single;
import io.vertx.core.file.OpenOptions;
import io.vertx.reactivex.core.Vertx;

public class RxJavaVertxExamples {

	public static void main(String[] args) {
		Vertx vertx = Vertx.vertx();
		vertx.fileSystem().rxOpen("/tmp/test", new OpenOptions())
			.flatMap(file -> {
				return Single.just(file).doFinally(file::close);
			});

	}

}
