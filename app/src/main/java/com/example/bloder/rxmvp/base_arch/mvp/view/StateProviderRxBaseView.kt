package com.example.bloder.rxmvp.base_arch.mvp.view

import com.example.bloder.rxmvp.base_arch.rx.RxBase
import com.example.bloder.rxmvp.home.representers.state.StateRepresenter
import com.example.bloder.rxmvp.rx.Cloud
import java.util.*

/**
 * Created by bloder on 23/05/17.
 */
interface StateProviderRxBaseView<T> : RxBase {

    var actions: HashMap<T, () -> Any>

    fun buildActions(event: Cloud.Representer)

    fun onPost(event: Cloud.Representer, id: T) {
        buildActions(event)
        run { actions[id]?.invoke() }
    }

    fun getStateRepresenter() : StateRepresenter

    fun run(action: () -> Any?) {
        action.invoke()
        cloud.post(getStateRepresenter())
    }
}