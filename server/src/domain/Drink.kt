package company.wed.domain

import org.joda.time.DateTime

data class Drink(
    val id: Int = -1,
    val name: String,
    val image: String,
    val type: DrinkTypeEnum,
    val allowedTemperatures: List<TemperatureEnum>,
    val capacity: Int,
    val price: Int,
    val createdAt: DateTime,
    val updatedAt: DateTime
)