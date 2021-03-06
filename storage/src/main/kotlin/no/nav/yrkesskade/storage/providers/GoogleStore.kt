package no.nav.yrkesskade.storage.providers

import com.google.cloud.storage.BlobId
import com.google.cloud.storage.BlobInfo
import com.google.cloud.storage.Storage
import com.google.cloud.storage.StorageOptions
import no.nav.yrkesskade.storage.Blob
import no.nav.yrkesskade.storage.Store

object GoogleStore : Store {

    private val storage: Storage
    private val bucketName: String // definert i nais.yaml
    private val projectId: String

    init {
        storage = StorageOptions.getDefaultInstance().getService();
        projectId = System.getenv("GCP_TEAM_PROJECT_ID") // kommer fra NAIS, må settes manuelt lokalt
        bucketName = System.getenv("VEDLEGG_BUCKET_NAME")

        if (projectId == null) {
            throw InstantiationError("GCP_PROJECT_ID environment variable not set")
        }
    }

    fun getInstance() = this

    override fun putBlob(blob: Blob): String {
        val blobId = BlobId.of(bucketName, getName(blob))
        val blobInfo =
            BlobInfo.newBuilder(blobId).setMetadata(mapOf("eier" to blob.bruker, "filnavn" to blob.navn)).build()
        val gcpBlob = storage.create(blobInfo, blob.bytes)

        return gcpBlob.mediaLink
    }

    override fun getBlob(blob: Blob): Blob? {
        val gcpBlob: com.google.cloud.storage.Blob
        try {
            gcpBlob = storage[BlobId.of(bucketName, getName(blob))]
        } catch (npe: NullPointerException) {
            return null
        }

        if (gcpBlob.metadata["eier"] != blob.bruker) {
            // ikke samme person - returner null
            return null;
        }

        return Blob(blob.id, blob.bruker, gcpBlob.getContent(), gcpBlob.metadata.get("filnavn"), gcpBlob.size)
    }

    override fun deleteBlob(blob: Blob): Boolean {
        val gcpBlob: com.google.cloud.storage.Blob = storage[BlobId.of(bucketName, getName(blob))]

        if (gcpBlob.metadata.get("eier") != blob.bruker) {
            // ikke samme person
            return false
        }

        return gcpBlob.delete()

    }

    private fun getName(blob: Blob): String = "${blob.bruker}/${blob.id}"
}