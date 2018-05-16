package com.gentics.graphql;

import static graphql.Scalars.GraphQLString;
import static graphql.Scalars.GraphQLLong;
import static graphql.schema.GraphQLFieldDefinition.newFieldDefinition;
import static graphql.schema.GraphQLObjectType.newObject;

import com.gentics.graphql.domain.Conference;

import graphql.schema.GraphQLNonNull;
import graphql.schema.GraphQLObjectType;
import graphql.schema.GraphQLSchema;

public class ConferenceSchema {

	private static GraphQLObjectType createQueryType() {
		return newObject().name("QueryType")

			// .workshop
			.field(newFieldDefinition().name("workshop")
				.type(createWorkshopType())
				.dataFetcher((env) -> {
					Conference root = env.getSource();
					return root.getWorkshop();
				}))

			.build();
	}

	private static GraphQLObjectType createWorkshopType() {
		return newObject().name("Workshop")
			.description("A workshop element")

			// .id
			.field(newFieldDefinition().name("id")
				.description("The id of the workshop.")
				.type(new GraphQLNonNull(GraphQLLong)))

			// .name
			.field(newFieldDefinition().name("name")
				.description("The name of the workshop.")
				.type(GraphQLString))

			.build();
	}

	public static GraphQLSchema createSchema() {
		return GraphQLSchema.newSchema()
			.query(createQueryType())
			.build();
	}
}
