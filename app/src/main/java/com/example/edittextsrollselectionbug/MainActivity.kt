package com.example.edittextsrollselectionbug

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
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

                    val fakeText = "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Fusce tincidunt velit diam, ut aliquet orci fringilla eget. Ut tristique risus commodo eros semper tincidunt. Donec at urna ac nibh feugiat dictum. Mauris finibus dolor vitae sapien lobortis congue. Proin fringilla arcu quis odio pharetra, vitae aliquam risus congue. Fusce euismod imperdiet varius. Maecenas sagittis orci eget tincidunt euismod. Aliquam sed erat metus. Donec laoreet sagittis quam quis auctor. Praesent iaculis quis orci vel congue. Mauris metus risus, efficitur at elit vel, vulputate mattis sem. Nam sit amet nisl venenatis mi ultricies tincidunt.\n" +
                            "\n" +
                            "Fusce at est non nibh porttitor sodales ut ut nisl. Phasellus dapibus consequat nibh nec gravida. Aenean dolor nulla, euismod eu tortor quis, malesuada rhoncus dolor. Fusce facilisis tellus vitae mi tincidunt, a eleifend tellus tristique. Vestibulum sed sapien in erat pulvinar tempus et non metus. Vivamus dapibus odio sed urna sagittis porttitor. Donec id metus convallis, scelerisque nulla eget, dictum diam. Nullam quis egestas lacus. Nunc luctus, tellus eu tincidunt fringilla, tortor nisi consequat nisi, a tempor lectus sem vel erat. Morbi magna sem, ullamcorper nec tincidunt vel, laoreet at massa. Nam dui ipsum, ultricies convallis vulputate vitae, scelerisque sit amet sapien. Integer ultricies augue sit amet quam vestibulum, eget scelerisque turpis cursus.\n" +
                            "\n" +
                            "Phasellus vehicula erat tempor metus pellentesque vulputate. Nullam eu lorem ac purus ultricies aliquam at a orci. Phasellus luctus, erat in egestas porttitor, felis mi commodo tortor, vel pulvinar felis augue ut libero. Ut euismod sodales gravida. Proin tempus non ligula sit amet porta. Suspendisse blandit sodales urna, nec efficitur est pulvinar sed. Morbi dapibus erat ipsum, ut semper ligula dignissim eu. Phasellus quis nulla sed urna sagittis vestibulum. Maecenas in vehicula velit. Sed lacus est, dictum sit amet nulla molestie, sollicitudin luctus nisl.\n" +
                            "\n" +
                            "Curabitur id ipsum vehicula, scelerisque nisi id, congue eros. Nunc finibus ut neque ac molestie. Ut ac dolor finibus, eleifend ante non, gravida dui. Ut dapibus gravida nulla, nec aliquet arcu posuere quis. Phasellus lacus justo, sollicitudin eu congue in, tempor pellentesque massa. Pellentesque habitant morbi tristique senectus et netus et malesuada fames ac turpis egestas. Vivamus feugiat tellus sit amet dui vulputate eleifend. Cras lacinia nulla vitae velit lacinia, vel pulvinar lacus tristique. Sed suscipit ante viverra lorem consectetur, in placerat nibh mattis. Morbi mollis suscipit fringilla. Phasellus mollis tempor neque ac suscipit. Suspendisse laoreet tincidunt nunc in mollis. Donec in gravida elit. Nullam tempus non augue vel rutrum. Nulla facilisi.\n" +
                            "\n" +
                            "In vitae dui non turpis varius varius eu vehicula arcu. Quisque vel ullamcorper magna, ac laoreet nulla. Integer in finibus ante. Maecenas feugiat urna non velit luctus accumsan. Nunc blandit mi nibh. Phasellus consectetur libero id leo egestas sagittis. Fusce tortor risus, convallis id ex luctus, suscipit gravida mauris. Vestibulum massa sem, mollis et nisi sed, tincidunt interdum felis. Donec scelerisque massa sit amet odio volutpat bibendum. Pellentesque tincidunt pulvinar est, a accumsan diam facilisis ac. Ut quis leo nisl. Mauris consectetur urna sit amet magna ultricies interdum."

                    val textFields = remember { mutableStateListOf(*Array(10) {  fakeText }) }

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