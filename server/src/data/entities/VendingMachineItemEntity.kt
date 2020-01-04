package company.wed.data.entities

import org.joda.time.DateTime

data class VendingMachineItemEntity(
    val row: Int,
    val column: Int,
    val vendingMachineItemEntity: VendingStorehouseDrinkEntity,
    val createdAt: DateTime,
    val updatedAt: DateTime
)