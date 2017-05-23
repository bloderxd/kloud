package com.example.bloder.rxmvp.home.ui.fragments

import com.example.bloder.rxmvp.data.Food
import com.example.bloder.rxmvp.home.arch.FoodContract
import com.example.bloder.rxmvp.home.identifiers.FoodId
import com.example.bloder.rxmvp.home.identifiers.fragments.FoodChildViewId
import com.example.bloder.rxmvp.home.identifiers.state.ChildId
import com.example.bloder.rxmvp.home.representers.FoodFragmentRepresenter
import com.example.bloder.rxmvp.home.representers.FoodRepresenter
import com.example.bloder.rxmvp.home.representers.state.StateRepresenter
import com.example.bloder.rxmvp.rx.Cloud
import java.util.*

/**
 * Created by bloder on 22/05/17.
 */
class FoodFragment : BaseMainFragment(), FoodContract.FoodView {

    override var actions: HashMap<FoodChildViewId, () -> Any> = hashMapOf()
    override var cloud by cloud()
    private val foods: MutableList<Food> = mutableListOf()

    override fun onFoodFetched(foods: List<Food>) {
        this.foods.addAll(foods)
    }

    override fun work() {
        registerReceiver()
        askForFoods()
    }

    private fun askForFoods() {
        cloud.post(FoodRepresenter(FoodId.FETCH_FOOD))
    }

    override fun buildActions(event: Cloud.Representer) {
        val representer = event as FoodFragmentRepresenter
        actions = hashMapOf(
                FoodChildViewId.ON_FOOD_FETCHED to { onFoodFetched(representer.foods) }
        )
    }

    override fun registerReceiver() {
        onReceiveFrom(FoodFragmentRepresenter::class.java).subscribe { t -> onPost(t as FoodFragmentRepresenter, t.id) }
    }

    override fun getStateRepresenter(): StateRepresenter = StateRepresenter(ChildId.FOOD, this)
    override fun shouldWork(): Boolean = foods.size == 0
}