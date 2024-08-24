package com.hamzeh.kmp_networking_and_data_storage.android

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.lifecycle.lifecycleScope
import com.hamzeh.kmp_networking_and_data_storage.Greeting
import com.hamzeh.kmp_networking_and_data_storage.android.theme.AppContainer
import com.hamzeh.kmp_networking_and_data_storage.di.AndroidRocketLaunchViewModel
import com.hamzeh.kmp_networking_and_data_storage.domain.viewmodels.RocketLaunchViewModel
import kotlinx.coroutines.launch
import org.koin.androidx.compose.koinViewModel

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AppContainer {
                MainScreenRoute()
            }
        }
    }
}

@Composable
fun MainScreenRoute(
    viewModel: RocketLaunchViewModel = koinViewModel()
) {
    val data = viewModel.rocketLaunchesUiState.collectAsStateWithLifecycle()
    HomeScreen(data = data.value) {

    }
}

@Composable
fun GreetingView(text: String) {

    val viewModel: RocketLaunchViewModel = koinViewModel()
    val rockets = viewModel.rocketLaunchesUiState.collectAsStateWithLifecycle()
    if (rockets.value.isNotEmpty()) {
        Text(text = rockets.value.first().missionName)
    }
    else {
        Text(text = text)
    }

}

@Preview
@Composable
fun DefaultPreview() {
    MyApplicationTheme {
        GreetingView("Hello, Android!")
    }
}
