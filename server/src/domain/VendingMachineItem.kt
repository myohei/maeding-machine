package company.wed.domain

import company.wed.data.db.dao.StatusEnum
import org.joda.time.DateTime

data class VendingMachineItem(
    val row: Int,
    val column: Int,
    val drink: Drink,
    val temperature: TemperatureEnum,
    val amount: Int,
    val status: StatusEnum,
    val createdAt: DateTime,
    val updatedAt: DateTime
)