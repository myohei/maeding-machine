package company.wed.data.repositories.mapper

import company.wed.data.db.entities.DrinkEntityImpl
import company.wed.data.entities.DrinkEntity
import company.wed.domain.Drink

fun DrinkEntityImpl.toModel(): DrinkEntity = DrinkEntity(
    id = id.value,
    name = name,
    image = image,
    temperatures = temperatures.map { it.value },
    type = type,
    capacity = capacity,
    price = price,
    createdAt = createdAt,
    updatedAt = updatedAt
)