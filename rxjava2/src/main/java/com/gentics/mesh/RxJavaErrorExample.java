package com.gentics.mesh;

import io.reactivex.Single;

public class RxJavaErrorExample {

	public static void main(String[] args) {
		fetchName().map(String::toLowerCase).subscribe(System.out::println, Throwable::printStackTrace);
	}

	private static Single<String> fetchName() {
		return Single.error(new IllegalArgumentException());
	}

}
