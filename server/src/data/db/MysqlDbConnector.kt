package company.wed.data.db

import org.jetbrains.exposed.sql.Database

class MysqlDbConnector(
    private val url: String,
    private val user: String,
    private val password: String
) : DbConnector {
    companion object {
        const val MYSQL_DRIVER = "com.mysql.jdbc.Driver"
    }

    override fun connect(): Database = Database.connect(
        url = url,
        driver = MYSQL_DRIVER,
        user = user,
        password = password
    )
}