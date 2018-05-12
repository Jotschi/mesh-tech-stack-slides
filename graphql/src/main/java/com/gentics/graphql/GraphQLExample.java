package com.gentics.graphql;

import static graphql.GraphQL.newGraphQL;

import java.util.Map;

import com.gentics.graphql.domain.Demo;
import com.gentics.graphql.domain.RootElement;

import graphql.ExecutionInput;
import graphql.ExecutionResult;
import graphql.GraphQL;
import graphql.schema.GraphQLSchema;
import io.vertx.core.json.JsonObject;

public class GraphQLExample {

	public static void main(String[] args) {

		// Create the GraphQL schema for our domain
		GraphQLSchema schema = DemoSchema.createSchema();

		// Create the demo data
		Demo demo = new Demo("root", "The demo element");
		RootElement rootElement = new RootElement(demo);

		// Setup a dummy query
		JsonObject queryJson = new JsonObject("{\n" +
			"  \"query\": \"{\\n  \\tdemo {\\n      name\\n      id\\n    }\\n}\"\n" +
			"}");
		String query = queryJson.getString("query");

		// Execute the query
		GraphQL graphQL = newGraphQL(schema).build();
		ExecutionInput input = new ExecutionInput(query, null, queryJson, rootElement, null);
		ExecutionResult result = graphQL.execute(input);
		Map<String, Object> data = (Map<String, Object>) result.getData();

		System.out.println(new JsonObject(data).encodePrettily());

	}

}
