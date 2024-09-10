package com.scrapeMakelaars.services.parsera

import com.google.gson.Gson
import com.scrapeMakelaars.models.data.Attribute
import com.scrapeMakelaars.models.data.ParseraRequest
import com.scrapeMakelaars.models.data.ParseraResponse
import com.scrapeMakelaars.services.http.IHttpClient

class ParseraService(private val httpClient: IHttpClient, private val apiKey: String) : IParseraService {
    private val gson = Gson()

    override suspend fun extractData(url: String, attributes: List<Attribute>, proxyCountry: String): ParseraResponse {
        val requestBody = ParseraRequest(url, attributes, proxyCountry)

        val response = httpClient.post(
            "https://api.parsera.org/v1/extract",
            mapOf(
                "Content-Type" to "application/json",
                "X-API-KEY" to apiKey
            ),
            requestBody.toString()
        )

        return gson.fromJson(response, ParseraResponse::class.java)
    }
}
