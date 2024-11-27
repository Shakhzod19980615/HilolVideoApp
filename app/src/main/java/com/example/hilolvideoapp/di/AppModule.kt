package com.example.hilolvideoapp.di

import com.example.hilolvideoapp.VideoCallingApp
import com.example.hilolvideoapp.connect.ConnectViewModel
import com.example.hilolvideoapp.video.VideoCallViewModel
import org.koin.android.ext.koin.androidContext
import org.koin.androidx.viewmodel.dsl.viewModel

import org.koin.dsl.module

val appModule = module {
    factory {
        val app = androidContext().applicationContext as VideoCallingApp
        app.client
    }
    viewModel { ConnectViewModel(get()) } // Pass required dependencies
    viewModel { VideoCallViewModel(get()) }
}