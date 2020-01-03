package company.wed.data.db.dao

import org.jetbrains.exposed.dao.id.IntIdTable
import org.jetbrains.exposed.sql.Column
import org.jetbrains.exposed.sql.jodatime.datetime
import org.joda.time.DateTime

object VendingStorehouseDrinkDao : IntIdTable("vending_storehouse_drink") {
    val drink = reference("drink_id", DrinksDao)
    val temperature = reference("temperature_id", TemperaturesDao)
    val amount: Column<Int> = integer("amount")
    val status: Column<StatusEnum> = statusEnumColumn(this)
    val createdAt: Column<DateTime> = datetime("created_at").default(DateTime.now())
    val updatedAt: Column<DateTime> = datetime("updated_at").clientDefault {
        DateTime.now()
    }

    init {
        uniqueIndex(
            drink,
            temperature
        )
    }
}