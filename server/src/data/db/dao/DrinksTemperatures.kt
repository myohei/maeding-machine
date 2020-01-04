package company.wed.data.db.dao

import org.jetbrains.exposed.sql.Table

object DrinksTemperatures : Table("drinks_temperatures") {
    override val primaryKey: PrimaryKey?
        get() = PrimaryKey(drink, temperature)

    val drink = reference("drink_id", Drinks)
    val temperature = reference("temperature_id", Temperatures)
}