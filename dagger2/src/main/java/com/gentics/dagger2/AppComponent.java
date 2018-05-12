package com.gentics.dagger2;

import javax.inject.Singleton;

import dagger.BindsInstance;
import dagger.Component;
import io.vertx.core.json.JsonObject;

@Singleton
@Component(modules = { AppModule.class })
public interface AppComponent {

	JsonObject configuration();

	HelloService hello();

	@Component.Builder
	interface Builder {
		@BindsInstance
		Builder configuration(JsonObject configuration);

		AppComponent build();
	}

}
