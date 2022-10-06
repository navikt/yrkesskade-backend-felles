package no.nav.yrkesskade.saksbehandling.model.pdf

data class PdfInnholdElement(
    val type: String,
    val children: List<PdfTekstElement>,
    val align: String
)

data class PdfTekstElement(val text: String)
