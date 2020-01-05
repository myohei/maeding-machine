package company.wed.features.lucky

import org.junit.Test

class RandomLuckyTest {

    private val l = RandomLucky(100)
    @Test
    fun testLucky() {
        assert(!l.ohYouAreLucky())
    }
}