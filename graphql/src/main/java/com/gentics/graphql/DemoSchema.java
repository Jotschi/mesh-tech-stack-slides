package com.gentics.graphql;

import static graphql.Scalars.GraphQLString;
import static graphql.schema.GraphQLFieldDefinition.newFieldDefinition;
import static graphql.schema.GraphQLObjectType.newObject;

import com.gentics.graphql.domain.RootElement;

import graphql.schema.GraphQLNonNull;
import graphql.schema.GraphQLObjectType;
import graphql.schema.GraphQLSchema;

public class DemoSchema {

	private static GraphQLObjectType createQueryType() {
		return newObject().name("QueryType")

			// .demo
			.field(newFieldDefinition().name("demo")
				.type(createDemoType())
				.dataFetcher((env) -> {
					RootElement root = env.getSource();
					return root.getDemo();
				}))

			.build();
	}

	private static GraphQLObjectType createDemoType() {
		return newObject().name("Demo")
			.description("A demo element")

			// .id
			.field(newFieldDefinition().name("id")
				.description("The id of the character.")
				.type(new GraphQLNonNull(GraphQLString)))

			// .name
			.field(newFieldDefinition().name("name")
				.description("The name of the element.")
				.type(GraphQLString))

			.build();
	}

	public static GraphQLSchema createSchema() {
		return GraphQLSchema.newSchema()
			.query(createQueryType())
			.build();
	}
}
