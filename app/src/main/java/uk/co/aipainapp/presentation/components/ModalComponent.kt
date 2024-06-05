package uk.co.aipainapp.presentation.components

import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable

class ModalComponent {

    companion object {
        @Composable
        fun Modal(
            title: String,
            message: String,
            onDismiss: () -> Unit,
            onConfirm: () -> Unit
        ) {
            AlertDialog(
                onDismissRequest = onDismiss,
                title = { Text(title) },
                text = { Text(message) },
                confirmButton = {
                    TextButton(
                        onClick = onConfirm
                    ) {
                        Text("OK")
                    }
                }
            )
        }
    }
}
