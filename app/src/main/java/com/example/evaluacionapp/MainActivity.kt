package com.example.evaluacionapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

// Importamos tu componente personalizado (ajusta la ruta si el paquete cambia)
import com.example.evaluacionapp.ui.components.atoms.MPAZTextField
import com.example.evaluacionapp.ui.theme.EvaluacionAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            EvaluacionAppTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    PruebaCamposScreen(
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}

@Composable
fun PruebaCamposScreen(modifier: Modifier = Modifier) {
    var textoNormal by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }

    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        Text(
            text = "Prueba de MPAZTextField",
            style = MaterialTheme.typography.headlineSmall
        )

        Spacer(modifier = Modifier.height(16.dp))

        // 1. Campo Vacío / Con texto
        MPAZTextField(
            value = textoNormal,
            onValueChange = { textoNormal = it },
            label = "Nombre de usuario"
        )

        Spacer(modifier = Modifier.height(16.dp))

        // 2. Campo tipo Contraseña (oculta el texto)
        MPAZTextField(
            value = password,
            onValueChange = { password = it },
            label = "Contraseña",
            isPassword = true
        )

        Spacer(modifier = Modifier.height(16.dp))

        // 3. Campo con Estado de Error
        MPAZTextField(
            value = "texto@invalido",
            onValueChange = {},
            label = "Correo electrónico",
            isError = true,
            supportingText = "El formato del correo es incorrecto"
        )

        Spacer(modifier = Modifier.height(16.dp))

        // 4. Campo Deshabilitado
        MPAZTextField(
            value = "No editable",
            onValueChange = {},
            label = "Campo bloqueado",
            enabled = false
        )
    }
}

@Preview(showBackground = true)
@Composable
fun MPAZTextFieldPreview() {
    EvaluacionAppTheme {
        PruebaCamposScreen()
    }
}