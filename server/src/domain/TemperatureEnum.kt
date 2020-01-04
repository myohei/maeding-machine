package company.wed.domain

import org.jetbrains.exposed.sql.Column
import org.jetbrains.exposed.sql.Table

enum class TemperatureEnum {
    HOT,
    COLD,
    NORMAL
}