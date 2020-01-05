package company.wed.data.db

import org.jetbrains.exposed.sql.Database

interface DbConnector {
    fun connect(): Database
}