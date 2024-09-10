package com.example.cdv

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.ViewGroup.LayoutParams.MATCH_PARENT
import android.view.ViewGroup.LayoutParams.WRAP_CONTENT
import android.widget.EditText
import android.widget.LinearLayout
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.cdv.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private val amb: ActivityMainBinding by lazy {
        ActivityMainBinding.inflate(layoutInflater)
    }

    private companion object {
        const val VALOR_TELEFONE_UM = "VALOR_TELEFONE_UM"
        const val VALOR_TELEFONE_DOIS = "VALOR_TELEFONE_DOIS"
    }

    private val telefoneDoiEt: EditText by lazy {
        EditText(this)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(amb.root)

        telefoneDoiEt.hint = "Segundo Telefone"
        telefoneDoiEt.layoutParams = LinearLayout.LayoutParams(MATCH_PARENT, WRAP_CONTENT)
        amb.root.addView(telefoneDoiEt)

        savedInstanceState?.apply { // funções de escopo -> funções de alta ordem que facilitam a vida
            getString(VALOR_TELEFONE_UM)?.let { // garante que a variavel não é nula
                amb.telefoneEt.setText(it)
            }
            getString(VALOR_TELEFONE_DOIS, "00000000").let{
                telefoneDoiEt.setText(it)
            }
            Log.v(
                getString(R.string.app_name),
                "onCreate: restaurando dados de instância"
            )
        }


        amb.abraBt.setOnClickListener {
            val anotherIntent: Intent = Intent(this, AnotherActivity::class.java).also{
                startActivity(it)    //inicia a nova tela, apenas se a estanciação der certo
            } // estanciamos a tela nova
        }

        Log.v(getString(R.string.app_name), "onCreate: Iniciando ciclo completo")
    }


    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putString(VALOR_TELEFONE_UM, amb.telefoneEt.text.toString())
        outState.putString(VALOR_TELEFONE_DOIS, telefoneDoiEt.text.toString())
        Log.v(
            getString(R.string.app_name),
            "onSavedInstanceState: Salvando dados de instância"
        )
    }


//    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
//        super.onRestoreInstanceState(savedInstanceState)
//
//        //forma Java
//        /*
//        val valorTelefoneUm = savedInstanceState.getString(VALOR_TELEFONE_UM)
//        if (valorTelefoneUm != null) {
//            amb.telefoneEt.setText(valorTelefoneUm)
//        }
//
//        val valorTelefoneDois = savedInstanceState.getString(VALOR_TELEFONE_DOIS)
//        telefoneDoisEt.setText(valorTelefoneDois)
//
//
//        * */
//
//        // forma Kotlin de programar
//        savedInstanceState.apply { // funções de escopo -> funções de alta ordem que facilitam a vida
//            getString(VALOR_TELEFONE_UM)?.let { // garante que a variavel não é nula
//                amb.telefoneEt.setText(it)
//            }
//            getString(VALOR_TELEFONE_DOIS, "00000000").let{
//                telefoneDoiEt.setText(it)
//            }
//        }
//        Log.v(
//            getString(R.string.app_name),
//            "onRestoreInstanceState: restaurando dados de instância"
//        )
//    }

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