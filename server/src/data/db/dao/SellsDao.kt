package company.wed.data.db.dao

import org.jetbrains.exposed.dao.id.IntIdTable
import org.jetbrains.exposed.sql.Column
import org.jetbrains.exposed.sql.jodatime.datetime
import org.joda.time.DateTime

object SellsDao : IntIdTable("sells") {
    val drink = reference("drink_id", DrinksDao)
    val temperature = reference("temperature_id", TemperaturesDao)
    val soldAt: Column<DateTime> = datetime("sold_at").default(DateTime.now())
    val isPayment: Column<Boolean> = bool("is_payment").default(false)
}