package com.example.cdv

import android.os.Bundle
import android.util.Log
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class AnotherActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_another)

        Log.v(getString(R.string.app_name), "onCreate-A: Iniciando ciclo completo")
    }
    override fun onStart() {
        super.onStart()
        Log.v(getString(R.string.app_name), "onStart-A: Iniciando ciclo visivel")

    }

    override fun onResume() {
        super.onResume()
        Log.v(getString(R.string.app_name), "onResume-A: Iniciando ciclo foreground")
    }

    override fun onPause() {
        super.onPause()
        Log.v(getString(R.string.app_name), "onPause-A: finalizando ciclo foreground")
    }

    override fun onStop() {
        super.onStop()
        Log.v(getString(R.string.app_name), "onStop-A: finalizando ciclo visível")
    }


    override fun onDestroy() {
        super.onDestroy()
        Log.v(getString(R.string.app_name), "onDestroy-A: finalizando ciclo completo")
    }
}