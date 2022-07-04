package com.dhandroid2022.projetointegrador.data.utils

import java.security.MessageDigest
import javax.crypto.Cipher.PRIVATE_KEY
import javax.crypto.Cipher.PUBLIC_KEY

object HashGenerator {

    fun getHash(ts: Long): String {
        val input: String = ts.toString() + com.dhandroid2022.projetointegrador.data.utils.PRIVATE_KEY + com.dhandroid2022.projetointegrador.data.utils.PUBLIC_KEY
        val md5 = MessageDigest.getInstance("MD5")
        return md5.digest(input.toByteArray()).toHex()
    }

    private fun ByteArray.toHex() = joinToString("") { "%02x".format(it) }

}