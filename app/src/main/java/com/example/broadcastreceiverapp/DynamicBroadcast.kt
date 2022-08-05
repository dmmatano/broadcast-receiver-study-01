package com.example.broadcastreceiverapp

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.net.ConnectivityManager
import android.widget.Toast

class DynamicBroadcast: BroadcastReceiver() {
    override fun onReceive(context: Context?, intent: Intent?) {
        if(Intent.ACTION_TIME_TICK == intent?.action){
            Toast.makeText(context, "Time Updated", Toast.LENGTH_LONG).show()
        }else if(ConnectivityManager.CONNECTIVITY_ACTION == intent?.action){
            val booleanExtra = intent.getBooleanExtra(ConnectivityManager.EXTRA_NO_CONNECTIVITY, false)

            if(!booleanExtra){
                Toast.makeText(context, "Connected", Toast.LENGTH_LONG).show()
            }else{
                Toast.makeText(context, "Disconnected", Toast.LENGTH_LONG).show()
            }
        }

    }
}