package com.example.androidservice

import android.app.Service
import android.content.Intent
import android.media.MediaPlayer
import android.os.IBinder

class MyService : Service() , MediaPlayer.OnCompletionListener{
    private var mediaPlayer:MediaPlayer?=null

    override fun onCreate() {
        super.onCreate()
         mediaPlayer = MediaPlayer.create(this,R.raw.mawlaya)
        mediaPlayer?.setOnCompletionListener(this)
    }
    override fun onBind(intent: Intent?): IBinder? {
        return null
    }

    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
       if (!mediaPlayer?.isPlaying!!){
           mediaPlayer?.start()
       }
        return super.onStartCommand(intent, flags, startId)
    }
    override fun onDestroy() {
        super.onDestroy()
        if (mediaPlayer?.isPlaying!!){
            mediaPlayer?.stop()
        }

    }

    override fun onCompletion(mp: MediaPlayer?) {
        stopSelf()
    }
}