package company.wed.data.repositories

import company.wed.data.entities.SellEntity
import company.wed.domain.TemperatureEnum
import org.joda.time.DateTime

interface SellRepository {
    fun create(
        drinkId: Int,
        temperature: TemperatureEnum,
        soldAt: DateTime,
        withLucky: Boolean
    ): SellEntity
}