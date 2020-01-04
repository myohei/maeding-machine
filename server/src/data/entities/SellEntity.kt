package company.wed.data.entities

import company.wed.domain.TemperatureEnum
import org.joda.time.DateTime

data class SellEntity(
    val drink: DrinkEntity,
    val temperature: TemperatureEnum,
    val soldAt: DateTime,
    val isPayment: Boolean
)