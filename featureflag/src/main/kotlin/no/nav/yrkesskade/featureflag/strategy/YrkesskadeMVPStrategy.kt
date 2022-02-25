package no.nav.yrkesskade.featureflag.strategy

import no.finn.unleash.UnleashContext
import no.finn.unleash.strategy.Strategy

/**
 * A strategy that combines a multiple other strategies. Since Unleash tests each strategy isolated,
 * it will return enabled if any of the strategies is enabled.
 *
 * This strategy ensures that all included strategies have to be enabled to return enabled
 *
 */
class YrkesskadeMVPStrategy(private val context: UnleashContext, private val strategies : Array<Strategy>) : Strategy {

    override fun getName() = "yrkesskadeMVP"

    override fun isEnabled(parameters: MutableMap<String, String>): Boolean {
        for (strategy in strategies) if (!strategy.isEnabled(parameters, context)) return false
        return true
    }
}