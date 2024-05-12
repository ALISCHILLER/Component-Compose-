package com.msa.componentcompose.ui.component.bottomNavigationC

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.*
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector

sealed class BottomBarTab(val title: String, val icon: ImageVector, val color: Color) {
    data object Profile : BottomBarTab(
        title = "Profile",
        icon = Icons.Rounded.Person,
        color = Color(0xFFFFA574)
    )
    data object Home : BottomBarTab(
        title = "Home",
        icon = Icons.Rounded.Home,
        color = Color(0xFFFA6FFF)
    )
    data object Settings : BottomBarTab(
        title = "Settings",
        icon = Icons.Rounded.Settings,
        color = Color(0xFFADFF64)
    )
    data object Setti : BottomBarTab(
        title = "Settings",
        icon = Icons.Rounded.Settings,
        color = Color(0xFFADFF64)
    )
}

val tabs = listOf(
    BottomBarTab.Profile,
    BottomBarTab.Home,
    BottomBarTab.Settings,
    BottomBarTab.Setti,
)