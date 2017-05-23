package com.example.bloder.rxmvp.home.arch

import com.example.bloder.rxmvp.data.Food
import com.example.bloder.rxmvp.home.identifiers.FoodId
import com.example.bloder.rxmvp.home.representers.FoodRepresenter
import com.example.bloder.rxmvp.rx.Cloud
import java.util.*
import kotlin.reflect.KProperty

/**
 * Created by bloder on 20/05/17.
 */
class FoodPresenter(override val view: FoodContract.View) : FoodContract.Presenter<FoodId> {

    override val interactor by lazy { FoodInteractor(this) }
    override var cloud by cloud()
    override var viewBuilder: HashMap<FoodId, () -> Unit> = hashMapOf()
    override var interactorBuilder: HashMap<FoodId, () -> Unit> = hashMapOf()

    override fun fetchFood() {
        interactor.fetchFood()
    }

    override fun onFoodFetched(foods: List<Food>) {
        view.onFoodFetched(foods)
    }

    override fun <T : Cloud.Representer> buildViewResponse(event: T) {
        val representer = event as FoodRepresenter
        viewBuilder = hashMapOf(
                FoodId.ON_FOOD_FETCHED to { onFoodFetched(representer.foods) }
        )
    }

    override fun <T : Cloud.Representer> buildInteractorResponse(event: T) {
        interactorBuilder = hashMapOf(
                FoodId.FETCH_FOOD to { fetchFood() }
        )
    }

    override fun registerReceiver() {
        onReceiveFrom(FoodRepresenter::class.java).subscribe { t -> onPost(t as FoodRepresenter, t.id) }
    }

    private operator fun <T> Lazy<T>.setValue(foodPresenter: FoodPresenter, property: KProperty<*>, t: T) {}
}
