package com.scrapeMakelaars.inversion

import com.scrapeMakelaars.BuildConfig
import com.scrapeMakelaars.services.http.ktor.KtorHttpClient
import com.scrapeMakelaars.services.parsera.ParseraService
import com.scrapeMakelaars.ui.composables.homescreen.MainViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val appModule = module {
    val parsera_key: String = BuildConfig.PARSERA_API_KEY

    single { KtorHttpClient() }
    single { ParseraService(get(), parsera_key) }
    viewModel { MainViewModel(get()) }
}
