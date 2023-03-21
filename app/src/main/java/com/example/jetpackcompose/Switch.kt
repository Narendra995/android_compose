package com.example.jetpackcompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.Switch
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

class Switch : ComponentActivity(){

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {

        }
    }

    @Preview(showBackground = true, name = "light mode")
    @Preview(showBackground =true, name="dark mode")
    @Composable
    fun showswitch(){
        val ischecked= remember {
            mutableStateOf(true)
        }
        Switch(
            checked =ischecked.value ,
            onCheckedChange ={
            ischecked.value=it
        },
        modifier = Modifier.run {
            size(20.dp)
            padding(100.dp)
        }
        )

    }


}