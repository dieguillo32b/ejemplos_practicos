package com.example.myapplication.ui.theme

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.myapplication.database.User
import kotlinx.coroutines.*

@Composable
fun MyApp() {
    var name by remember { mutableStateOf("") }
    var age by remember { mutableStateOf("") }
    var users by remember { mutableStateOf(listOf<User>()) }

    val scope = rememberCoroutineScope()

    Column(modifier = Modifier.padding(16.dp)) {
        TextField(
            value = name,
            onValueChange = { name = it },
            label = { Text("Name") },
            modifier = Modifier.fillMaxWidth().padding(bottom = 16.dp)
        )
        TextField(
            value = age,
            onValueChange = { age = it },
            label = { Text("Age") },
            modifier = Modifier.fillMaxWidth().padding(bottom = 16.dp)
        )
        Button(
            onClick = {
                scope.launch {
                    val user = User(name = name, age = age.toInt())
                    database.userDao().insert(user)
                    users = database.userDao().getAllUsers()
                }
            },
            modifier = Modifier.align(Alignment.CenterHorizontally).padding(bottom = 16.dp)
        ) {
            Text("Add User")
        }

        users.forEach { user ->
            Text(text = "${user.name}, ${user.age}", modifier = Modifier.padding(bottom = 8.dp))
        }
    }
}
