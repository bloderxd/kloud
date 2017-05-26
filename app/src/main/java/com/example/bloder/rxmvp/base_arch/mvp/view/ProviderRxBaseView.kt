package com.example.bloder.rxmvp.base_arch.mvp.view

import com.example.bloder.rxmvp.base_arch.state.StateProtocol
import com.example.bloder.rxmvp.rx.Cloud

/**
 * Created by bloder on 23/05/17.
 */
interface ProviderRxBaseView<T : Cloud.Representer, out R : StateProtocol.Representer> : RxBaseView<T> {

    fun getStateRepresenter() : R

    fun run(action: () -> Any?) {
        action.invoke()
        cloud.post(getStateRepresenter())
    }
}