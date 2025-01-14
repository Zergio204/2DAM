package com.example.ejem02_variables

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.selection.selectable
import androidx.compose.foundation.selection.selectableGroup
import androidx.compose.material3.Button
import androidx.compose.material3.RadioButton
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.semantics.Role
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            InterfazPrincipal()
        }
    }
}

@Composable
fun InterfazPrincipal() {
    var contadorEdad by rememberSaveable { mutableStateOf(0) }
    var nombre by rememberSaveable { mutableStateOf("") }
    val opcionesRadio = listOf("Hombre", "Mujer")
    val (opcionSeleccionada, onOpcionSeleccionada) = rememberSaveable { mutableStateOf(opcionesRadio[0]) }
    var persona: Persona = Persona(nombre, contadorEdad, opcionSeleccionada == "Hombre")
    var isSet by rememberSaveable { mutableStateOf(false) }

    Column {
        if (!isSet) {
            Row(
                modifier = Modifier
                    .padding(20.dp)
                    .fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = "Hola",
                    modifier = Modifier.weight(0.25f)
                )
                TextField(
                    value = nombre,
                    onValueChange = { nombre = it },
                    modifier = Modifier.weight(0.75f)
                )
            }

            Row(
                modifier = Modifier
                    .padding(20.dp)
                    .fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Button(
                    onClick = {
                        contadorEdad++
                        Log.d("depurando", "Hola")
                    }
                ) {
                    Text(text = "Pulsar para incrementar")
                }
                Text(text = contadorEdad.toString())
            }

            Column(
                modifier = Modifier
                    .padding(20.dp)
                    .fillMaxWidth()
                    .selectableGroup()
            ) {
                opcionesRadio.forEach { texto ->
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(56.dp)
                            .selectable(
                                selected = (texto == opcionSeleccionada),
                                onClick = { onOpcionSeleccionada(texto) },
                                role = Role.RadioButton
                            )
                            .padding(horizontal = 16.dp),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        RadioButton(
                            selected = (texto == opcionSeleccionada),
                            onClick = null
                        )
                        Text(
                            text = texto,
                            modifier = Modifier.padding(start = 16.dp)
                        )
                    }
                }
            }

            Row(
                modifier = Modifier
                    .padding(20.dp)
                    .fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Center
            ) {
                Button(
                    onClick = {
                        persona = Persona(nombre, contadorEdad, opcionSeleccionada == "Hombre")
                        Log.d("depurando", persona.saludar())
                        isSet = true
                    }
                ) {
                    Text(text = "Saludar")
                }
            }
        } else {
            MostrarSaludo(
                persona = persona,
                onVolverClick = { isSet = false }
            )
        }
    }
}

@Composable
fun MostrarSaludo(
    persona: Persona,
    onVolverClick: () -> Unit
) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(20.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(
            text = persona.saludar(),
            modifier = Modifier.padding(bottom = 16.dp)
        )

        Button(
            onClick = onVolverClick
        ) {
            Text(text = "Volver")
        }
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    InterfazPrincipal()
}