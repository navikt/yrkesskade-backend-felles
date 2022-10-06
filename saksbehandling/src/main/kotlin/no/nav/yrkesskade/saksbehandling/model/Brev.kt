package no.nav.yrkesskade.saksbehandling.model

import no.nav.yrkesskade.saksbehandling.model.pdf.PdfInnholdElement
import java.time.Instant

data class Brev(
    val dokumentkategori: String,
    val innhold: List<PdfInnholdElement>,
)

data class BrevutsendingBestiltHendelse(
    val behandlingId: Long,
    val tittel: String,
    val brevinnhold: List<PdfInnholdElement>,
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
    val behandlingId: Long,
    val journalpostId: String,
    val metadata: BrevutsendingUtfoertMetadata
)

data class BrevutsendingUtfoertMetadata(
    val navCallId: String
)