package com.example.softy.joshtest.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.softy.joshtest.R
import com.example.softy.joshtest.models.PlaceKitten
import com.example.softy.joshtest.util.Tools
import kotlinx.android.synthetic.main.activity_cat_list.*

class CatListActivity : AppCompatActivity() {

    val cats = ArrayList<PlaceKitten>()
    val adapter = CatAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cat_list)

        for (i in 1..10) {
            cats.add(generatePlaceKitten())
        }

        cat_list.adapter = adapter


    }

    private fun generatePlaceKitten(): PlaceKitten{
        val randWidth = (4..10).shuffled().last()*100
        val randHeight = (4..10).shuffled().last()*100
        return PlaceKitten(randWidth, randHeight)
    }

    inner class CatAdapter(): RecyclerView.Adapter<CatAdapter.CatHolder>(){
        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CatAdapter.CatHolder {
            return CatHolder(
                LayoutInflater.from(parent.context).inflate(
                    R.layout.cat_card,
                    parent,
                    false))

        }

        override fun getItemCount(): Int = cats.size

        override fun onBindViewHolder(holder: CatAdapter.CatHolder, position: Int) {
            val cat = cats[position]
            holder.text.text = cat.url
            Tools.loadImage(holder.image, cat.url)

        }

        inner class CatHolder(view: View) : RecyclerView.ViewHolder(view), View.OnClickListener {

            val image:ImageView = view.findViewById(R.id.cat_card_image)
            val text:TextView = view.findViewById(R.id.cat_card_text)

            init {
                image.setOnClickListener(this)
            }

            override fun onClick(v: View) {
                val newPlaceKitten = generatePlaceKitten()

                cats[adapterPosition] = newPlaceKitten
                adapter.notifyItemChanged(adapterPosition)

                Tools.toast(v.context, newPlaceKitten.url)


            }
        }

    }
}
