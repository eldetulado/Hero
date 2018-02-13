package com.example.oso.superhero

import android.graphics.Bitmap
import android.os.Parcel
import android.os.Parcelable

class SuperHeroe(val nombre:String, val apellido:String, val nomSuperHeroe:String, val edad:Int,
              val direccion:String, val ciudad:String, val img:Bitmap) : Parcelable {
    constructor(parcel: Parcel) : this(
            parcel.readString(),
            parcel.readString(),
            parcel.readString(),
            parcel.readInt(),
            parcel.readString(),
            parcel.readString(),
            parcel.readParcelable(Bitmap::class.java.classLoader)) {
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(nombre)
        parcel.writeString(apellido)
        parcel.writeString(nomSuperHeroe)
        parcel.writeInt(edad)
        parcel.writeString(direccion)
        parcel.writeString(ciudad)
        parcel.writeParcelable(img, flags)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<SuperHeroe> {
        override fun createFromParcel(parcel: Parcel): SuperHeroe {
            return SuperHeroe(parcel)
        }

        override fun newArray(size: Int): Array<SuperHeroe?> {
            return arrayOfNulls(size)
        }
    }
}