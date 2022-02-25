package no.nav.yrkesskade.unleash

import no.finn.unleash.strategy.Strategy

class ByClusterStrategy(private val clusterName: String) : Strategy {

    override fun isEnabled(parameters: MutableMap<String, String>): Boolean {
        if (parameters.isEmpty()) return false
        return parameters["cluster"]?.contains(clusterName) ?: false
    }

    override fun getName(): String = "byCluster"
}