package company.wed.domain

import org.joda.time.DateTime

data class Drink(
    val id: Int,
    val name: String,
    val image: String,
    val type: DrinkTypeEnum,
    val capacity: Int,
    val price: Int,
    val createdAt: DateTime,
    val updatedAt: DateTime
)