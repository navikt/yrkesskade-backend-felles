package no.nav.yrkesskade.saksbehandling.model

import no.nav.yrkesskade.saksbehandling.model.pdf.PdfData
import no.nav.yrkesskade.saksbehandling.model.pdf.PdfTemplate
import java.time.Instant

data class Brev(
    val tittel: String,
    val brevkode: String,
    val enhet: String,
    val template: PdfTemplate,
    val innhold: PdfData,
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
