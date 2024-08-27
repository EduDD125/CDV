package com.example.cdv

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.cdv.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private val amb: ActivityMainBinding by lazy {
        ActivityMainBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(amb.root)

        amb.abraBt.setOnClickListener {
            val anotherIntent: Intent = Intent(this, AnotherActivity::class.java).also{
                startActivity(it)    //inicia a nova tela, apenas se a estanciação der certo
            } // estanciamos a tela nova
        }

        Log.v(getString(R.string.app_name), "onCreate: Iniciando ciclo completo")
    }
    override fun onStart() {
        super.onStart()
        Log.v(getString(R.string.app_name), "onStart: Iniciando ciclo visivel")

    }

    override fun onResume() {
        super.onResume()
        Log.v(getString(R.string.app_name), "onResume: Iniciando ciclo foreground")
    }

    override fun onPause() {
        super.onPause()
        Log.v(getString(R.string.app_name), "onPause: finalizando ciclo foreground")
    }

    override fun onStop() {
        super.onStop()
        Log.v(getString(R.string.app_name), "onStop: finalizando ciclo visível")
    }


    override fun onDestroy() {
        super.onDestroy()
        Log.v(getString(R.string.app_name), "onDestroy: finalizando ciclo completo")
    }
}