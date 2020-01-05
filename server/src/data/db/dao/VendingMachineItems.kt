package company.wed.data.db.dao

import org.jetbrains.exposed.dao.id.EntityID
import org.jetbrains.exposed.dao.id.IdTable
import org.jetbrains.exposed.sql.Column
import org.jetbrains.exposed.sql.jodatime.datetime
import org.joda.time.DateTime

object VendingMachineItems : IdTable<String>("vending_machine_items") {
    val rowColumn: Column<String> = varchar("row_column", 255)
    val row: Column<Int> = integer("row")
    val column: Column<Int> = integer("column")
    val vendingStorehouseDrink = reference("vending_storehouse_drink_id", VendingStorehouseDrinks)
    val createdAt: Column<DateTime> = datetime("created_at").default(DateTime.now())
    val updatedAt: Column<DateTime> = datetime("updated_at").clientDefault {
        DateTime.now()
    }
    override val primaryKey: PrimaryKey?
        get() = PrimaryKey(rowColumn)
    override val id: Column<EntityID<String>> = rowColumn.entityId()

    init {
        uniqueIndex(row, column)
    }
}