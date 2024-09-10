package com.scrapeMakelaars.services.http

interface IHttpClient {
    suspend fun post(url: String, headers: Map<String, String>, body: String): String
}
