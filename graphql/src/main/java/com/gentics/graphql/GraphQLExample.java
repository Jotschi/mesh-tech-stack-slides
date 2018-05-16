package com.gentics.graphql;

import static graphql.GraphQL.newGraphQL;

import java.util.Map;

import com.gentics.graphql.domain.Workshop;
import com.gentics.graphql.domain.Conference;

import graphql.ExecutionInput;
import graphql.ExecutionResult;
import graphql.GraphQL;
import graphql.schema.GraphQLSchema;
import io.vertx.core.json.JsonObject;

public class GraphQLExample {

	// Setup a dummy query
	public static JsonObject queryJson = new JsonObject("{\n" +
		"  \"query\": \"{\\n \\tworkshop {\\n  name\\n  id\\n }\\n}\"\n" +
		"}");
	public static String query = queryJson.getString("query");

	public static void main(String[] args) {

		// Create the GraphQL schema for our domain
		GraphQLSchema schema = ConferenceSchema.createSchema();

		Workshop demo = new Workshop(42, "Gentics Mesh Tech Stack");
		Conference rootElement = new Conference(demo);

		// Execute the query
		GraphQL graphQL = newGraphQL(schema).build();
		String operation = null;
		Map<String, Object> variables = null;
		ExecutionInput in =
			new ExecutionInput(query, operation, queryJson, rootElement, variables);

		ExecutionResult result = graphQL.execute(in);
		Map<String, Object> data = (Map<String, Object>) result.getData();

		System.out.println(new JsonObject(data).encodePrettily());

	}

}
