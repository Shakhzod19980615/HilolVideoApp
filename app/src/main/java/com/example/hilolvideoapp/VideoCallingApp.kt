package com.example.hilolvideoapp

import android.app.Application
import com.example.hilolvideoapp.di.appModule
import io.getstream.video.android.core.StreamVideo
import io.getstream.video.android.core.StreamVideoBuilder
import io.getstream.video.android.model.User
import io.getstream.video.android.model.UserType
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class VideoCallingApp: Application() {

    private var currentName:String? = null
    var client: StreamVideo? = null
    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(this@VideoCallingApp)
            modules(appModule)
        }
    }

    fun initVideoClient(username:String) {
        if(client == null || currentName != username) {
            StreamVideo.removeClient()
            currentName = username
            client = StreamVideoBuilder(
                context = this,
                apiKey = "vzc2nfvbqk66",
                user = User(
                    id = username,
                    name = username,
                    type = UserType.Guest
                )
            ).build()
        }
    }
}