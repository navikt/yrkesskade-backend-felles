package no.nav.yrkesskade.storage

import no.nav.yrkesskade.storage.providers.MemoryStore
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class StorageProviderTest {

    @Test
    fun `storage provider henter en store`() {
        val store = StorageProvider.getStorage(StorageType.MEMORY)
        assertThat(store.javaClass).isEqualTo(MemoryStore.javaClass)
    }

    @Test
    fun `test store funksjonalitet`() {
        val storageTyper = arrayOf(StorageType.MEMORY)

        val testBytes = "Dette er test data".toByteArray(Charsets.UTF_8)

        storageTyper.forEach {
            val store = StorageProvider.getStorage(it)
            val blob = Blob(id = "test", bruker = "test-bruker", navn = "test.test", bytes = testBytes, storrelse = testBytes.size.toLong())
            val url = store.putBlob(blob)
            assertThat(url).isNotNull()
            val hentetBlob = store.getBlob(blob)
            assertThat(hentetBlob).isNotNull()
            assertThat(hentetBlob!!.id).isEqualTo(blob.id)
            assertThat(store.deleteBlob(blob)).isTrue();
            assertThat(store.getBlob(blob)).isNull()
        }
    }

    @Test
    fun `skal returnere null dersom blob ikke finnes`() {
        val store = StorageProvider.getStorage(StorageType.MEMORY)
        val manglendeBlob = Blob("9999999", "ukjent", null, null, null)

        val resultat = store.getBlob(manglendeBlob)
        assertThat(resultat).isNull()
    }
}