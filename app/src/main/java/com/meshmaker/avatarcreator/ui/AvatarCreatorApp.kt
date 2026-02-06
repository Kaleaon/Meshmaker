package com.meshmaker.avatarcreator.ui

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.Divider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Slider
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateMapOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.meshmaker.avatarcreator.model.AvatarOptions
import com.meshmaker.avatarcreator.model.SliderSpec

@Composable
fun AvatarCreatorApp() {
    MaterialTheme {
        Scaffold(
            topBar = {
                TopAppBar(
                    title = { Text("Meshmaker Avatar Creator") }
                )
            }
        ) { padding ->
            AvatarCreatorScreen(Modifier.padding(padding))
        }
    }
}

@Composable
private fun AvatarCreatorScreen(modifier: Modifier = Modifier) {
    val sliderValues = remember {
        mutableStateMapOf<String, Float>().apply {
            AvatarOptions.sliderSpecs.forEach { put(it.id, it.default) }
        }
    }

    Column(
        modifier = modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
            .padding(16.dp)
    ) {
        Text(
            text = "Second Life Base Mesh Avatar Builder",
            style = MaterialTheme.typography.headlineSmall,
            fontWeight = FontWeight.Bold
        )
        Spacer(modifier = Modifier.height(8.dp))
        Text(
            text = "Adjust detailed anatomy sliders and swap modular parts. " +
                "Export generates a seamless SL-ready avatar or clothing set.",
            style = MaterialTheme.typography.bodyMedium
        )
        Spacer(modifier = Modifier.height(16.dp))

        SectionHeader(title = "Anatomy Sliders")
        val grouped = AvatarOptions.sliderSpecs.groupBy { it.category }
        grouped.forEach { (category, sliders) ->
            CategoryCard(title = category) {
                sliders.forEach { slider ->
                    val value = sliderValues[slider.id] ?: slider.default
                    SliderRow(
                        slider = slider,
                        value = value,
                        onValueChange = { sliderValues[slider.id] = it }
                    )
                }
            }
        }

        Spacer(modifier = Modifier.height(16.dp))
        SectionHeader(title = "Swappable Parts")
        val partGroups = AvatarOptions.swapParts.groupBy { it.category }
        partGroups.forEach { (category, parts) ->
            CategoryCard(title = category) {
                parts.forEach { part ->
                    Text(
                        text = "• ${part.label}",
                        style = MaterialTheme.typography.bodyMedium
                    )
                }
            }
        }

        Spacer(modifier = Modifier.height(16.dp))
        SectionHeader(title = "Export")
        Card(
            modifier = Modifier.fillMaxWidth(),
            colors = androidx.compose.material3.CardDefaults.cardColors(
                containerColor = MaterialTheme.colorScheme.surfaceColorAtElevation(1.dp)
            )
        ) {
            Column(modifier = Modifier.padding(16.dp)) {
                Text(
                    text = "Generate final avatar package",
                    style = MaterialTheme.typography.titleMedium,
                    fontWeight = FontWeight.SemiBold
                )
                Spacer(modifier = Modifier.height(8.dp))
                Text(
                    text = "Exports will include the mesh, textures, and wearable clothing sets " +
                        "built on the Second Life skeleton.",
                    style = MaterialTheme.typography.bodySmall
                )
                Spacer(modifier = Modifier.height(12.dp))
                Row(
                    horizontalArrangement = Arrangement.spacedBy(12.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Button(onClick = {}) {
                        Text("Export Avatar")
                    }
                    Button(onClick = {}) {
                        Text("Export Clothing")
                    }
                }
            }
        }
    }
}

@Composable
private fun SectionHeader(title: String) {
    Text(
        text = title,
        style = MaterialTheme.typography.titleLarge,
        fontWeight = FontWeight.Bold
    )
    Spacer(modifier = Modifier.height(8.dp))
}

@Composable
private fun CategoryCard(
    title: String,
    content: @Composable () -> Unit
) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(bottom = 12.dp),
        colors = androidx.compose.material3.CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.surfaceColorAtElevation(1.dp)
        )
    ) {
        Column(modifier = Modifier.padding(16.dp)) {
            Text(
                text = title,
                style = MaterialTheme.typography.titleMedium,
                fontWeight = FontWeight.SemiBold
            )
            Divider(modifier = Modifier.padding(vertical = 8.dp))
            content()
        }
    }
}

@Composable
private fun SliderRow(
    slider: SliderSpec,
    value: Float,
    onValueChange: (Float) -> Unit
) {
    Column(modifier = Modifier.padding(vertical = 8.dp)) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Text(text = slider.label, style = MaterialTheme.typography.bodyMedium)
            Text(text = "%.2f".format(value), style = MaterialTheme.typography.bodySmall)
        }
        Slider(
            value = value,
            onValueChange = onValueChange,
            valueRange = slider.min..slider.max
        )
    }
}
