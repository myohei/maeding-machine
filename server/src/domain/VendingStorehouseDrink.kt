package company.wed.domain

import org.joda.time.DateTime

data class VendingStorehouseDrink(
    val drink: Drink,
    val temperature: TemperatureEnum,
//    val amount: Int,
    val nowOnSale: Boolean,
    val createdAt: DateTime,
    val updatedAt: DateTime
)