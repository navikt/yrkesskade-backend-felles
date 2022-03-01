package no.nav.yrkesskade.featureflag.strategy

import no.finn.unleash.UnleashContext
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class NaeringskodeStrategyTest {

    @Test
    fun `is enabled - has naeringskoder`() {
        val context: UnleashContext = UnleashContext
            .builder()
            .addProperty(
                "naeringskoder",
                arrayOf("61.2", "56.3", "test").joinToString(","))
            .build()

        val naeringskodeStrategy = NaeringskodeStrategy(context)
        val parameters = HashMap<String, String>()
        parameters.put("naeringskoder", arrayOf("52.1", "61.2").joinToString(","))
        assertThat(naeringskodeStrategy.isEnabled(parameters, context)).isTrue()
    }

    @Test
    fun `is enabled - no naeringskoder provided in parameters`() {
        val context: UnleashContext = UnleashContext
            .builder()
            .addProperty(
                "naeringskoder",
                arrayOf("61.2", "56.3", "test").joinToString(","))
            .build()

        val naeringskodeStrategy = NaeringskodeStrategy(context)
        val parameters = HashMap<String, String>()
        assertThat(naeringskodeStrategy.isEnabled(parameters, context)).isTrue()
    }

    @Test
    fun `is disabled - no naeringskoder in context`() {
        val context: UnleashContext = UnleashContext
            .builder()
            .build()

        val naeringskodeStrategy = NaeringskodeStrategy(context)
        val parameters = HashMap<String, String>()
        parameters.put("naeringskoder", arrayOf("52.1", "61.2").joinToString(","))
        assertThat(naeringskodeStrategy.isEnabled(parameters, context)).isFalse()
    }

    @Test
    fun `is disabled - no matching naeringskoder`() {
        val context: UnleashContext = UnleashContext
            .builder()
            .addProperty(
                "naeringskoder",
                arrayOf("no-match", "test").joinToString(","))
            .build()

        val naeringskodeStrategy = NaeringskodeStrategy(context)
        val parameters = HashMap<String, String>()
        parameters.put("naeringskoder", arrayOf("52.1", "61.2").joinToString(","))
        assertThat(naeringskodeStrategy.isEnabled(parameters, context)).isFalse()
    }
}