package company.wed.services.mappers

import company.wed.data.entities.VendingStorehouseDrinkEntity
import company.wed.domain.VendingStorehouseDrink

fun VendingStorehouseDrinkEntity.toDomain(): VendingStorehouseDrink = VendingStorehouseDrink(
    drink = drink.toDomain(),
    temperature = temperature,
//    amount = amount,
    nowOnSale = amount > 0,
    createdAt = createdAt,
    updatedAt = updatedAt
)