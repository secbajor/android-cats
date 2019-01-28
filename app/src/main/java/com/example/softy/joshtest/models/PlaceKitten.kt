package com.example.softy.joshtest.models

import android.os.Parcel
import android.os.Parcelable

data class PlaceKitten(
    val height: Int,
    val width: Int
) : Parcelable {
    companion object {
        @JvmField
        val CREATOR: Parcelable.Creator<PlaceKitten> = object : Parcelable.Creator<PlaceKitten> {
            override fun createFromParcel(source: Parcel): PlaceKitten = PlaceKitten(source)
            override fun newArray(size: Int): Array<PlaceKitten?> = arrayOfNulls(size)
        }
    }

    var url: String = ""
        get() = "https://placekitten.com/$width/$height"

    constructor(source: Parcel) : this(
        source.readInt(),
        source.readInt()
    )

    override fun writeToParcel(dest: Parcel, flags: Int) {
        dest.writeInt(height)
        dest.writeInt(width)
    }

    override fun describeContents(): Int = 0
}

