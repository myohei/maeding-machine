package company.wed.resolvers

import company.wed.domain.VendingMachine
import company.wed.services.VendingMachineService
import graphql.schema.DataFetcher
import graphql.schema.DataFetchingEnvironment

class VendingMachineDataFetcher(
    private val service: VendingMachineService
) : DataFetcher<VendingMachine> {
    override fun get(environment: DataFetchingEnvironment?): VendingMachine = service.findAllDrinks()
}