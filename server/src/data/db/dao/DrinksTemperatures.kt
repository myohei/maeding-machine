package company.wed.data.db.dao

import org.jetbrains.exposed.sql.Column
import org.jetbrains.exposed.sql.SizedCollection
import org.jetbrains.exposed.sql.Table
import org.jetbrains.exposed.sql.jodatime.datetime
import org.joda.time.DateTime

object DrinksTemperatures : Table("drink_temperature") {
    override val primaryKey: PrimaryKey?
        get() = PrimaryKey(drink, temperature)

    val drink = reference("drink_id", DrinksDao)
    val temperature = reference("temperature_id", TemperaturesDao)
}