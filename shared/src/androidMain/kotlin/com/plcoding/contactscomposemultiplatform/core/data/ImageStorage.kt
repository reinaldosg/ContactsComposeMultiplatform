package com.plcoding.contactscomposemultiplatform.core.data

import android.content.Context
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import java.util.UUID

actual class ImageStorage(
    private val context: Context
) {
    actual suspend fun saveImage(bytes: ByteArray): String {
        return withContext(Dispatchers.IO) {
            val filename = UUID.randomUUID().toString() + ".jpg"
            context.openFileOutput(filename, Context.MODE_PRIVATE).use { outputStream ->
                outputStream.write(bytes)
            }
            filename
        }
    }

    actual suspend fun getImage(filename: String): ByteArray? {
        return withContext(Dispatchers.IO) {
            context.openFileInput(filename).use { inputStream ->
                inputStream.readBytes()
            }
        }
    }

    actual suspend fun deleteImage(filename: String) {
        return withContext(Dispatchers.IO) {
            context.deleteFile(filename)
        }
    }
}