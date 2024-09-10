package com.scrapeMakelaars.services.http.ktor

import io.ktor.client.*
import io.ktor.client.engine.android.*
import io.ktor.client.request.*
import io.ktor.client.statement.*
import com.scrapeMakelaars.services.http.IHttpClient as IHttpClient

class KtorHttpClient : IHttpClient {

    private val client = HttpClient(Android) {
        // Configuratie hier indien nodig
    }

    override suspend fun post(url: String, headers: Map<String, String>, body: String): String {
        val response = client.post(url) {
            headers {
                headers.forEach { (key, value) ->
                    append(key, value)
                }
            }
            setBody(body)
        }
        return response.bodyAsText()
    }
}
