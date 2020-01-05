package company.wed.data.db.entities

import company.wed.data.db.dao.VendingMachineItems
import org.jetbrains.exposed.dao.Entity
import org.jetbrains.exposed.dao.EntityClass
import org.jetbrains.exposed.dao.id.EntityID

class VendingMachineItemEntityImpl(rowColumn: EntityID<String>) : Entity<String>(rowColumn) {
    companion object : EntityClass<String, VendingMachineItemEntityImpl>(VendingMachineItems)

    var row by VendingMachineItems.row
    var column by VendingMachineItems.column
    var vendingStorehouseDrink by VendingMachineItems.vendingStorehouseDrink
    var createdAt by VendingMachineItems.createdAt
    var updatedAt by VendingMachineItems.updatedAt
}