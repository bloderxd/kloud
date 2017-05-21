package com.example.bloder.rxmvp.home.arch

import com.example.bloder.rxmvp.home.identifiers.FoodId
import com.example.bloder.rxmvp.home.representers.FoodRepresenter
import com.example.bloder.rxmvp.rx.RxFood
import java.util.*

/**
 * Created by bloder on 20/05/17.
 */
class FoodPresenter : FoodContract.Presenter<FoodId> {

    override var rxTicket by reactive()
    override var viewBuilder: HashMap<FoodId, () -> Unit> = hashMapOf()
    override var interactorBuilder: HashMap<FoodId, () -> Unit> = hashMapOf()

    override fun <T : RxFood.Representer> buildViewResponse(event: T) {

    }

    override fun <T : RxFood.Representer> buildInteractorResponse(event: T) {

    }

    override fun <T : RxFood.Representer> doReactiveWith(event: Class<T>) {
        onRx(event).subscribe { t -> onPost(t as FoodRepresenter, t.id) }
    }

    override fun fetchFood() {

    }

    override fun onFoodFetched() {

    }
}
