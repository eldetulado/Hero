package com.example.oso.superhero

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_detail.*

class DetailActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        val data:SuperHeroe = intent.extras.getParcelable(MainActivity.PEOPLE)
        nombreHeroe.text = data.nomSuperHeroe
        nombre.text = data.nombre
        apellido.text = data.apellido
        edad.text = data.edad.toString()
        direccion.text = data.direccion
        ciudad.text = data.ciudad
        imageView2.setImageBitmap(data.img)
    }
}
