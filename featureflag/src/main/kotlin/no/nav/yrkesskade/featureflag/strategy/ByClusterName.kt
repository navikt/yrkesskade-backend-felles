package no.nav.yrkesskade.featureflag.strategy

import no.finn.unleash.strategy.Strategy

class ByClusterName(private val clusterName: String) : Strategy {

    override fun isEnabled(parameters: MutableMap<String, String>): Boolean {
        if (parameters.isEmpty()) return false
        return parameters["cluster"]?.contains(clusterName) ?: false
    }

    override fun getName(): String = "byCluster"
}