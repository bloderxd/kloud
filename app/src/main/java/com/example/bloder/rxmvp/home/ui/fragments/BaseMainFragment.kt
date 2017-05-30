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

/**
 * Created by bloder on 22/05/17.
 */
abstract class BaseMainFragment : Fragment() {

    protected val foodList by lazy { view?.findViewById(R.id.food_list) as RecyclerView }

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? = inflater?.inflate(R.layout.base_fragment, container, false)

    override fun onViewCreated(view: View?, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        foodList.layoutManager = LinearLayoutManager(activity)
        if (foodList.adapter == null) work()
    }

    open fun updateList(foods: List<Food>) {
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