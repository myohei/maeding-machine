package company.wed.data.entities

import company.wed.domain.DrinkTypeEnum
import company.wed.domain.TemperatureEnum
import org.joda.time.DateTime

data class DrinkEntity(
    val id: Int,
    val name: String,
    val image: String,
    val type: DrinkTypeEnum,
    val capacity: Int,
    val temperatures: List<TemperatureEnum>,
    val price: Int,
    val createdAt: DateTime,
    val updatedAt: DateTime
)