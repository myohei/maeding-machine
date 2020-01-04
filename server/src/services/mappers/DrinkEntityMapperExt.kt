package company.wed.services.mappers

import company.wed.data.entities.DrinkEntity
import company.wed.domain.Drink

fun DrinkEntity.toDomain(): Drink = Drink(
    id = id,
    name = name,
    image = image,
    type = type,
    capacity = capacity,
    price = price,
    createdAt = createdAt,
    updatedAt = updatedAt
)