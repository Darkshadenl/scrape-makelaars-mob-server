package com.scrapeMakelaars.services.parsera

import com.scrapeMakelaars.models.data.Attribute
import com.scrapeMakelaars.models.data.ParseraResponse

interface IParseraService {
    suspend fun extractData(url: String, attributes: List<Attribute>, proxyCountry: String): ParseraResponse
}
