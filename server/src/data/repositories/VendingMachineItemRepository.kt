package company.wed.data.repositories

import company.wed.data.entities.VendingMachineItemEntity

interface VendingMachineItemRepository {
    fun findAll(): List<VendingMachineItemEntity>

    fun findByPosition(row: Int, column: Int): VendingMachineItemEntity?
}