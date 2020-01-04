package company.wed.services

import company.wed.domain.BuyDrink
import company.wed.domain.BuyResult
import company.wed.domain.VendingMachine
import company.wed.domain.VendingMachineItem

interface VendingMachineService {
    fun findAllDrinks(): VendingMachine
    fun buy(row: Int, column: Int, withLucky: Boolean): BuyResult
}