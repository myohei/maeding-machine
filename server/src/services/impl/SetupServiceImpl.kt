package company.wed.services.impl

import company.wed.data.db.dao.*
import company.wed.data.db.entities.DrinkEntityImpl
import company.wed.data.db.entities.TemperatureEntityImpl
import company.wed.domain.DrinkTypeEnum
import company.wed.services.SetupService
import org.jetbrains.exposed.sql.*
import org.jetbrains.exposed.sql.transactions.transaction
import kotlin.random.Random

class SetupServiceImpl(private val database: Database) : SetupService {
    private val random = Random(System.currentTimeMillis())

    override suspend fun setup() {
        transaction {
            addLogger(StdOutSqlLogger)
            val drinks = (0..20).map {
                val drink = transaction {
                    DrinkEntityImpl.new {
                        name = "drink $it"
                        image = "https://sample-videos.com/img/Sample-jpg-image-50kb.jpg"
                        type = if (it % 5 == 0) DrinkTypeEnum.CAN else DrinkTypeEnum.PET
                        capacity = 250
                        price = 120
                    }
                }
                val temps = temperature()
                temps.map { t ->
                    transaction {
                        DrinksTemperatures.insert { entity ->
                            entity[DrinksTemperatures.drink] = drink.id
                            entity[DrinksTemperatures.temperature] = t.id
                        }
                    }
                }
                Pair(drink, temps)
            }
            val storedDrink = transaction {
                drinks.map {
                    val drink = it.first
                    val temps = it.second
                    VendingStorehouseDrinks.insertAndGetId { entity ->
                        entity[VendingStorehouseDrinks.drink] = drink.id
                        entity[VendingStorehouseDrinks.temperature] = temps[0].id
                        entity[VendingStorehouseDrinks.amount] = random.nextInt(10, 30)
                        entity[VendingStorehouseDrinks.status] = StatusEnum.ON_SALE
                    }
                }
            }
            transaction {
                (1..3).forEach { row ->
                    (1..5).forEach { column ->
                        VendingMachineItems.insert { entity ->
                            entity[VendingMachineItems.rowColumn] = "$row$column"
                            entity[VendingMachineItems.row] = row
                            entity[VendingMachineItems.column] = column
                            entity[VendingMachineItems.vendingStorehouseDrink] =
                                storedDrink[random.nextInt(storedDrink.size)]
                        }
                    }
                }
            }
        }
    }

    private fun temperature(): List<TemperatureEntityImpl> {
        val ts = TemperatureEntityImpl.all()
        val count = random.nextInt(from = 1, until = ts.count())
        return ts.toList().slice(IntRange(0, count))
    }
}