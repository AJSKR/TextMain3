package com.example.textmain3

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.LocalContentColor
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.textmain3.ui.theme.TextMain3Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            TextMain3Theme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    page_main("Android")
                }
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun page_main(name: String, modifier: Modifier = Modifier) {
    val (state_before, set_state_before) = rememberSaveable { //not too many rememberSaveable(s)
        mutableStateOf("")
    }
    var state_after by rememberSaveable { //by (delegated property) will give easy obj to use (setter, repr)
        mutableStateOf("")
    }
    Row( //ctrl+alt+l : auto formatting
        modifier = Modifier
    ) {//trailing lambda in Kotlin
        Column(
            modifier = Modifier
                .weight(60F)
                .fillMaxHeight()
        )
        {

            OutlinedTextField(
                modifier = Modifier.weight(50F),
                value = state_before,
                onValueChange = set_state_before,
                label = { Text(text = "Before") }
            )
            OutlinedTextField(
                modifier = Modifier.weight(50F),
                value = state_after,
                onValueChange = {},
                label = { Text(text = "After") }
            )
        }
        Column(
            modifier = Modifier
                .width(100.dp)
                .verticalScroll(rememberScrollState())
        ) {
            Button(onClick = {}){ Text(text = "붙넣")}
            repeat(30) {
                Button(onClick = {}) {
                    Text(text = "${it+1}")
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun page_main_Preview() {
    TextMain3Theme {
        page_main("Android")
    }
}