package com.example.jetpackcomposeinstagram.login.ui

import android.app.Activity
import android.content.Intent
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
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Divider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.jetpackcomposeinstagram.R
import com.example.jetpackcomposeinstagram.TwitActivity

@Composable
fun LoginScreen( loginViewModel: LoginViewModel) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
            .background(Color.White)
    ) {

        Header(Modifier.align(Alignment.TopEnd))
        Body( modifier = Modifier.align(Alignment.Center), loginViewModel )
        Footer(Modifier.align(Alignment.BottomCenter))

    }
}

@Composable
fun Footer(align: Modifier) {
    Column(modifier = align.fillMaxWidth()) {
        Divider(
            modifier = Modifier.height(1.dp)
        )
        Spacer(modifier = Modifier.size(24.dp))
        SignUp()
        Spacer(modifier = Modifier.size(24.dp))
    }
}

@Composable
fun SignUp() {
    Row(
        Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.Center
    ) {
        Text(
            text = "Don't have account?", fontSize = 12.sp,
            color = Color(0xFFB5B5B5)
        )
        Text(
            text = "Sign Up",
            Modifier.padding(start = 8.dp),
            fontSize = 12.sp,
            fontWeight = FontWeight.Bold,
            color = Color(0xFF4EA8E9)
        )
    }
}

@Composable
fun Body( modifier: Modifier, loginViewModel: LoginViewModel) {
    val email: String by loginViewModel.email.observeAsState( initial = "" )
    val password: String by loginViewModel.password.observeAsState(initial = "")
    val isLogEnabled : Boolean by loginViewModel.isLogEnabled.observeAsState(initial = false)

    Column(
        modifier = modifier
    ) {
        ImageLogo(Modifier.align(Alignment.CenterHorizontally))
        Spacer(modifier = Modifier.size(16.dp))

        MyEmail( mail = email ) {
            loginViewModel.onLoginChanged( email = it, password )
        }

        Spacer(modifier = Modifier.size(4.dp))
        MyPassword(pass = password, onTextChange = {
            loginViewModel.onLoginChanged( email, password = it )
        })
        Spacer(modifier = Modifier.size(8.dp))
        ForgotPassword(Modifier.align(Alignment.End))
        Spacer(modifier = Modifier.size(16.dp))
        LoginButton( isLogEnabled )
        Spacer(modifier = Modifier.size(16.dp))
        LoginDivider()
        Spacer(modifier = Modifier.size(32.dp))
        SocialLogin()
    }
}

@Composable
fun SocialLogin() {
    Row(
        Modifier.fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Center
    ) {
        Image(
            painter = painterResource(id = R.drawable.fb), contentDescription = "Fb",
            modifier = Modifier.size(16.dp)
        )
        Text(
            text = "Continue as Richi", fontSize = 14.sp, fontWeight = FontWeight.Bold,
            modifier = Modifier.padding(horizontal = 8.dp),
            color = Color(0xFF4EA8E9)
        )
    }
}

@Composable
fun LoginDivider() {
    Row(
        modifier = Modifier.fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Divider(
            modifier = Modifier
                .weight(1f)
                .padding(end = 16.dp)
        )
        Text(text = "OR", color = Color(0xFFB5B5B5))
        Divider(
            modifier = Modifier
                .weight(1f)
                .padding(start = 16.dp)
        )
    }
}

@Composable
fun LoginButton(inEnable: Boolean) {
    val activity = LocalContext.current as Activity
    Button(onClick = {
        val i = Intent( activity, TwitActivity::class.java )
        activity.startActivity( i )
                     },
        enabled = inEnable,
        modifier = Modifier.fillMaxWidth(),
        colors = ButtonDefaults.buttonColors(
            contentColor = Color.White,
            containerColor = Color( 0xFF4EA8E9 ),
            disabledContainerColor = Color(0xFF83C6F7),
            disabledContentColor = Color.White
        )) {
        Text(text = "Log In")
    }
}

@Composable
fun ForgotPassword(modifier: Modifier) {
    Text(
        text = "Forgot password?",
        fontSize = 12.sp,
        fontWeight = FontWeight.Bold,
        color = Color(0xFF4EA8E9),
        modifier = modifier
    )
}

@Composable
fun MyEmail(mail: String, onTextChange: (String) -> Unit) {
    OutlinedTextField(
        value = mail,
        onValueChange = { onTextChange(it) },
        placeholder = { Text(text = "Email") },
        maxLines = 1,
        singleLine = true,
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Email),
        modifier = Modifier
            .fillMaxWidth()
            .background(Color.White),
        colors = TextFieldDefaults.colors(
            unfocusedContainerColor = Color(0xFFFAFAFA),
            focusedContainerColor = Color(0xFFFAFAFA),
            focusedTextColor = Color(0xFFB2B2B2),
            focusedIndicatorColor = Color.Transparent,
            unfocusedIndicatorColor = Color.Transparent,
            unfocusedTextColor = Color(0xFFB2B2B2)
        )

    )
}
@Composable
fun MyPassword(pass: String, onTextChange: (String) -> Unit) {
    var passwordVisibility by remember {
        mutableStateOf(false)
    }
    OutlinedTextField(
        value = pass,
        onValueChange = { onTextChange(it) },
        placeholder = { Text(text = "Password") },
        maxLines = 1,
        singleLine = true,
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
        modifier = Modifier
            .fillMaxWidth()
            .background(Color.White),
        colors = TextFieldDefaults.colors(
            unfocusedContainerColor = Color(0xFFFAFAFA),
            focusedContainerColor = Color(0xFFFAFAFA),
            focusedTextColor = Color(0xFFB2B2B2),
            focusedIndicatorColor = Color.Transparent,
            unfocusedIndicatorColor = Color.Transparent,
            unfocusedTextColor = Color(0xFFB2B2B2)
        ),
        trailingIcon = {
            val imagen = if (passwordVisibility) {
                Icons.Filled.Favorite
            } else {
                Icons.Filled.FavoriteBorder
            }
            IconButton(onClick = { passwordVisibility = !passwordVisibility }) {
                Icon(imageVector = imagen, contentDescription = "Password")
            }
        },
        visualTransformation = if (passwordVisibility) {
            VisualTransformation.None
        } else {
            PasswordVisualTransformation()
        }
    )
}

@Composable
fun ImageLogo(align: Modifier) {
    Image(
        painter = painterResource(id = R.drawable.insta), contentDescription = "Instagram",
        modifier = align
    )
}

@Composable
fun Header(modifier: Modifier) {
    val activity = LocalContext.current as Activity // Toma el contexto del composable

    Icon(
        imageVector = Icons.Default.Close,
        contentDescription = "Close App",
        modifier = modifier.clickable { activity.finish() }
    )
}