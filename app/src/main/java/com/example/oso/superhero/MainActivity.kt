package com.example.oso.superhero

import android.content.Intent
import android.graphics.Bitmap
import android.graphics.drawable.BitmapDrawable
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.provider.MediaStore
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    companion object {
        val PEOPLE = "persona"
        val CODE = 1000
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        imageView.setOnClickListener { openCamera() }

    }

    override fun onResume() {
        super.onResume()
        btnSend.setOnClickListener {
            if (verificarCampos()){
//            Se debe realizar el casteo a bitmapDrawable para extraer un bitmap.
                val img:Bitmap = (imageView.drawable as BitmapDrawable).bitmap
                val persona = SuperHeroe(
                        nombre.text.toString(),
                        apellido.text.toString(),
                        nombreHeroe.text.toString(),
                        Integer.parseInt(edad.text.toString()),
                        direccion.text.toString(),
                        ciudad.text.toString(),
                        img)
                val i = Intent(this, DetailActivity::class.java)
                i.putExtra(PEOPLE,persona)

                try {
                    startActivity(i)
                    limpiarCampos()
                }catch (e:Exception){
                    Toast.makeText(this,e.message,Toast.LENGTH_SHORT).show()
                }
            }else
                Toast.makeText(this,getString(R.string.error),Toast.LENGTH_SHORT).show()
        }

    }

    private fun openCamera() {
        val intent = Intent(MediaStore.ACTION_IMAGE_CAPTURE)
        startActivityForResult(intent,CODE)
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        val extra = data?.extras
        if (extra != null) {
            val resultImg: Bitmap = extra.get("data") as Bitmap
            imageView.setImageBitmap(resultImg)
        }
    }

    private fun verificarCampos():Boolean{
        if (nombre.text.isEmpty() || apellido.text.isEmpty() || nombreHeroe.text.isEmpty() ||
                edad.text.isEmpty() || direccion.text.isEmpty() || ciudad.text.isEmpty())
            return false
        return true
    }

    private fun limpiarCampos() {
        nombre.text.clear()
        apellido.text.clear()
        nombreHeroe.text.clear()
        edad.text.clear()
        direccion.text.clear()
        ciudad.text.clear()
    }
}