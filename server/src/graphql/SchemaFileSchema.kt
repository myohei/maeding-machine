package company.wed.graphql

import graphql.nextgen.GraphQL
import graphql.schema.idl.RuntimeWiring
import graphql.schema.idl.SchemaGenerator
import graphql.schema.idl.SchemaParser

//class SchemaFileSchema(private val schemaString: String) : Schema {
////    override fun create(): GraphQL {
////        val parser = SchemaParser()
////        val typed = parser.parse(schemaString)
////        val runtimeWiring = RuntimeWiring.newRuntimeWiring().build()
////        val schema = SchemaGenerator().makeExecutableSchema(typed, runtimeWiring)
////        return GraphQL.newGraphQL(schema).build()
////    }
////}