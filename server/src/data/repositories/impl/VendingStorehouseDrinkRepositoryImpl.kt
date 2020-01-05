package company.wed.data.repositories.impl

import company.wed.data.db.dao.VendingStorehouseDrinks
import company.wed.data.entities.VendingStorehouseDrinkEntity
import company.wed.data.repositories.VendingStorehouseDrinkRepository
import org.jetbrains.exposed.sql.transactions.transaction
import org.jetbrains.exposed.sql.update

class VendingStorehouseDrinkRepositoryImpl : VendingStorehouseDrinkRepository {
    override fun update(entity: VendingStorehouseDrinkEntity) {
        // TODO: amount以外は対応してない
        transaction {
            VendingStorehouseDrinks.update({ VendingStorehouseDrinks.id eq entity.id }) {
                it[VendingStorehouseDrinks.amount] = entity.amount
            }
        }
    }
}