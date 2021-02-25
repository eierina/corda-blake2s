package net.corda.core.experimental

import net.corda.core.crypto.DigestAlgorithm
import org.bouncycastle.jcajce.provider.digest.SHA3.DigestSHA3
import org.bouncycastle.jcajce.provider.digest.SHA3.Digest256

import java.security.MessageDigest

class SHA2SHA3256DigestService : DigestAlgorithm {
    override val algorithm = "SHA2SHA3256"

    override val digestLength = 32

    private fun sha2_256Digest(bytes: ByteArray) : ByteArray {
        val digest = MessageDigest.getInstance("SHA-256")
        return digest.digest(bytes)
    }

    private fun sha3_256Digest(bytes: ByteArray) : ByteArray {
        val sha3: DigestSHA3 = Digest256()
        return sha3.digest(bytes)
    }

    override fun digest(bytes: ByteArray): ByteArray = sha2_256Digest(bytes)

    override fun componentDigest(bytes: ByteArray): ByteArray = sha3_256Digest(bytes)

    override fun nonceDigest(bytes: ByteArray): ByteArray = sha3_256Digest(bytes)
}
