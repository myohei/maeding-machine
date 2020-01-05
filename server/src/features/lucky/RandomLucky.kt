package company.wed.features.lucky

import kotlin.random.Random

class RandomLucky(seed: Long) : ILucky {
    private val random = Random(seed)
    override fun ohYouAreLucky(): Boolean {
        return random.nextInt(0, 100) % 33 == 0
    }
}