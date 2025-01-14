package com.example.holajetpack

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.PreviewScreenSizes
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.holajetpack.ui.theme.HolaJetpackTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            HolaJetpackTheme {
                Scaffold( modifier = Modifier.fillMaxSize() ) { innerPadding ->
                    Column {
                        Greeting(
                            name = "Android",
                            modifier = Modifier.padding(innerPadding)
                        )
                        Hola()
                        Disenios()
                        ColumnasFilas()
                    }
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

//@PreviewScreenSizes
@Preview(showBackground = true)
@Composable
fun Hola() {
    HolaJetpackTheme {
        Text("Hello DAM!", modifier = Modifier.padding(24.dp))
    }
}

@Preview(showBackground = true)
@Composable
fun Disenios() {
    HolaJetpackTheme {
        Text(
            "DAM!",
            fontSize = 90.sp,
            lineHeight = 116.sp,
            modifier = Modifier.padding(16.dp).background(Color.LightGray).padding(16.dp)
            )
    }
}

@Preview(showBackground = true)
@Composable
fun ColumnasFilas() {
    HolaJetpackTheme {
        Column {
            Text("hello DAM!")
            Text("hola DAM!")
            Text("hey DAM!")
            Row {
                Text("hello DAM!")
                Text("ei DAM!")
                Text("ke pasa DAM!")
                Text("alo DAM!")
            }
        }
    }
}

