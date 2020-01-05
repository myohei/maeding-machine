package company.wed.services.impl

import company.wed.data.repositories.SellRepository
import company.wed.data.repositories.VendingMachineItemRepository
import company.wed.data.repositories.VendingStorehouseDrinkRepository
import company.wed.domain.*
import company.wed.features.lucky.ILucky
import company.wed.services.VendingMachineService
import company.wed.services.mappers.toDomain
import io.ktor.features.NotFoundException
import io.ktor.util.KtorExperimentalAPI
import org.jetbrains.exposed.sql.transactions.transaction
import org.joda.time.DateTime
import java.lang.Exception

class VendingMachineServiceImpl(
    private val vendingMachineItemRepository: VendingMachineItemRepository,
    private val vendingStorehouseDrinkRepository: VendingStorehouseDrinkRepository,
    private val sellRepository: SellRepository,
    private val lucky: ILucky
) :
    VendingMachineService {
    override fun findAllDrinks(): VendingMachine {
        return VendingMachine(
            vendingMachineItemRepository.findAll()
                .map { it.toDomain() }
        )
    }

    @KtorExperimentalAPI
    override fun buy(row: Int, column: Int, withLucky: Boolean): BuyResult {
        // TODO: 買えるかどうかバリデーションしないと
        return transaction {
            val vendingMachineItem =
                vendingMachineItemRepository.findByPosition(row, column) ?: throw NotFoundException("hoge")
            if (vendingMachineItem.vendingMachineItemEntity.amount == 0) {
                throw Exception("売り切れで買えません。")
            }
            val sell = sellRepository.create(
                vendingMachineItem.vendingMachineItemEntity.drink.id,
                temperature = vendingMachineItem.vendingMachineItemEntity.temperature,
                soldAt = DateTime.now(),
                withLucky = withLucky
            )
            // キャシュから消えないかも
            val storehouseDrink = vendingMachineItem.vendingMachineItemEntity
            vendingStorehouseDrinkRepository.update(
                storehouseDrink.copy(amount = storehouseDrink.amount - 1)
            )
            BuyResult(
                drink2BuyDrink(sell.drink.toDomain(), vendingMachineItem.vendingMachineItemEntity.temperature),
                sell.soldAt,
                lucky = lucky.ohYouAreLucky()
            )
        }
    }

    private fun drink2BuyDrink(drink: Drink, temperature: TemperatureEnum): BuyDrink {
        return BuyDrink(
            id = drink.id,
            image = drink.image,
            type = drink.type,
            name = drink.name,
            temperature = temperature,
            capacity = drink.capacity,
            price = drink.price,
            createdAt = drink.createdAt,
            updatedAt = drink.updatedAt
        )
    }
}