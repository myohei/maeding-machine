package company.wed.data.db.entities

import company.wed.data.db.dao.DrinksDao
import company.wed.data.db.dao.DrinksTemperatures
import org.jetbrains.exposed.dao.IntEntity
import org.jetbrains.exposed.dao.IntEntityClass
import org.jetbrains.exposed.dao.id.EntityID

class DrinkEntity(id: EntityID<Int>) : IntEntity(id) {
    companion object : IntEntityClass<DrinkEntity>(DrinksDao)

    var name by DrinksDao.name
    var image by DrinksDao.image
    var type by DrinksDao.type
    var capacity by DrinksDao.capacity
    var temperatures by TemperatureEntity via DrinksTemperatures
    var price by DrinksDao.price
    var createdAt by DrinksDao.createdAt
    var updatedAt by DrinksDao.updatedAt
}