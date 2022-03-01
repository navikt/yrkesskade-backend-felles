package no.nav.yrkesskade.featureflag.strategy

import no.finn.unleash.UnleashContext
import no.finn.unleash.strategy.Strategy

class NaeringskodeStrategy(private val context : UnleashContext) : Strategy {
    override fun getName(): String = "byNaeringskoder"

    override fun isEnabled(parameters: MutableMap<String, String>): Boolean {
        return isEnabled(parameters, context)
    }

    override fun isEnabled(parameters: MutableMap<String, String>, context: UnleashContext): Boolean {
        val toggledNaeringskoder = parameters.get("naeringskoder")
        if (toggledNaeringskoder == null) {
            return true
        }

        val naeringskoder = context.properties.get("naeringskoder")
        if (naeringskoder == null) {
            return false
        }

        return naeringskoder.split(",").any {
            toggledNaeringskoder.split(",").contains(it)
        }
    }
}