package com.example.jetpackcompose

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.jetpackcompose.ui.theme.JetpackComposeTheme

class MainActivity : ComponentActivity() {
    @SuppressLint("UnusedMaterialScaffoldPaddingParameter")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            //  Title()
            ShowUserList()
            // RecyclerList()
            settoolbar()


        }
    }

    @SuppressLint("UnusedMaterialScaffoldPaddingParameter")
    @Preview(showBackground = true)
    @Composable
    fun settoolbar() {
        JetpackComposeTheme() {

            Scaffold(
                topBar = {
                    TopAppBar(
                        title = {
                            Text(text = "Bhavna corp")
                        },
                        navigationIcon = {
                            IconButton(onClick = { }) {
                                Icon(Icons.Filled.Menu, contentDescription = "menu")
                            }
                        },
                        actions = {
                            IconButton(onClick = { }) {
                                Icon(Icons.Filled.Notifications, contentDescription = "noti")
                            }
                            IconButton(onClick = { }) {
                                Icon(Icons.Filled.Search, contentDescription = "search")
                            }
                            IconButton(onClick = {callthemeSwith()  }) {
                                Icon(Icons.Filled.Settings, contentDescription = "setting")
                            }
                        },
                    )
                },
                floatingActionButton = {
                    FloatingActionButton(onClick = {}) {
                        IconButton(onClick = {
                            val intent = Intent(this, LoginActivity::class.java)
                            startActivity(intent)
                        }) {
                            Icon(Icons.Filled.Add, contentDescription = "add")

                        }
                    }
                },
                floatingActionButtonPosition = FabPosition.End
            ) {
                ShowUserList()
            }
        }
    }

    @Composable
    fun Greeting(name: String) {
        Surface(
            modifier = Modifier
                .fillMaxHeight()
                .fillMaxWidth()

        ) {

            Text(text = "Hello $name!")

        }
    }

    @Composable
    fun Title() {
        val context = LocalContext.current

        Text(
            text = "Bhavna Corp", fontSize = 32.sp,
            color = Color.Cyan,
            fontFamily = FontFamily.Cursive,
            modifier = Modifier.clickable {
                Toast.makeText(context, "Clicked", Toast.LENGTH_LONG).show()
            }
        )
    }

    @Preview(showBackground = true)
    @Composable
    fun DefaultPrevie() {
        //  Title()
        ImageView("Connect Wise")
    }

    @Composable
    fun ImageView(product: String) {
        Card(
            elevation = 4.dp,
            modifier = Modifier
                .padding(12.dp)
                .fillMaxWidth()
                .wrapContentHeight()
        ) {


            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .wrapContentHeight()
                    .padding(12.dp)
                    .padding(12.dp)
            ) {
                Image(
                    painter = painterResource(id = R.drawable.logo),
                    contentDescription = "",
                    contentScale = ContentScale.Crop,
                    modifier = Modifier
                        .size(100.dp)
                        .clip(CircleShape)

                )

                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .wrapContentHeight(),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {

                    Text(
                        text = product,
                        style = TextStyle(
                            color = Color.Black,
                            fontWeight = FontWeight.Bold,
                            textAlign = TextAlign.Center
                        ),
                        modifier = Modifier
                            .fillMaxWidth()
                            .wrapContentHeight()


                    )
                    Spacer(modifier = Modifier.height(15.dp))

                    Button(onClick = {
                        Modifier
                            .padding(120.dp)
                            .size(200.dp)
                    }) {
                        Text(
                            text = "View Profile",
                            style = TextStyle(
                                color = Color.White,
                                fontWeight = FontWeight.Bold,
                                textAlign = TextAlign.Center
                            )
                        )
                    }


                }
            }
        }
    }

    @Composable
    fun ShowUserList() {
        Column(modifier = Modifier.verticalScroll(rememberScrollState())) {
            for (i in 0..9) {
                if (i == 0)
                    ImageView("Connect Wise")
                if (i == 1)
                    ImageView("Elemica")
                if (i == 2)
                    ImageView("GHX")
                if (i == 3)
                    ImageView("Connect Wise Mobile team")
                if (i == 4)
                    ImageView("Elemica Web Team")
                if (i == 5)
                    ImageView("Elemica Mobile team")
                if (i == 6)
                    ImageView("GHX Web Team")
                if (i == 7)
                    ImageView("GHX Mobile team")
                if (i == 8)
                    ImageView("Connect Wise WEb team")
                if (i == 9)
                    ImageView("Connect wise Product team")


            }
        }

    }

    @Composable
    fun RecyclerList() {


        LazyColumn {
            items(users) {
                ShowUserList()

            }
        }
    }

    data class User(
        val id: Int
    )

    val users = listOf(
        User(0),
        User(1),
        User(2),
        User(3),
        User(4),
        User(5),
        User(6),
        User(7),
        User(8),
        User(9)


    )

    @Composable
    fun showswitch() {
        val ischecked = remember {
            mutableStateOf(true)
        }
        Switch(
            checked = ischecked.value,
            onCheckedChange = {
                ischecked.value = it
            },
            modifier = Modifier.run {
                size(20.dp)
                padding(100.dp)
            }
        )

    }
    fun callthemeSwith(){
        val intent =Intent(this,Switch::class.java)
        startActivity(intent)
    }

}