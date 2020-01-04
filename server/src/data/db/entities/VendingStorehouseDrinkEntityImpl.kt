package company.wed.data.db.entities

import company.wed.data.db.dao.VendingStorehouseDrinks
import org.jetbrains.exposed.dao.IntEntity
import org.jetbrains.exposed.dao.IntEntityClass
import org.jetbrains.exposed.dao.id.EntityID

class VendingStorehouseDrinkEntityImpl(id: EntityID<Int>) : IntEntity(id) {
    companion object : IntEntityClass<VendingStorehouseDrinkEntityImpl>(VendingStorehouseDrinks)

    var drink by VendingStorehouseDrinks.drink
    var temperature by VendingStorehouseDrinks.temperature
    var amount by VendingStorehouseDrinks.amount
    var status by VendingStorehouseDrinks.status
    var createdAt by VendingStorehouseDrinks.createdAt
    var updatedAt by VendingStorehouseDrinks.updatedAt
}