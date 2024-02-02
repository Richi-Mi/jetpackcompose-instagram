package com.example.jetpackcomposeinstagram

import android.app.Activity
import android.graphics.Bitmap
import android.os.Bundle
import android.widget.Space
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Divider
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ImageBitmap
import androidx.compose.ui.graphics.painter.BitmapPainter
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.modifier.modifierLocalConsumer
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.core.graphics.drawable.toBitmap
import com.example.jetpackcomposeinstagram.ui.theme.JetpackComposeInstagramTheme
// Colores
val fondo = Color(0xFF243447)
val verde = Color(0xFF43A047)
val rojo = Color(0xFFD81B60)
val gris = Color(0xFF4B4B4B)

class TwitActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            JetpackComposeInstagramTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    TwitScreen()
                }
            }
        }
    }
}
@Composable
fun TwitScreen() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(fondo)
    ) {
        Row( Modifier.padding(16.dp )) {
            Image(painter = painterResource(
                id = R.drawable.profile),
                contentDescription = "Profile",
                modifier = Modifier
                    .clip(CircleShape)
                    .size(64.dp) )
            Spacer(modifier = Modifier.width(16.dp))
            Content()
        }
        Divider()
    }
}
@Composable
fun UserText() {
    Row {
        Text(text = "Aris ", color = Color.White, fontWeight = FontWeight.ExtraBold )
        Text(text = "@AristiDevs 4h", color = Color.Gray )
    }
}
@Composable
fun Content() {
    Column {
        Row( Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceBetween ) {
            UserText()
            Icon(
                painter = painterResource(id = R.drawable.ic_dots),
                contentDescription = "Dots",
                tint = Color.White,
                modifier = Modifier.size(24.dp)
            )
        }
        Text(
            color = Color.White,
            text = "Descripcion Larga sobre el texto \nDescripcion Larga sobre el texto \nDescripcion Larga sobre el texto \nDescripcion Larga sobre el texto \nDescripcion Larga sobre el texto \n")
        Image(
            painter = painterResource(id = R.drawable.profile),
            contentDescription = "Profile",
            modifier = Modifier.clip( RoundedCornerShape( 16.dp ) ) )
        TwittButtons()
    }
}
data class TwitBtn( val image: Int, val txt: String )
@Composable
fun TwittButtons() {
Color(0xFFFF0000)
    var img_chat by remember { mutableStateOf( R.drawable.ic_chat ) }
    var img_linke by remember { mutableStateOf( R.drawable.ic_like ) }
    var txt_chat by remember { mutableStateOf("1") }
    var txt_rt by remember { mutableStateOf("1") }
    var txt_like by remember { mutableStateOf("1") }
    var colorRojo by remember {
        mutableStateOf(0xFFC0C0C0)
    }
    var colorVerde by remember {
        mutableStateOf( 0xFFC0C0C0 )
    }
    var colorAzul by remember {
        mutableStateOf( 0xFFC0C0C0 )
    }

    Row( Modifier.padding(16.dp)) {
        TwitButton( img_chat, txt_chat, colorAzul, Modifier.weight(1f)) {
            if( img_chat == R.drawable.ic_chat ) {
                img_chat = R.drawable.ic_chat_filled
                colorAzul = 0xFF0000FF
                txt_chat = "2"
            } else {
                img_chat = R.drawable.ic_chat
                colorAzul = 0xFFC0C0C0
                txt_chat = "1"

            }
        }
        TwitButton(image = R.drawable.ic_rt, txt = txt_rt, colorVerde, Modifier.weight(1f)) {
            txt_rt = if( txt_rt == "1") {
                colorVerde = 0xFF00FF00
                "2"
            } else {
                colorVerde = 0xFFC0C0C0
                "1"
            }
        }
        TwitButton(image = img_linke, txt = txt_like, colorRojo, Modifier.weight(1f)) {
            if( img_linke == R.drawable.ic_like ) {
                img_linke = R.drawable.ic_like_filled
                colorRojo = 0xFFFF0000
                txt_like = "2"
            } else {
                img_linke = R.drawable.ic_like
                colorRojo = 0xFFC0C0C0
                txt_like = "1"
            }
        }
    }
}
@Composable
fun TwitButton( @DrawableRes image : Int, txt : String, color : Long, modifier: Modifier, onClick: () -> Unit ) {
    Row(
        modifier = modifier.clickable {
            onClick()
        }
    ) {
        Icon(
            painter = painterResource(id = image),
            contentDescription = "Icono",
            tint = Color( color )
        )
        Spacer(modifier = Modifier.width(8.dp))
        Text( text = txt, color = Color.Gray )
    }
    
}