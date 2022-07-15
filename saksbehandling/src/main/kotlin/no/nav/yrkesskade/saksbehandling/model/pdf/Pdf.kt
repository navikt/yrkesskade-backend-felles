package no.nav.yrkesskade.saksbehandling.model.pdf

data class PdfData(val brevtype: String, val uuid: String)

enum class PdfTemplate(val templatenavn: String) {
    VEILEDNINGSBREV_TANNLEGEERKLAERING("veiledningsbrev-tannlegeerklaering"),
    VEILEDNINGSBREV_ARBEIDSTILSYNET_KOPI("veiledningsbrev-arbeidstilsynet-kopi")
}