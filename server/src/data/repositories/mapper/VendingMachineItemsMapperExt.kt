package company.wed.data.repositories.mapper

import company.wed.data.db.entities.VendingMachineItemEntityImpl
import company.wed.data.db.entities.VendingStorehouseDrinkEntityImpl
import company.wed.data.entities.VendingMachineItemEntity
import company.wed.domain.VendingMachineItem

fun VendingMachineItemEntityImpl.toModel(): VendingMachineItemEntity = VendingMachineItemEntity(
    row = row,
    column = column,
    vendingMachineItemEntity = VendingStorehouseDrinkEntityImpl[vendingStorehouseDrink].toModel(),
    createdAt = createdAt,
    updatedAt = updatedAt
)