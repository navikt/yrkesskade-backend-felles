package no.nav.yrkesskade.storage.providers

import no.nav.yrkesskade.storage.Blob
import no.nav.yrkesskade.storage.Store

object MemoryStore : Store {

    private val storage: HashMap<String, Blob>

    init {
        storage = HashMap()
    }

    fun getInstance(): Store = this;

    override fun putBlob(blob: Blob): String {
        storage.put(blob.id, blob)

        return "/blob/${blob.id}"
    }

    override fun getBlob(blob: Blob): Blob? {
        return storage.get(blob.id)

    }

    override fun deleteBlob(blob: Blob): Boolean {
        if (!storage.containsKey(blob.id)) {
            return false
        }

        storage.remove(blob.id)
        return true
    }
}