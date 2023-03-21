package com.example.jetpackcompose

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Info
import androidx.compose.material.icons.filled.Person
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

class LoginActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            loginform()
        }
    }

    @Preview
    @Composable
    fun loginform() {
        val username = remember { mutableStateOf(" ")
        }
        val password = remember { mutableStateOf("") }
        Column(modifier = Modifier
            .fillMaxSize()
            .padding(30.dp),
            verticalArrangement= Arrangement.Center

        ) {

            Text(
                text = "Welcome to Bhavna Corp",
                color = Color.Cyan,
                fontFamily = FontFamily.Monospace,
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold,
                textAlign = TextAlign.Center,
                textDecoration = TextDecoration.Underline
            )
            OutlinedTextField(
                value = username.value,
                onValueChange ={
                    username.value= it
                },
                leadingIcon = {
                    Icon(Icons.Default.Person, contentDescription = "person")
                },
                label = {
                    Text(text = "UserName")
                },
                placeholder ={ "Enter your name"},
                modifier = Modifier.fillMaxWidth()

            )

            OutlinedTextField(
                value = password.value,
                onValueChange ={
                    password.value= it
                },
                leadingIcon = {
                    Icon(Icons.Default.Info, contentDescription = "password")
                },
                label = {
                    Text(text = "Password  ")
                },
                placeholder ={ "Enter your name"},
                modifier = Modifier.fillMaxWidth()


            )
            Spacer(modifier = Modifier.height(10.dp))

            OutlinedButton(onClick = {login(username.value,password.value)}
            , modifier = Modifier.fillMaxWidth()


            )
            {
                  Text(text = "Login")
            }




        }

    }
    private fun login(username:String,password:String){
        if(username=="bhavna" && password=="12345"){
            val intent= Intent(this,MainActivity::class.java)
            startActivity(intent)
        }else{
            Toast.makeText(this,"Username or Password incorrect !!",Toast.LENGTH_SHORT).show()

        }
    }
}