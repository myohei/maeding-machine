package company.wed.graphql

import graphql.nextgen.GraphQL
import graphql.schema.idl.RuntimeWiring

interface Schema {
    fun create(): GraphQL
}