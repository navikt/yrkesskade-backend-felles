package no.nav.yrkesskade.featureflag.strategy

import no.finn.unleash.UnleashContext
import org.assertj.core.api.Assertions
import org.junit.jupiter.api.Test

class MinimumAntallAnsatteStrategyTest {

    @Test
    fun `is enabled - parameter and property set and greater`() {
        val context: UnleashContext = UnleashContext
            .builder()
            .addProperty(
                "antallAnsatte", "5")
            .build()

        val minimumAntallAnsatteStrategy = MinimumAntallAnsatteStrategy(context)
        val parameters = HashMap<String, String>()
        parameters.put("minimumAntallAnsatte", "1")
        Assertions.assertThat(minimumAntallAnsatteStrategy.isEnabled(parameters, context)).isTrue()
    }

    @Test
    fun `is enabled - parameter and property set and equal`() {
        val context: UnleashContext = UnleashContext
            .builder()
            .addProperty("antallAnsatte", "5")
            .build()

        val minimumAntallAnsatteStrategy = MinimumAntallAnsatteStrategy(context)
        val parameters = HashMap<String, String>()
        parameters.put("minimumAntallAnsatte", "5")
        Assertions.assertThat(minimumAntallAnsatteStrategy.isEnabled(parameters, context)).isTrue()
    }

    @Test
    fun `is disabled - parameter and property set and lower`() {
        val context: UnleashContext = UnleashContext
            .builder()
            .addProperty("antallAnsatte", "5")
            .build()

        val minimumAntallAnsatteStrategy = MinimumAntallAnsatteStrategy(context)
        val parameters = HashMap<String, String>()
        parameters.put("minimumAntallAnsatte", "10")
        Assertions.assertThat(minimumAntallAnsatteStrategy.isEnabled(parameters, context)).isFalse()
    }

    @Test
    fun `is disabled - parameter set`() {
        val context: UnleashContext = UnleashContext
            .builder()
            .build()

        val minimumAntallAnsatteStrategy = MinimumAntallAnsatteStrategy(context)
        val parameters = HashMap<String, String>()
        parameters.put("minimumAntallAnsatte", "1")
        Assertions.assertThat(minimumAntallAnsatteStrategy.isEnabled(parameters, context)).isFalse()
    }

    @Test
    fun `is enabled -  property set`() {
        val context: UnleashContext = UnleashContext
            .builder()
            .addProperty(
                "antallAnsatte", "5")
            .build()

        val minimumAntallAnsatteStrategy = MinimumAntallAnsatteStrategy(context)
        val parameters = HashMap<String, String>()
        Assertions.assertThat(minimumAntallAnsatteStrategy.isEnabled(parameters, context)).isTrue()
    }

}