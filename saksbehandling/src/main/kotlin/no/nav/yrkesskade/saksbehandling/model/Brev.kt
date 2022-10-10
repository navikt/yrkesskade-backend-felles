package no.nav.yrkesskade.saksbehandling.model

import no.nav.yrkesskade.saksbehandling.model.pdf.PdfInnholdElement
import java.time.Instant
import java.time.LocalDate

data class Brev(
    val dokumentkategori: String,
    val innhold: Brevinnhold
)

data class Brevinnhold(
    val navn: String,
    val dato: LocalDate,
    val tekst: List<PdfInnholdElement>
)

data class BrevutsendingBestiltHendelse(
    val behandlingId: Long,
    val enhet: String,
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