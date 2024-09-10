package com.scrapeMakelaars.ui.composables.homescreen

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun MainScreen(
    logEntries: List<String>,
    onRefresh: () -> Unit
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        Text(
            text = "Scraper Log",
            style = MaterialTheme.typography.headlineMedium,
            modifier = Modifier.padding(bottom = 16.dp)
        )

        Button(
            onClick = onRefresh,
            modifier = Modifier.padding(bottom = 16.dp)
        ) {
            Text("Ververs")
        }

        LogList(logEntries)
    }
}

@Composable
fun LogList(logEntries: List<String>) {
    LazyColumn {
        items(logEntries) { entry ->
            Text(
                text = entry,
                modifier = Modifier.padding(vertical = 4.dp)
            )
        }
    }
}
