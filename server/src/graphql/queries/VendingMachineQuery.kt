package company.wed.graphql.queries

import company.wed.domain.VendingMachine
import company.wed.services.VendingMachineService

class VendingMachineQuery(private val service: VendingMachineService) {
    fun vendingMachine(): VendingMachine? {
        return service.findAllDrinks()
    }
}