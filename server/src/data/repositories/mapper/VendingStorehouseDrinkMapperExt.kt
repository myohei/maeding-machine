package company.wed.data.repositories.mapper

import company.wed.data.db.entities.DrinkEntityImpl
import company.wed.data.db.entities.TemperatureEntityImpl
import company.wed.data.db.entities.VendingStorehouseDrinkEntityImpl
import company.wed.data.entities.VendingStorehouseDrinkEntity
import company.wed.domain.VendingStorehouseDrink


fun VendingStorehouseDrinkEntityImpl.toModel(): VendingStorehouseDrinkEntity = VendingStorehouseDrinkEntity(
    id = id.value,
    drink = DrinkEntityImpl[drink].toModel(),
    temperature = TemperatureEntityImpl[temperature].value,
    amount = amount,
    createdAt = createdAt,
    updatedAt = updatedAt,
    status = status
)