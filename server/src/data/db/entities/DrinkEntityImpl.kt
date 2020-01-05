package company.wed.data.db.entities

import company.wed.data.db.dao.Drinks
import company.wed.data.db.dao.DrinksTemperatures
import org.jetbrains.exposed.dao.IntEntity
import org.jetbrains.exposed.dao.IntEntityClass
import org.jetbrains.exposed.dao.id.EntityID

class DrinkEntityImpl(id: EntityID<Int>) : IntEntity(id) {
    companion object : IntEntityClass<DrinkEntityImpl>(Drinks)

    var name by Drinks.name
    var image by Drinks.image
    var type by Drinks.type
    var capacity by Drinks.capacity
    var temperatures by TemperatureEntityImpl via DrinksTemperatures
    var price by Drinks.price
    var createdAt by Drinks.createdAt
    var updatedAt by Drinks.updatedAt
}