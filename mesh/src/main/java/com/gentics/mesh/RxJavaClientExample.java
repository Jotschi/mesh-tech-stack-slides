package com.gentics.mesh;

import java.util.Arrays;
import java.util.List;

import com.gentics.mesh.core.rest.node.NodeCreateRequest;
import com.gentics.mesh.rest.client.MeshRestClient;
import com.gentics.mesh.rest.client.impl.MeshRestHttpClientImpl;

import io.reactivex.Observable;
import io.vertx.core.Vertx;

public class RxJavaClientExample {

	public static void main(String[] args) {

		MeshRestClient client = new MeshRestHttpClientImpl("localhost", Vertx.vertx());

		List<String> names = Arrays.asList("Iron Man",
			"Captain America",
			"Star Lord",
			"Black Widow",
			"Hulk");

		client.findProjectByName("MCU").toSingle().flatMapCompletable(project -> {
			return Observable.fromIterable(names).flatMapSingle(name -> {

				NodeCreateRequest request = new NodeCreateRequest();
				request.setParentNodeUuid(project.getRootNode().getUuid());
				request.setLanguage("en");

				return client.createNode("MCU", request).toSingle();
			}).ignoreElements();
		}).subscribe();

	}

}
