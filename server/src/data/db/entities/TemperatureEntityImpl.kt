package company.wed.data.db.entities

import company.wed.data.db.dao.Temperatures
import org.jetbrains.exposed.dao.IntEntity
import org.jetbrains.exposed.dao.IntEntityClass
import org.jetbrains.exposed.dao.id.EntityID

class TemperatureEntityImpl(id: EntityID<Int>) : IntEntity(id) {
    companion object : IntEntityClass<TemperatureEntityImpl>(Temperatures)

    var value by Temperatures.value
}