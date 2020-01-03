package company.wed.data.db.entities

import company.wed.data.db.dao.DrinksDao
import company.wed.data.db.dao.TemperaturesDao
import org.jetbrains.exposed.dao.IntEntity
import org.jetbrains.exposed.dao.IntEntityClass
import org.jetbrains.exposed.dao.id.EntityID

class TemperatureEntity(id: EntityID<Int>) : IntEntity(id) {
    companion object : IntEntityClass<TemperatureEntity>(TemperaturesDao)

    var value by TemperaturesDao.value
}