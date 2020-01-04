package company.wed.data.db.entities

import company.wed.data.db.dao.Sells
import org.jetbrains.exposed.dao.IntEntity
import org.jetbrains.exposed.dao.IntEntityClass
import org.jetbrains.exposed.dao.id.EntityID

class SellEntityImpl(id: EntityID<Int>) : IntEntity(id) {
    companion object : IntEntityClass<SellEntityImpl>(Sells)

    var drinkId by Sells.drink
    var temperature by Sells.temperature
    var soldAt by Sells.soldAt
    var isPayment by Sells.isPayment
}