package no.nav.yrkesskade.featureflag.strategy

import no.finn.unleash.UnleashContext
import no.finn.unleash.strategy.Strategy

class IsNotProdStrategy(private val context : UnleashContext) : Strategy {
    override fun getName(): String = "isNotProd"

    override fun isEnabled(parameters: MutableMap<String, String>): Boolean {
        return isEnabled(parameters, context)
    }

    override fun isEnabled(parameters: MutableMap<String, String>, context: UnleashContext): Boolean {
        val env = context.environment.orElse("");

        return !env.equals("prod", true)
    }

}