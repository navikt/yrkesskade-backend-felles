package no.nav.yrkesskade.saksbehandling.model.pdf

data class PdfData(val brevtype: String, val uuid: String, val innhold: List<PdfInnholdElement>)

data class PdfInnholdElement(
    val type: String,
    val children: List<PdfTekstElement>,
    val align: String
)

data class PdfTekstElement(val text: String)

enum class PdfTemplate(val templatenavn: String) {
    VEILEDNINGSBREV_TANNLEGEERKLAERING("veiledningsbrev-tannlegeerklaering"),
    VEILEDNINGSBREV_ARBEIDSTILSYNET_KOPI("veiledningsbrev-arbeidstilsynet-kopi")
}
