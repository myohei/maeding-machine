package company.wed.graphql.mutations

import company.wed.domain.BuyResult
import company.wed.services.VendingMachineService

class BuyDrinkMutation(private val service: VendingMachineService) {
    fun buy(row: Int, column: Int, withLucky: Boolean): BuyResult = service.buy(row, column, withLucky)
}