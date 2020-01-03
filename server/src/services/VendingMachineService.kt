package company.wed.services

interface VendingMachineService {
    suspend fun findAllDrinks()
    suspend fun buy(row: Int, column: Int)
}