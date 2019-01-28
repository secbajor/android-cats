package com.example.softy.joshtest.util

import android.content.Context
import android.widget.ImageView
import android.widget.Toast
import com.squareup.picasso.Picasso

class Tools {
    //Layer of abstraction allows us to instantiate image loader Picasso with our own function
    //so we are able to easily replace Picasso in the future if needed
    companion object {

        @JvmStatic
        fun loadImage(imageView: ImageView, url: String){
            Picasso.get()
                .load(url)
                .into(imageView);
        }

        @JvmStatic
        fun toast(context: Context, message: String){
            Toast.makeText(context, message, Toast.LENGTH_SHORT).show()
        }

    }
}