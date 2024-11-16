package com.hands_on.chatterapp

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.google.firebase.auth.FirebaseAuth
import com.hands_on.chatterapp.feature.auth.signin.SignInScreen
import com.hands_on.chatterapp.feature.auth.signup.SignUpScreen
import com.hands_on.chatterapp.feature.home.HomeScreen

@Composable
fun MainApp(modifier: Modifier = Modifier) {
    Surface(
        modifier = modifier.fillMaxSize()
    ) {
        val navController = rememberNavController()
        val currentUser = FirebaseAuth.getInstance().currentUser
        val start = if (currentUser != null) "home" else "signin"

        NavHost(navController = navController, startDestination = start) {
            composable("signin") {
                SignInScreen(navController = navController)
            }
            composable("signup") {
                SignUpScreen(navController = navController)
            }
            composable("home") {
                HomeScreen()
            }
        }
    }
}