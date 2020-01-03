package company.wed.repositories

import company.wed.domain.Drink

interface DrinkRepository {
    fun findAll(): List<Drink>
    fun findById(id: Int): Drink
    fun insert(drink: Drink)
    fun update(drink: Drink)
}