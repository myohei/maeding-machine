package company.wed.data.db.entities

import company.wed.data.db.dao.VendingStorehouseDrinkDao
import org.jetbrains.exposed.dao.IntEntity
import org.jetbrains.exposed.dao.IntEntityClass
import org.jetbrains.exposed.dao.id.EntityID

class VendingStorehouseDrinkEntity(id: EntityID<Int>) : IntEntity(id) {
    companion object : IntEntityClass<VendingStorehouseDrinkEntity>(VendingStorehouseDrinkDao)

    var drink by VendingStorehouseDrinkDao.drink
    var temperature by VendingStorehouseDrinkDao.temperature
    var amount by VendingStorehouseDrinkDao.amount
    var status by VendingStorehouseDrinkDao.status
    var createdAt by VendingStorehouseDrinkDao.createdAt
    var updatedAt by VendingStorehouseDrinkDao.updatedAt
}