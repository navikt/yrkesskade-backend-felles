package no.nav.yrkesskade.storage

import no.nav.yrkesskade.storage.providers.GoogleStore
import no.nav.yrkesskade.storage.providers.MemoryStore

object StorageProvider {

    fun getStorage(type: StorageType): Store = when (type) {
        StorageType.MEMORY -> MemoryStore.getInstance()
        StorageType.GCP -> GoogleStore.getInstance()
    }
}

enum class StorageType {
    MEMORY,
    GCP
}