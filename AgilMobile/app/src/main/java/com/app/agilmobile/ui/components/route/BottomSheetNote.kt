package com.app.agilmobile.ui.components.route

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.material3.rememberModalBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.app.agilmobile.ui.components.general.buttons.ButtonStandard
import com.app.agilmobile.ui.theme.Black30
import com.app.agilmobile.ui.theme.Orange
import com.example.composeapp.ui.viewmodels.NavigationViewModel
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun BottomSheetNote(onDismiss: () -> Unit, viewModel: NavigationViewModel = viewModel()) {
    val noteText by viewModel.noteText
    val sheetState = rememberModalBottomSheetState()
    val scope = rememberCoroutineScope()

    ModalBottomSheet(
        onDismissRequest = onDismiss,
        sheetState = sheetState,
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 10.dp)
        ) {
            Row(
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier
                    .padding(vertical = 10.dp)
                    .fillMaxWidth()
            ) {
                Text(
                    text = "Adicionar Nota",
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color.Black
                )

                IconButton(onClick = onDismiss) {
                    Icon(
                        imageVector = Icons.Default.Close,
                        contentDescription = "Icon Close",
                        modifier = Modifier
                            .clip(RoundedCornerShape(50.dp))
                            .size(30.dp)
                            .background(Black30)
                            .padding(4.dp)
                    )
                }
            }

            TextField(
                value = noteText,
                onValueChange = { viewModel.updateNoteText(it) },
                modifier = Modifier
                    .clip(RoundedCornerShape(10.dp))
                    .fillMaxWidth()
                    .background(Color.White)
                    .height(200.dp)
                    .padding(16.dp),
                placeholder = { Text("Digite sua nota aqui") },
                maxLines = 15,
                singleLine = false,
                colors = TextFieldDefaults.colors(
                    focusedIndicatorColor = Color.Transparent,
                    unfocusedIndicatorColor = Color.Transparent,
                    unfocusedContainerColor = Color.Transparent
                )
            )

            Spacer(modifier = Modifier.height(16.dp))

            ButtonStandard(
                text = "Salvar",
                onClick = { /*TODO*/ },
                buttonColor = Orange,
                textColor = Color.White,
                cornerRadius = 12
            )

        }
    }

    LaunchedEffect(viewModel.isNoteModalOpen.value) {
        if (!viewModel.isNoteModalOpen.value) {
            scope.launch { sheetState.hide() }
        }
    }
}
