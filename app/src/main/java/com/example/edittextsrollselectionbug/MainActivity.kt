package com.example.edittextsrollselectionbug

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.edittextsrollselectionbug.ui.theme.EditTextSrollSelectionBugTheme
import kotlinx.coroutines.launch

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            EditTextSrollSelectionBugTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    val textFields = remember { mutableStateListOf(*Array(20) { "" }) }

                    LazyColumn(    modifier = Modifier
                        .fillMaxSize()
                        .padding(innerPadding).padding(12.dp)) {
                        items(textFields.size) { index ->
                            OutlinedTextField(
                                value = textFields[index],
                                onValueChange = { newValue -> textFields[index] = newValue },
                                label = { Text("Field${index + 1}") },
                                modifier = Modifier.fillMaxWidth().padding(vertical = 4.dp)
                            )
                        }
                    }
                }
            }
        }
    }
}