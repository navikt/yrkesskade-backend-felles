package no.nav.yrkesskade.saksbehandling.model

data class DokumentTilSaksbehandlingHendelse(
    val dokumentTilSaksbehandling: DokumentTilSaksbehandling,
    val metadata: DokumentTilSaksbehandlingMetadata
)

data class DokumentTilSaksbehandling(
    val journalpostId: String,
    val enhet: String,
)

data class DokumentTilSaksbehandlingMetadata(
    val callId: String
)