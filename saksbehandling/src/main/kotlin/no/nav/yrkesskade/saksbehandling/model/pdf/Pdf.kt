package no.nav.yrkesskade.saksbehandling.model.pdf

data class PdfData(val brevtype: String, val uuid: String)

enum class PdfTemplate(val templatenavn: String) {
    TANNLEGEERKLAERING_VEILEDNING("tannlegeerklaering-veiledning"),
    ARBEIDSTILSYNET_KOPI_VEILEDNING("arbeidstilsynet-kopi-veiledning")
}