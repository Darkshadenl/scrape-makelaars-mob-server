package com.scrapeMakelaars.models.data


data class ParseraRequest(
    val url: String,
    val attributes: List<Attribute>,
    val proxy_country: String
)

data class Attribute(
    val name: String,
    val description: String
)

data class ParseraResponse(
    val data: List<Map<String, String>>
)
