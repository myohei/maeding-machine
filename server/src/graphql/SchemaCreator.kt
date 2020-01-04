package company.wed.graphql

import com.expediagroup.graphql.SchemaGeneratorConfig
import com.expediagroup.graphql.TopLevelObject
import com.expediagroup.graphql.toSchema
import company.wed.graphql.mutations.BuyDrinkMutation
import company.wed.graphql.queries.VendingMachineQuery
import company.wed.graphql.scalars.DateTimeScalarGeneratorHooks
import company.wed.services.VendingMachineService
import graphql.schema.GraphQLSchema

class SchemaCreator(
    private val vendingMachineService: VendingMachineService
) : Schema {
    override fun create(): GraphQLSchema {
        val config =
            SchemaGeneratorConfig(
                supportedPackages = listOf("company.wed"),
                hooks = DateTimeScalarGeneratorHooks()
            )
        return toSchema(
            config,
            queries = listOf(TopLevelObject(VendingMachineQuery(vendingMachineService))),
            mutations = listOf(TopLevelObject(BuyDrinkMutation(vendingMachineService)))
        )
    }
}

