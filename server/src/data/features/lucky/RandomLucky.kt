package company.wed.data.features.lucky

import kotlin.random.Random

class RandomLucky : ILucky {
    private val random = Random(System.currentTimeMillis())
    override fun ohYouAreLucky(): Boolean {
        return random.nextInt(0, 100) % 33 == 0
    }
}