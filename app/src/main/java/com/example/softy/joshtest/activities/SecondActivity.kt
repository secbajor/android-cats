package com.example.softy.joshtest.activities

import android.os.Bundle
import com.google.android.material.snackbar.Snackbar
import androidx.appcompat.app.AppCompatActivity;
import com.example.softy.joshtest.R
import com.example.softy.joshtest.models.PlaceKitten
import com.example.softy.joshtest.util.Constants
import com.example.softy.joshtest.util.Tools

import kotlinx.android.synthetic.main.activity_second.*

class SecondActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)

        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        val kitten = intent?.extras?.getParcelable(Constants.EXTRA_PLACE_KITTEN) as PlaceKitten
        Tools.toast(this, kitten.url)

        Tools.loadImage(image_view, kitten.url)
    }

}
