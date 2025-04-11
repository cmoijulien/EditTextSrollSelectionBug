package com.example.edittextsrollselectionbug

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.imePadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.edittextsrollselectionbug.ui.theme.EditTextSrollSelectionBugTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            EditTextSrollSelectionBugTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->

                    val fakeText =
                        "Lorem ipsum dolor sit amet, consectetur adipiscing elit".repeat(50)
                    val textFields = remember { mutableStateListOf(*Array(10) { fakeText }) }

                    val scrollState = rememberScrollState()

                    Column(
                        modifier = Modifier
                            .fillMaxSize()
                            .padding(innerPadding)
                            .verticalScroll(scrollState)
                            .padding(12.dp)
                            .imePadding()
                    ) {
                        textFields.forEachIndexed { index, text ->
                            OutlinedTextField(
                                value = text,
                                onValueChange = { newValue -> textFields[index] = newValue },
                                label = { Text("Field${index + 1}") },
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .padding(vertical = 4.dp)
                            )
                        }
                    }
                }
            }
        }
    }
}