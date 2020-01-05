package company.wed.graphql

import graphql.schema.GraphQLSchema

interface Schema {
    fun create(): GraphQLSchema
}