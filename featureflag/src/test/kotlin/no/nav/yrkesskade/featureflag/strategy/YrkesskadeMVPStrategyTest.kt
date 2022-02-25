package no.nav.yrkesskade.featureflag.strategy

import no.finn.unleash.UnleashContext
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class YrkesskadeMVPStrategyTest {

    @Test
    fun `is enabled`() {
        val context: UnleashContext = UnleashContext
            .builder()
            .environment("test")
            .addProperty(
                "naeringskoder",
                arrayOf("61.2", "56.3", "test").joinToString(","))
            .build()

        // naeringskode strategy
        val naeringskodeStrategy = NaeringskodeStrategy(context)
        val parameters = HashMap<String, String>()
        parameters.put("naeringskoder", arrayOf("52.1", "61.2").joinToString(","))

        // IsNotProdStrategy
        val isNotProdStrategy = IsNotProdStrategy(context)
        val yrkesskadeMVPStrategy = YrkesskadeMVPStrategy(context, arrayOf(naeringskodeStrategy, isNotProdStrategy))

        assertThat(yrkesskadeMVPStrategy.isEnabled(parameters)).isTrue()
    }

    @Test
    fun `is not enabled - is production environment`() {
        val context: UnleashContext = UnleashContext
            .builder()
            .environment("prod")
            .addProperty(
                "naeringskoder",
                arrayOf("61.2", "56.3", "test").joinToString(","))
            .build()

        // naeringskode strategy - isEnabled
        val naeringskodeStrategy = NaeringskodeStrategy(context)
        val parameters = HashMap<String, String>()
        parameters.put("naeringskoder", arrayOf("52.1", "61.2").joinToString(","))

        // IsNotProdStrategy - !isEnabled
        val isNotProdStrategy = IsNotProdStrategy(context)
        val yrkesskadeMVPStrategy = YrkesskadeMVPStrategy(context, arrayOf(naeringskodeStrategy, isNotProdStrategy))

        assertThat(yrkesskadeMVPStrategy.isEnabled(parameters)).isFalse()
    }
}