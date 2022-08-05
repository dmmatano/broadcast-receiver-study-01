package com.example.broadcastreceiverapp

import android.content.Intent
import android.content.IntentFilter
import android.net.ConnectivityManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

/**
 * Broadcast receivers
 * Usado para "comunicação" entre SO e App, App com outro App ou App com ele mesmo
 * Static receiver: manifest
 * Dynamic receiver:
 * Explicit broadcast "mira" em um broadcast específico, enquanto o implicit mira em todos
 * Não esqueça de usar o unregisterBroadcast() no final para evitar memory leak !!!
 */
class MainActivity : AppCompatActivity() {

    private val dynamicBroadcast = DynamicBroadcast()
    val customBroadcast = CustomBroadcast()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val intentFilter = IntentFilter(ConnectivityManager.CONNECTIVITY_ACTION)
        intentFilter.addAction(Intent.ACTION_TIME_TICK)

        val customIntentFilter = IntentFilter("com.example.broadcastreceiverapp.EXAMPLE_ACTION")
        intentFilter.addAction(Intent.ACTION_TIME_TICK)
        registerReceiver(customBroadcast, customIntentFilter)

        registerReceiver(dynamicBroadcast, intentFilter)
    }

    override fun onDestroy() {
        super.onDestroy()
        unregisterReceiver(dynamicBroadcast)
        unregisterReceiver(customBroadcast)
    }
}