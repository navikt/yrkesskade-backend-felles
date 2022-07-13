package no.nav.yrkesskade.saksbehandling.model

import java.time.Instant

data class Brev(
    val tittel: String,
    val brevkode: String,
    val enhet: String,
    val template: String,
    val tekst: String,
)

data class BrevutsendingBestiltHendelse(
    val brev: Brev,
    val metadata: BrevutsendingMetadata
)

data class BrevutsendingMetadata(
    val innkommendeJournalpostId: String,
    val tidspunktBestilt: Instant,
    val navCallId: String
)
