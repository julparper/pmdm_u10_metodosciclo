package com.example.ciclovida

import android.os.Bundle
import android.util.Log
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.lifecycle.DefaultLifecycleObserver
import androidx.lifecycle.LifecycleOwner


class MainActivity : AppCompatActivity() {

    companion object{
        val APP_NAME = "Aplicación Ciclo de Vida"
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        registrar("onCreate()")
    }


    override fun onStart() {
        super.onStart()
        registrar("onStart()")
    }

    override fun onResume() {
        super.onResume()
        registrar("onResume()")
    }

    override fun onPause() {
        super.onPause()
        registrar("onPause()")
    }

    override fun onStop() {
        super.onStop()
        registrar("onStop()")
    }

    override fun onDestroy() {
        super.onDestroy()
        registrar("onDestroy()")
    }


    private fun registrar(msg:String){
        Log.i(APP_NAME, msg)
    }
}