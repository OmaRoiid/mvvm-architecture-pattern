package com.example.omar_salem.mvvm_architectural_pattern.util

import android.content.Context
import android.net.ConnectivityManager
import android.content.Context.CONNECTIVITY_SERVICE
import android.content.DialogInterface
import android.content.Intent
import android.provider.Settings
import androidx.appcompat.app.AlertDialog
import androidx.core.content.ContextCompat.startActivity

/**
 * TODO: Add class header
 */
class NetworkUtils(private val currentScreenContext : Context) {

     fun isNetworkAvailable(): Boolean {
        val connectivityManager = currentScreenContext.getSystemService(CONNECTIVITY_SERVICE) as ConnectivityManager
        val activeNetworkInfo = connectivityManager.activeNetworkInfo
        return activeNetworkInfo != null && activeNetworkInfo.isConnected
    }
    fun openNetworkSittingsScreen ()
    {
        val dialogBuilder = AlertDialog.Builder(currentScreenContext)
        dialogBuilder.setMessage("Do you want to Open WI-FI Sittings Screen?")
                .setCancelable(false)
                // positive button text and action
                .setPositiveButton("yes") { _, _ ->
                    startActivity(currentScreenContext,Intent(Settings.ACTION_WIFI_SETTINGS),null)
                }


        // create dialog box
        val alert = dialogBuilder.create()
        // set title for alert dialog box
        alert.setTitle("Open Network Connection")
        // show alert dialog
        alert.show()
    }
}