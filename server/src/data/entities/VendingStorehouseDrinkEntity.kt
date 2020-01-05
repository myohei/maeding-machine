package company.wed.data.entities

import company.wed.data.db.dao.StatusEnum
import company.wed.domain.TemperatureEnum
import org.joda.time.DateTime

data class VendingStorehouseDrinkEntity(
    val id: Int,
    val drink: DrinkEntity,
    val temperature: TemperatureEnum,
    val amount: Int,
    val status: StatusEnum,
    val createdAt: DateTime,
    val updatedAt: DateTime
)