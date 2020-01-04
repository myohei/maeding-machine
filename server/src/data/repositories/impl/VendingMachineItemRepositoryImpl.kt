package company.wed.data.repositories.impl

import company.wed.data.db.dao.VendingMachineItems.column
import company.wed.data.db.dao.VendingMachineItems.row
import company.wed.data.db.entities.VendingMachineItemEntityImpl
import company.wed.data.entities.VendingMachineItemEntity
import company.wed.data.repositories.VendingMachineItemRepository
import company.wed.data.repositories.mapper.toModel
import org.jetbrains.exposed.sql.SortOrder
import org.jetbrains.exposed.sql.transactions.transaction

class VendingMachineItemRepositoryImpl : VendingMachineItemRepository {
    override fun findAll(): List<VendingMachineItemEntity> {
        return transaction {
            VendingMachineItemEntityImpl.all()
                .orderBy(
                    row to SortOrder.ASC,
                    column to SortOrder.ASC
                )
                .map {
                    it.toModel()
                }
        }

    }

    override fun findByPosition(row: Int, column: Int): VendingMachineItemEntity? {
        val rowColumn = "$row$column"
        return transaction {
            VendingMachineItemEntityImpl.findById(rowColumn)
                ?.toModel()
        }
    }
}