package com.example.hilolvideoapp.video

sealed interface VideoCallAction {
    data object OnDisconnectClick: VideoCallAction
    data object JoinCall: VideoCallAction
}