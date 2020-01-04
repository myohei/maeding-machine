package company.wed.domain

import company.wed.data.db.dao.StatusEnum
import org.joda.time.DateTime

data class VendingMachineItem(
    val row: Int,
    val column: Int,
    val vendingStorehouseDrink: VendingStorehouseDrink,
    val createdAt: DateTime,
    val updatedAt: DateTime
)