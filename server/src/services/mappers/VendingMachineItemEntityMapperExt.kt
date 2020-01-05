package company.wed.services.mappers

import company.wed.data.entities.VendingMachineItemEntity
import company.wed.domain.VendingMachineItem

fun VendingMachineItemEntity.toDomain(): VendingMachineItem = VendingMachineItem(
    row = row,
    column = column,
    vendingStorehouseDrink = vendingMachineItemEntity.toDomain(),
    createdAt = createdAt,
    updatedAt = updatedAt
)