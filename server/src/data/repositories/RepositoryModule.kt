package company.wed.data.repositories

import company.wed.data.repositories.impl.SellRepositoryImpl
import company.wed.data.repositories.impl.VendingMachineItemRepositoryImpl
import company.wed.data.repositories.impl.VendingStorehouseDrinkRepositoryImpl
import org.koin.dsl.module

val repositoryModule = module(createdAtStart = true) {
    single<VendingMachineItemRepository> { VendingMachineItemRepositoryImpl() }
    single<VendingStorehouseDrinkRepository> { VendingStorehouseDrinkRepositoryImpl() }
    single<SellRepository> { SellRepositoryImpl() }
}