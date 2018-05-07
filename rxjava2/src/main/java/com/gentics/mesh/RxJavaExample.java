package com.gentics.mesh;

import io.reactivex.Single;

public class RxJavaExample {

	public static void main(String[] args) {
		fetchName().map(String::toLowerCase).subscribe(System.out::println);
	}

	private static Single<String> fetchName() {
		return Single.just("WORLD");
	}

}
