package company.wed.data.db.dao

import company.wed.domain.DrinkTypeEnum
import company.wed.domain.TemperatureEnum
import org.jetbrains.exposed.sql.Column
import org.jetbrains.exposed.sql.Table

fun drinkTypeEnumColumn(table: Table): Column<DrinkTypeEnum> =
    table.customEnumeration(
        "type",
        "ENUM ('can', 'pet')",
        { value -> DrinkTypeEnum.valueOf((value as String).toUpperCase()) },
        { it.name.toLowerCase() })

fun temperatureEnumColumn(table: Table): Column<TemperatureEnum> =
    table.customEnumeration(
        "value",
        "ENUM ('cold', 'hot', 'normal')",
        { value -> TemperatureEnum.valueOf((value as String).toUpperCase()) },
        { it.name.toLowerCase() })

