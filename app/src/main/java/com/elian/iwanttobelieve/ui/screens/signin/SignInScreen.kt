package com.elian.iwanttobelieve.ui.screens.signin

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
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.elian.iwanttobelieve.R


@Composable
fun SignInScreen(
    viewModel: SignInViewModel = hiltViewModel(),
    onSignInSuccess: () -> Unit,
    onNavigateToSignUp: () -> Unit
) {

    val uiState by viewModel.uiState.collectAsState()
    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    val errorMessage = uiState.errorMessage?.let { stringResource(id = it.messageResId) }

    LaunchedEffect(key1 = true) {
        viewModel.navigationEvent.collect { event ->
            when (event) {
                is SignInViewModel.NavigationEvent.NavigateToFeed -> onSignInSuccess()
                is SignInViewModel.NavigationEvent.NavigateToSignUp -> onNavigateToSignUp()
            }
        }
    }

    Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(horizontal = 40.dp, vertical = 0.dp)
                .padding(innerPadding)
                .background(MaterialTheme.colorScheme.background),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Box(
                modifier = Modifier
                    .size(140.dp)
                    .clip(CircleShape)
                    .background(MaterialTheme.colorScheme.primary),
                contentAlignment = Alignment.Center
            ) {
                Image(
                    painter = painterResource(id = R.drawable.logo),
                    contentDescription = "Logo",
                    modifier = Modifier.size(80.dp),
                    colorFilter = ColorFilter.tint(MaterialTheme.colorScheme.background)
                )
            }

            Spacer(modifier = Modifier.height(60.dp))

            Text(
                text = "Sign In",
                style = MaterialTheme.typography.displaySmall,
                fontWeight = FontWeight.Bold,
                color = MaterialTheme.colorScheme.onPrimaryContainer
            )

            Spacer(modifier = Modifier.height(32.dp))

            OutlinedTextField(
                value = email,
                onValueChange = {
                    email = it

                    if (uiState.errorMessage != null) {
                        viewModel.clearError()
                    }
                },
                label = { Text(
                    text ="E-mail",
                    style = MaterialTheme.typography.labelLarge,
                    color =  MaterialTheme.colorScheme.onPrimaryContainer
                ) },
                modifier = Modifier
                    .fillMaxWidth(),
                shape = MaterialTheme.shapes.extraSmall
            )

            Spacer(modifier = Modifier.height(8.dp))

            OutlinedTextField(
                value = password,
                onValueChange = {
                    password = it

                    if (uiState.errorMessage != null) {
                        viewModel.clearError()
                    }
                },
                label = { Text(
                    text ="Password",
                    style = MaterialTheme.typography.labelLarge,
                    color =  MaterialTheme.colorScheme.onPrimaryContainer
                ) },
                modifier = Modifier
                    .fillMaxWidth(),
                shape = MaterialTheme.shapes.extraSmall,
                visualTransformation = PasswordVisualTransformation()
            )

            if (errorMessage != null) {
                Spacer(modifier = Modifier.height(8.dp))
                Text(
                    text = errorMessage,
                    style = MaterialTheme.typography.bodyMedium,
                    color = MaterialTheme.colorScheme.error,
                    modifier = Modifier.fillMaxWidth()
                )
            }

            Spacer(modifier = Modifier.height(16.dp))

            Button(
                onClick = {
                    viewModel.onSignInClick(email, password)
                },
                colors = ButtonDefaults.buttonColors(
                    containerColor = MaterialTheme.colorScheme.primary
                ),
                shape = MaterialTheme.shapes.extraSmall,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(52.dp)
            ) {
                Text(
                    text = "Sign In",
                    style = MaterialTheme.typography.bodyLarge,
                    color = MaterialTheme.colorScheme.onPrimary
                )
            }

            Spacer(modifier = Modifier.height(32.dp))

            Row(
                horizontalArrangement = Arrangement.Center,
                modifier = Modifier.fillMaxWidth()
            ) {
                Text(
                    text = "Don’t have any account? ",
                    color = MaterialTheme.colorScheme.onPrimaryContainer,
                    style = MaterialTheme.typography.bodyLarge,
                    fontWeight = FontWeight.Normal
                )
                Text(
                    text = "Sign Up",
                    color = MaterialTheme.colorScheme.primary,
                    fontWeight = FontWeight.Black,
                    style = MaterialTheme.typography.bodyLarge,
                    modifier = Modifier.clickable {
                        viewModel.onSignUpNavigationRequested()
                    }
                )
            }

        }

        if (uiState.isLoading) {
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .background(color = MaterialTheme.colorScheme.background.copy(alpha = 0.4f))
                    .clickable(enabled = true, onClick = {  }),
                contentAlignment = Alignment.Center
            ) {
                CircularProgressIndicator(
                    modifier = Modifier.size(60.dp),
                    strokeWidth = 4.dp
                )
            }
        }
    }
}