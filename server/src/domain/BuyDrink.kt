package company.wed.domain

import org.joda.time.DateTime

data class BuyResult(
    val drink: BuyDrink,
    val boughtAt: DateTime,
    val lucky: Boolean
)

data class BuyDrink(
    val id: Int,
    val name: String,
    val image: String,
    val type: DrinkTypeEnum,
    val temperature: TemperatureEnum,
    val capacity: Int,
    val price: Int,
    val createdAt: DateTime,
    val updatedAt: DateTime
)