package com.plcoding.contactscomposemultiplatform

import androidx.compose.ui.window.ComposeUIViewController


fun MainViewController() = ComposeUIViewController {
    val isDarkTheme =
        UIScreen.App(
            darkTheme = false,
            dynamicColor = false
        )
}