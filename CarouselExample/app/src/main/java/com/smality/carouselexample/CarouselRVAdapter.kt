package com.smality.carouselexample

import android.view.*
import android.widget.*
import androidx.recyclerview.widget.RecyclerView

class CarouselRVAdapter(private val carouselDataListTitle: ArrayList<String>,private val carouselDataListImage: ArrayList<Int>) :
    RecyclerView.Adapter<CarouselRVAdapter.CarouselItemViewHolder>() {
    class CarouselItemViewHolder(view: View) : RecyclerView.ViewHolder(view)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CarouselItemViewHolder {
        val viewHolder = LayoutInflater.from(parent.context).inflate(R.layout.item, parent, false)
        return CarouselItemViewHolder(viewHolder)
    }

    override fun onBindViewHolder(holder: CarouselItemViewHolder, position: Int) {
        val image=holder.itemView.findViewById<ImageView>(R.id.imageView)
        image.setImageResource(carouselDataListImage[position])
        val textView = holder.itemView.findViewById<TextView>(R.id.textview)
        textView.text = carouselDataListTitle[position]
    }

    override fun getItemCount(): Int {
        return carouselDataListTitle.size
    }
}