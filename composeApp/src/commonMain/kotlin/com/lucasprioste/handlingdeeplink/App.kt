package com.lucasprioste.handlingdeeplink

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.navigation.NavDeepLinkRequest
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navDeepLink
import androidx.navigation.parseStringAsNavUri
import androidx.navigation.toRoute
import com.lucasprioste.handlingdeeplink.presentation.core.navigation.DeepLinkHelper
import com.lucasprioste.handlingdeeplink.presentation.core.navigation.Route
import com.lucasprioste.handlingdeeplink.presentation.core.theme.HandlingDeepLinkTheme
import com.lucasprioste.handlingdeeplink.presentation.core.utils.ObserveAsEvents
import org.jetbrains.compose.ui.tooling.preview.Preview
import org.koin.compose.KoinContext
import org.koin.compose.koinInject

@Composable
@Preview
fun App(
    deepLinkHelper: DeepLinkHelper = koinInject(),
) {
    val navController = rememberNavController()

    ObserveAsEvents(flow = deepLinkHelper.navigationEvents) { uri ->
        navController.handleDeepLink(
            NavDeepLinkRequest.Builder.fromUri(uri = parseStringAsNavUri(uri)).build()
        )
    }

    HandlingDeepLinkTheme {
        KoinContext {
            Scaffold(
                modifier = Modifier.fillMaxSize(),
            ) {
                NavHost(
                    navController = navController,
                    startDestination = Route.HomeScreen,
                ) {
                    composable<Route.HomeScreen> {
                        Column(
                            modifier = Modifier.fillMaxSize(),
                            verticalArrangement = Arrangement.Center,
                            horizontalAlignment = Alignment.CenterHorizontally,
                        ) {
                            Text("Home Screen")
                        }
                    }
                    composable<Route.SettingsScreen>(
                        deepLinks = listOf(
                            navDeepLink {
                                uriPattern = "https://your-host.com/settings?userMail={${Route.MAIL_ARG_NAME}}"
                            },
                        ),
                    ) {
                        val args = it.toRoute<Route.SettingsScreen>()
                        Column(
                            modifier = Modifier.fillMaxSize(),
                            verticalArrangement = Arrangement.Center,
                            horizontalAlignment = Alignment.CenterHorizontally,
                        ) {
                            Text("Settings Screen")
                            Text("User mail: ${args.mail}")
                        }
                    }
                }
            }
        }
    }
}