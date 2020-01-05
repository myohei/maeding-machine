package company.wed.features.lucky

import org.koin.dsl.module

val luckyModule = module {
    single<ILucky> { RandomLucky(System.currentTimeMillis()) }
}