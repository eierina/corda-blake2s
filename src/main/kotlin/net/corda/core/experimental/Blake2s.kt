package net.corda.core.experimental

import org.bouncycastle.crypto.digests.Blake2sDigest
import net.corda.core.crypto.DigestAlgorithm

class BLAKE2s256DigestService : DigestAlgorithm {
    override val algorithm = "BLAKE_TEST"

    override val digestLength = 32

    override fun digest(bytes: ByteArray): ByteArray {
        val blake2s256 = Blake2sDigest(null, digestLength, null, "12345678".toByteArray())
        blake2s256.reset()
        blake2s256.update(bytes, 0, bytes.size)
        val hash = ByteArray(digestLength)
        blake2s256.doFinal(hash, 0)
        return hash
    }
}