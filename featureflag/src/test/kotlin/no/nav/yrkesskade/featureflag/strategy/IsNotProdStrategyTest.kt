package no.nav.yrkesskade.featureflag.strategy

import no.finn.unleash.UnleashContext
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class IsNotProdStrategyTest {

    @Test
    fun `is enabled - er ikke prod`() {
        val context: UnleashContext = UnleashContext
            .builder()
            .environment("test")
            .build()

        val isNotProdStrategy = IsNotProdStrategy(context)
       assertThat(isNotProdStrategy.isEnabled(HashMap(), context)).isTrue()
    }

    @Test
    fun `is enabled - environment ikke satt`() {
        val context: UnleashContext = UnleashContext
            .builder()
            .build()

        val isNotProdStrategy = IsNotProdStrategy(context)
        assertThat(isNotProdStrategy.isEnabled(HashMap(), context)).isTrue()
    }

    @Test
    fun `is disabled - er prod`() {
        val context: UnleashContext = UnleashContext
            .builder()
            .environment("prod")
            .build()

        val isNotProdStrategy = IsNotProdStrategy(context)
        assertThat(isNotProdStrategy.isEnabled(HashMap(), context)).isFalse()
    }
}