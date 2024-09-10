package com.scrapeMakelaars.inversion

import com.scrapeMakelaars.services.http.IHttpClient
import com.scrapeMakelaars.services.http.ktor.KtorHttpClient
import com.scrapeMakelaars.services.parsera.ParseraService
import com.scrapeMakelaars.ui.composables.homescreen.MainViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val appModule = module {
    single { KtorHttpClient() }
    single { ParseraService(get(), "jouw_api_key_hier") }
    viewModel { MainViewModel() }
}
