package com.lucasprioste.handlingdeeplink.presentation.core.navigation

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

sealed class Route {
    @Serializable
    data object HomeScreen: Route()

    @Serializable
    data class SettingsScreen(
        @SerialName(MAIL_ARG_NAME) val mail: String,
    ): Route()

    companion object {
        const val MAIL_ARG_NAME = "userMail"
    }
}