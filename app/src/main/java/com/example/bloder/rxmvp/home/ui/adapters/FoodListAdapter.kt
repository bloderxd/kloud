package com.example.bloder.rxmvp.home.ui.adapters

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.example.bloder.rxmvp.R
import com.example.bloder.rxmvp.data.Food
import com.squareup.picasso.Picasso

/**
 * Created by bloder on 27/05/17.
 */
class FoodListAdapter(val context: Context, val foods: MutableList<Food>, val onStarClicked: (Food) -> Any?) : RecyclerView.Adapter<FoodListAdapter.ViewHolder>() {

    override fun getItemCount(): Int = foods.size

    override fun onBindViewHolder(holder: ViewHolder?, position: Int) {
        holder?.bind(foods[position])
    }

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): ViewHolder = ViewHolder(context, onStarClicked)

    fun updateFoods(foods: List<Food>) {
        val oldSize = this.foods.size
        this.foods.addAll(foods)
        this.notifyItemRangeChanged(oldSize, this.foods.size)
        this.notifyDataSetChanged()
    }

    fun remove(food: Food) {
        val index = foods.indexOf(food)
        foods.remove(food)
        notifyItemRemoved(index)
    }

    class ViewHolder(val context: Context, val onStarClicked: (Food) -> Any?) : RecyclerView.ViewHolder(LayoutInflater.from(context).inflate(R.layout.view_holder_foods, null)) {
        fun bind(food: Food) {
            Picasso.with(context).load(food.image).into(itemView?.findViewById(R.id.food_cover) as ImageView)
            (itemView.findViewById(R.id.food_name) as TextView).text = food.name
            itemView.findViewById(R.id.star_food).setOnClickListener { onStarClicked.invoke(food) }
        }
    }
}