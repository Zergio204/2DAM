package com.example.ejem05_llamandootrosactivitys

import android.os.Parcel
import android.os.Parcelable

class Contador(var contador:Int) : Parcelable{
    constructor(parcel: Parcel) : this(parcel.readInt()) {
    }

    override fun toString(): String {
        return "$contador"
    }

    override fun describeContents(): Int {
        TODO("Not yet implemented")
    }

    override fun writeToParcel(p0: Parcel, p1: Int) {
        TODO("Not yet implemented")
    }

    companion object CREATOR : Parcelable.Creator<Contador> {
        override fun createFromParcel(parcel: Parcel): Contador {
            return Contador(parcel)
        }

        override fun newArray(size: Int): Array<Contador?> {
            return arrayOfNulls(size)
        }
    }
}