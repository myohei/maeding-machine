package company.wed.data.repositories.mapper

import company.wed.data.db.entities.DrinkEntityImpl
import company.wed.data.db.entities.SellEntityImpl
import company.wed.data.db.entities.TemperatureEntityImpl
import company.wed.data.entities.SellEntity

fun SellEntityImpl.toEntity(): SellEntity = SellEntity(
    drink = DrinkEntityImpl[drinkId].toModel(),
    temperature = TemperatureEntityImpl[temperature].value,
    soldAt = soldAt,
    isPayment = isPayment
)