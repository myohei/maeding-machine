package company.wed.data.db.entities

import company.wed.data.db.dao.SellsDao
import org.jetbrains.exposed.dao.IntEntity
import org.jetbrains.exposed.dao.IntEntityClass
import org.jetbrains.exposed.dao.id.EntityID

class SellEntity(id: EntityID<Int>) : IntEntity(id) {
    companion object : IntEntityClass<SellEntity>(SellsDao)

    var drinkId by SellsDao.drink
    var temperature by SellsDao.temperature
    var soldAt by SellsDao.soldAt
    var isPayment by SellsDao.isPayment
}