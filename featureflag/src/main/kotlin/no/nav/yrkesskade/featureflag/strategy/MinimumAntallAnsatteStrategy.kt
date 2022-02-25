package no.nav.yrkesskade.featureflag.strategy

import no.finn.unleash.UnleashContext
import no.finn.unleash.strategy.Strategy

class MinimumAntallAnsatteStrategy(private val context: UnleashContext) : Strategy {
    override fun getName(): String = "byMinimumAntall"

    override fun isEnabled(parameters: MutableMap<String, String>): Boolean {
        val paramMinAntall = parameters.get("minimumAntallAnsatte")?.toIntOrNull()
        if (paramMinAntall == null || paramMinAntall <= 0) {
            return true;
        }

        val antallAnsatte = context.properties.get("antallAnsatte")?.toIntOrNull()
        if (antallAnsatte == null || antallAnsatte <= 0) {
            return false
        }

        return antallAnsatte >= paramMinAntall
    }
}