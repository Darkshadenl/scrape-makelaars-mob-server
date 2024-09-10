package com.scrapeMakelaars.ui.activities.main

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.scrapeMakelaars.ui.composables.homescreen.MainScreen
import com.scrapeMakelaars.ui.composables.homescreen.MainViewModel
import androidx.lifecycle.viewmodel.compose.viewModel
import com.scrapeMakelaars.services.parsera.IParseraService
import com.scrapeMakelaars.services.parsera.ParseraService
import com.scrapeMakelaars.ui.theme.MyApplicationTheme
import org.koin.android.ext.android.inject

class MainActivity : ComponentActivity() {
    private val parseraService: IParseraService by inject()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)



        setContent {
            MyApplicationTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    MainActivityContent()
                }
            }
        }
    }
}


@Composable
fun MainActivityContent() {
    val viewModel: MainViewModel = viewModel()
    MainScreen(
        logEntries = viewModel.logEntries.value,
        onRefresh = { viewModel.refreshLog() }
    )
}

@Preview(showBackground = true)
@Composable
fun MainActivityPreview() {
    MyApplicationTheme {
        MainScreen(
            logEntries = listOf(
                "Log entry 1: Scraping gestart",
                "Log entry 2: Website A gescraped",
                "Log entry 3: Website B gescraped",
                "Log entry 4: Data verwerkt",
                "Log entry 5: Scraping voltooid"
            ),
            onRefresh = { /* Preview-versie doet niets bij refresh */ }
        )
    }
}