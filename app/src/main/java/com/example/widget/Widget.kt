package com.example.widget

import android.app.AlertDialog
import android.app.Dialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Window
import android.widget.Button
import android.widget.Toast
import com.example.widget.databinding.ActivityWidgetBinding
import com.google.android.material.snackbar.Snackbar


//Membuat variable binding
private lateinit var binding: ActivityWidgetBinding
class Widget : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //inisialisasi binding
        binding = ActivityWidgetBinding.inflate(layoutInflater)

        //Memanggil layout dengan menggunakan binding.root
        setContentView(binding.root)

        binding.btnToast.setOnClickListener {
            Toast.makeText( this, "ini adalah Toas",Toast.LENGTH_SHORT).show()

        }

        binding.btnSnackbar.setOnClickListener {
            Snackbar.make(it,  "ini adalah Snackbar",Snackbar.LENGTH_SHORT).show()
        }

        binding.btnAlert.setOnClickListener {

         AlertDialog.Builder( this).apply {
            setTitle("message")
            setMessage("ini adalah Alert")

        setPositiveButton( "ok"){ dialog, _ ->
            Toast.makeText(applicationContext, "Anda Klik OK",Toast.LENGTH_SHORT).show()
            dialog.dismiss()

        }

        setNegativeButton( "Back"){ dialog, _ ->
            Toast.makeText(applicationContext, "Anda Klik Back",Toast.LENGTH_SHORT).show()
            dialog.dismiss()
            }
        }.show()
    }

        binding.btnCustomDialog.setOnClickListener {
        Dialog( this).apply {
        requestWindowFeature(Window.FEATURE_NO_TITLE)
        setCancelable(false)
        setContentView(R.layout.custom_dialog)

        val btnCancel = this.findViewById<Button>(R.id.btnCancel)
        val btnContinue = this.findViewById<Button>(R.id.btnContinue)

        btnCancel.setOnClickListener {
            Toast.makeText(applicationContext, "Anda Klik Cancel", Toast.LENGTH_SHORT).show()
            this.dismiss()
    }
        btnContinue.setOnClickListener {
            Toast.makeText(applicationContext,  "Anda Klik Continue", Toast.LENGTH_SHORT).show()
            this.dismiss()
        }
       }.show()
     }
    }
}