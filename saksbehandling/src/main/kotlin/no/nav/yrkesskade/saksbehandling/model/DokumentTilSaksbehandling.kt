package no.nav.yrkesskade.saksbehandling.model

data class DokumentTilSaksbehandlingHendelse(
    val dokumentTilSaksbehandling: DokumentTilSaksbehandling,
    val dokumentTilSaksbehandlingMetadata: DokumentTilSaksbehandlingMetadata
)

data class DokumentTilSaksbehandling(
    val journalpostId: String,
    val enhet: String,
    val metadata: DokumentTilSaksbehandlingMetadata
)

data class DokumentTilSaksbehandlingMetadata(
    val callId: String
)