package com.mobileapplication.proyectoaplicacionesmoviles.components




import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.DatePicker
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.rememberDatePickerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Popup
import com.mobileapplication.proyectoaplicacionesmoviles.ui.theme.BlueSecondary
import com.mobileapplication.proyectoaplicacionesmoviles.ui.theme.Gray
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale
import java.util.TimeZone


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PrimaryDatePicker(placeholder: String, icon: Painter?) {
    var showDatePicker by remember { mutableStateOf(false) }
    val datePickerState = rememberDatePickerState()
    val selectedDate = datePickerState.selectedDateMillis?.let {
        convertMillisToDate(it)
    } ?: ""
    Box(
        modifier = Modifier.fillMaxWidth()
    ) {
        OutlinedTextField(
            value = selectedDate,
            readOnly = true,
            onValueChange = { },
            placeholder = { Text(placeholder) },
            shape = RoundedCornerShape(30.dp),
            colors = OutlinedTextFieldDefaults.colors(
                focusedPlaceholderColor = Gray,
                unfocusedPlaceholderColor = Gray,
                focusedContainerColor = Color.White,
                unfocusedContainerColor = Color.White,
                cursorColor = BlueSecondary,
                unfocusedBorderColor = BlueSecondary
            ),
            trailingIcon = {
                IconButton(onClick = { showDatePicker = !showDatePicker}) {
                    icon?.let {
                        Icon(painter = it, contentDescription = null, tint = BlueSecondary)
                    }
                }
            },
            modifier = Modifier
                .fillMaxWidth()
        )
        if (showDatePicker) {
            Popup(
                onDismissRequest = { showDatePicker = false },
                alignment = Alignment.TopStart
            ) {
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .offset(y = 64.dp)
                        .shadow(elevation = 4.dp)
                        .background(Color.White)
                        .padding(16.dp)
                ) {
                    DatePicker(state = datePickerState, showModeToggle=false)
                }
            }
        }
    }
}


fun convertMillisToDate(millis: Long): String {
    val formatter = SimpleDateFormat("MM/dd/yyyy", Locale.getDefault()).apply {
        timeZone = TimeZone.getDefault() // o TimeZone.getTimeZone("UTC")
    }
    return formatter.format(Date(millis))
}