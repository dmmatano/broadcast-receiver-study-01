package com.example.broadcastreceiverapp

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.widget.Toast

class CustomBroadcast: BroadcastReceiver() {

    override fun onReceive(context: Context?, intent: Intent?) {
        //applicationId do build.gradle(app)
        if("com.example.broadcastreceiverapp.EXAMPLE_ACTION" == intent?.action){
            var receivedData = intent.getStringExtra("com.example.EXTRA_DATA")
            Toast.makeText(context, "Broadcast receiver!$receivedData", Toast.LENGTH_LONG).show()
        }
    }

}