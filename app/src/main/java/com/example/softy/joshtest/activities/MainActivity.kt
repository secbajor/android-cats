package com.example.softy.joshtest.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.softy.joshtest.R
import com.example.softy.joshtest.models.PlaceKitten
import com.example.softy.joshtest.util.Constants
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private var textFlag = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        button1.setOnClickListener {
            textFlag = !textFlag
            text_view.text = when(textFlag){
                true -> getString(R.string.text_new)
                false -> getString(R.string.text_old)
            }
        }

        button2.setOnClickListener {
            //TODO make sure edit_text_height, width actually has a value
            val intent = Intent(this, SecondActivity::class.java)
            val height = Integer.valueOf(edit_text_height?.text.toString())
            val width = Integer.valueOf(edit_text_width?.text.toString())
            val newKitten = PlaceKitten(height, width)
            
            intent.putExtra(Constants.EXTRA_PLACE_KITTEN, newKitten)

            startActivity(intent)
        }

        cat_list_button.setOnClickListener {
            startActivity(Intent(this, CatListActivity::class.java))
        }
    }
}
