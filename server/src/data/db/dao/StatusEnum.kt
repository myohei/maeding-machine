package company.wed.data.db.dao

import org.jetbrains.exposed.sql.Column
import org.jetbrains.exposed.sql.Table

enum class StatusEnum {
    PROGRESS,
    ON_SALE,
    SOLD_OUT
}

fun statusEnumColumn(table: Table): Column<StatusEnum> =
    table.customEnumeration(
        "status",
        "ENUM ('sold_out', 'progress', 'on_sale')",
        { value -> StatusEnum.valueOf((value as String).toUpperCase()) },
        { it.name.toLowerCase() }
    )