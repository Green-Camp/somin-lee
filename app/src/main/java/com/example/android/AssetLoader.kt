package com.example.android

import android.content.Context

class AssetLoader {

    fun getJsonString(context: Context, fileName: String): String? {
        return kotlin.runCatching { //runCatching 함수는 성공 or 실패로 나눠지는 작업에 유용함
            loadAsset(context, fileName)
        }.getOrNull()
    }

    fun loadAsset(context: Context, fileName: String): String {

        return context.assets.open(fileName).use { inputStream ->
            // use : inputStream 객체 해제 작업을 도와주는 확장함수
            val size = inputStream.available()
            val bytes = ByteArray(size)
            inputStream.read(bytes)
            String(bytes)
        }
    }
}