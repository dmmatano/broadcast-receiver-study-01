package com.example.broadcastreceiverapp

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.widget.Toast

class AppBroadcast:BroadcastReceiver() {

    override fun onReceive(context: Context?, intent: Intent?) {
        if(Intent.ACTION_BOOT_COMPLETED == (intent?.action)){
            Toast.makeText(context, "Boot Completed!", Toast.LENGTH_LONG).show()
        }
    }

}