package company.wed.data.db.dao

import org.jetbrains.exposed.sql.Column
import org.jetbrains.exposed.sql.Table
import org.jetbrains.exposed.sql.jodatime.datetime
import org.joda.time.DateTime

object VendingMachineDao : Table("vending_machine") {
    override val primaryKey: PrimaryKey?
        get() = PrimaryKey(row, column)

    val row: Column<Int> = integer("row")
    val column: Column<Int> = integer("column")
    val vendingStorehouseDrink = reference("vending_storehouse_drink_id", VendingStorehouseDrinkDao)
    val createdAt: Column<DateTime> = datetime("created_at").default(DateTime.now())
    val updatedAt: Column<DateTime> = datetime("updated_at").clientDefault {
        DateTime.now()
    }

}