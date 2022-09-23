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
    val mottaker: Mottaker,
    val metadata: BrevutsendingMetadata
)

data class Mottaker(
    val foedselsnummer: String
)

data class BrevutsendingMetadata(
    val tidspunktBestilt: Instant,
    val navCallId: String
)

data class BrevutsendingUtfoertHendelse(
    val journalpostId: String,
    val metadata: BrevutsendingUtfoertMetadata
)

data class BrevutsendingUtfoertMetadata(
    val navCallId: String
)