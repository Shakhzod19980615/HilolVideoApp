package com.example.hilolvideoapp.connect

import android.app.Application
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.AndroidViewModel
import com.example.hilolvideoapp.VideoCallingApp

class ConnectViewModel(
    private val app:Application
):AndroidViewModel(app) {
    var state by mutableStateOf(ConnectState())
        private set

    fun onAction(action: ConnectAction) {
        when (action) {
            is ConnectAction.OnNameChange -> {
                state = state.copy(name = action.name)
            }
            is ConnectAction.OnConnectClick -> {
                connectToRoom()
            }
        }
    }
    private fun connectToRoom() {
        state = state.copy(errorMessage = null)
        if(state.name.isBlank()) {
            state = state.copy(
                errorMessage = "The username can't be blank."
            )
            return
        }

        (app as VideoCallingApp).initVideoClient(state.name)

        state = state.copy(isConnected = true)
    }
}