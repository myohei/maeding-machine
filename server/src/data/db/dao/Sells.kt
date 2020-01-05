package company.wed.data.db.dao

import org.jetbrains.exposed.dao.id.IntIdTable
import org.jetbrains.exposed.sql.Column
import org.jetbrains.exposed.sql.jodatime.datetime
import org.joda.time.DateTime

object Sells : IntIdTable("sells") {
    val drink = reference("drink_id", Drinks)
    val temperature = reference("temperature_id", Temperatures)
    val soldAt: Column<DateTime> = datetime("sold_at").default(DateTime.now())
    val isPayment: Column<Boolean> = bool("is_payment").default(false)
}