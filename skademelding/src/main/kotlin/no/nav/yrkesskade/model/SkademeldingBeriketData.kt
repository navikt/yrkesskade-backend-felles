package no.nav.yrkesskade.model

data class SkademeldingBeriketData(
    val innmeldersOrganisasjonsnavn: Pair<String, Systemkilde>
)

enum class Systemkilde {
    ENHETSREGISTERET
}