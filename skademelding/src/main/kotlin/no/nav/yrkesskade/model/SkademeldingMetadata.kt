package no.nav.yrkesskade.model

import java.time.Instant

data class SkademeldingMetadata(
    val kilde: String,
    val tidspunktMottatt: Instant,
    val spraak: Spraak,
    val navCallId: String
)

enum class Spraak {
    NB, NN, EN
}