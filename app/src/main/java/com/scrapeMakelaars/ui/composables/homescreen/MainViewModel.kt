package com.scrapeMakelaars.ui.composables.homescreen

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch

class MainViewModel : ViewModel() {
    private val _logEntries = mutableStateOf<List<String>>(emptyList())
    val logEntries: State<List<String>> = _logEntries

    init {
        refreshLog()
    }

    fun refreshLog() {
        viewModelScope.launch {
            // Hier zou je normaal gesproken de log ophalen van een repository of service
            // Voor nu simuleren we wat log-entries
            _logEntries.value = listOf(
                "Log entry 1: Scraping gestart",
                "Log entry 2: Website A gescraped",
                "Log entry 3: Website B gescraped",
                "Log entry 4: Data verwerkt",
                "Log entry 5: Scraping voltooid"
            )
        }
    }

}
