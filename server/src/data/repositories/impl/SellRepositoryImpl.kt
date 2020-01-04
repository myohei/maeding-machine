package company.wed.data.repositories.impl

import company.wed.data.db.dao.Temperatures
import company.wed.data.db.entities.DrinkEntityImpl
import company.wed.data.db.entities.SellEntityImpl
import company.wed.data.db.entities.TemperatureEntityImpl
import company.wed.data.entities.SellEntity
import company.wed.data.repositories.SellRepository
import company.wed.data.repositories.mapper.toEntity
import company.wed.domain.TemperatureEnum
import org.jetbrains.exposed.dao.id.EntityID
import org.jetbrains.exposed.sql.select
import org.jetbrains.exposed.sql.transactions.transaction
import org.joda.time.DateTime

class SellRepositoryImpl : SellRepository {
    override fun create(
        drinkId: Int,
        temperature: TemperatureEnum,
        soldAt: DateTime,
        withLucky: Boolean
    ): SellEntity {
        return transaction {
            SellEntityImpl.new {
                this.drinkId = DrinkEntityImpl[drinkId].id
                this.temperature = findByTemperature(temperature)
                this.soldAt = soldAt
                isPayment = !withLucky
            }
                .toEntity()
        }
    }

    private fun findByTemperature(t: TemperatureEnum): EntityID<Int> {
        return Temperatures.select { Temperatures.value eq t }
            .limit(1)
            .toList()
            .first()[Temperatures.id]
    }
}