package no.nav.yrkesskade.storage

interface Store {
    fun putBlob(blob: Blob): String
    fun getBlob(blob: Blob): Blob?
    fun deleteBlob(blob: Blob): Boolean
}