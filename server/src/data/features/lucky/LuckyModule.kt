package company.wed.data.features.lucky

import org.koin.dsl.module

val luckyModule = module {
    single<ILucky> { RandomLucky() }
}