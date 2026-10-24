package com.example.evaluacionapp.ui.components.atoms
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun MPAZTextField(
    value: String,
    onValueChange: (String) -> Unit,
    label: String,
    modifier: Modifier = Modifier,
    isPassword: Boolean = false,
    isError: Boolean = false,
    supportingText: String? = null,
    enabled: Boolean = true
) {
    OutlinedTextField(
        value = value,
        onValueChange = onValueChange,
        label = { Text(label) },
        modifier = modifier
            .fillMaxWidth() // Modificador requerido
            .heightIn(min = 56.dp), // Altura mínima requerida
        enabled = enabled, // Estado deshabilitado
        isError = isError, // Estado de error
        shape = RoundedCornerShape(12.dp), // Radio de 12dp[cite: 1]
        textStyle = TextStyle(fontSize = 16.sp), // Texto de 16sp[cite: 1]
        visualTransformation = if (isPassword) {
            PasswordVisualTransformation() // Ocultar contraseña[cite: 1]
        } else {
            VisualTransformation.None
        },
        supportingText = supportingText?.let {
            { Text(text = it) } // Muestra el mensaje de ayuda o error[cite: 1]
        }
    )
}