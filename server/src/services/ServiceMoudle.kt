package company.wed.services

import company.wed.services.impl.SetupServiceImpl
//import company.wed.services.impl.VendingMachineServiceImpl
import org.koin.dsl.module

val serviceModule = module(createdAtStart = true) {
    //    single<VendingMachineService> { VendingMachineServiceImpl(get()) }
    single<SetupService> { SetupServiceImpl(get()) }
}