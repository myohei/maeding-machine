package company.wed.graphql

import org.jetbrains.exposed.sql.SizedIterable
import org.koin.dsl.module

val gqlModule = module(createdAtStart = true) {
    single<Schema> { SchemaCreator(get()) }
}