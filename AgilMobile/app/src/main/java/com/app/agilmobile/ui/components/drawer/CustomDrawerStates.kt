package com.app.agilmobile.ui.components.drawer

enum class CustomDrawerStates {
    Opened, Closed
    }

fun CustomDrawerStates.isOpened(): Boolean {
    return this.name == "Opened"
}

fun CustomDrawerStates.opposite(): CustomDrawerStates {
    return if(this == CustomDrawerStates.Opened) CustomDrawerStates.Closed else CustomDrawerStates.Opened
}