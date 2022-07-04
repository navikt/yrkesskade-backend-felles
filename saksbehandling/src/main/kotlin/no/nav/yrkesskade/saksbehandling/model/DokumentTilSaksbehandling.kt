package no.nav.yrkesskade.saksbehandling.model

data class DokumentTilSaksbehandling(
    val journalpostId: String,
    val enhet: String,
    val metadata: DokumentTilSaksbehandlingMetadata
)

data class DokumentTilSaksbehandlingMetadata(
    val callId: String
)