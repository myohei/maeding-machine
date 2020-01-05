package company.wed.data.entities

import company.wed.domain.TemperatureEnum

data class TemperatureEntity(
    val id: Int,
    val value: TemperatureEnum
)