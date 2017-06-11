package com.example.bloder.rxmvp.home.ui.fragments

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.bloder.rxmvp.R
import com.example.bloder.rxmvp.data.Food
import com.example.bloder.rxmvp.home.ui.adapters.FoodListAdapter
import java.io.Serializable

/**
 * Created by bloder on 22/05/17.
 */
abstract class BaseMainFragment : Fragment() {

    internal var foods : List<Food> = listOf()
    protected val foodList by lazy { view?.findViewById(R.id.food_list) as RecyclerView }

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? = inflater?.inflate(R.layout.base_fragment, container, false)

    override fun onViewCreated(view: View?, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        if (savedInstanceState != null) {
            foods = if (savedInstanceState["foods"] != null && savedInstanceState["foods"] is List<*>) savedInstanceState["foods"] as List<Food> else listOf()
        }
        else {
            foodList.layoutManager = LinearLayoutManager(activity)
            if (foodList.adapter == null) work()
        }
    }

    override fun onSaveInstanceState(outState: Bundle?) {
        super.onSaveInstanceState(outState)
        outState?.putSerializable("foods", foods as Serializable)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
    }

    open fun updateList(foods: List<Food>) {
        this.foods = foods
        (foodList.adapter as FoodListAdapter).updateFoods(foods)
    }

    open fun removeFromList(food: Food) {
        (foodList.adapter as FoodListAdapter).remove(food)
    }

    fun initAdapter(onStarClicked: (Food) -> Any?) {
        foodList.adapter = FoodListAdapter(context, arrayListOf(), onStarClicked)
    }

    abstract fun work()
}