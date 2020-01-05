package company.wed.data.repositories

import company.wed.data.entities.VendingStorehouseDrinkEntity

interface VendingStorehouseDrinkRepository {
    fun update(entity: VendingStorehouseDrinkEntity)
}