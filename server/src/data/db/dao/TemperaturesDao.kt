package company.wed.data.db.dao

import org.jetbrains.exposed.dao.id.IntIdTable

object TemperaturesDao : IntIdTable("temperatures") {
    val value = temperatureEnumColumn(this)
}