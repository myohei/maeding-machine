package company.wed.data.db.dao

import company.wed.domain.DrinkTypeEnum
import org.jetbrains.exposed.dao.id.IntIdTable
import org.jetbrains.exposed.sql.Column
import org.jetbrains.exposed.sql.jodatime.datetime
import org.joda.time.DateTime

object Drinks : IntIdTable("drinks") {
    val name: Column<String> = varchar("name", 255)
    val image: Column<String> = text("image")
    val type: Column<DrinkTypeEnum> = drinkTypeEnumColumn(this)
    val capacity: Column<Int> = integer("capacity")
    val price: Column<Int> = integer("price")
    val createdAt: Column<DateTime> = datetime("created_at").default(DateTime.now())
    val updatedAt: Column<DateTime> = datetime("updated_at").clientDefault {
        DateTime.now()
    }
}

