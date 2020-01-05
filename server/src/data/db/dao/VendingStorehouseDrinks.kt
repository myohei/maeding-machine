package company.wed.data.db.dao

import org.jetbrains.exposed.dao.id.IntIdTable
import org.jetbrains.exposed.sql.Column
import org.jetbrains.exposed.sql.jodatime.datetime
import org.joda.time.DateTime

object VendingStorehouseDrinks : IntIdTable("vending_storehouse_drinks") {
    val drink = reference("drink_id", Drinks)
    val temperature = reference("temperature_id", Temperatures)
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