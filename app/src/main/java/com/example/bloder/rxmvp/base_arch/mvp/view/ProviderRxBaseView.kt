package com.example.bloder.rxmvp.base_arch.mvp.view

import com.example.bloder.rxmvp.base_arch.rx.CloudProtocol
import com.example.bloder.rxmvp.base_arch.state.StateProtocol
import com.example.bloder.rxmvp.rx.Cloud

/**
 * Created by bloder on 23/05/17.
 */
interface ProviderRxBaseView<T : Cloud.Representer, out R : StateProtocol.Representer> : CloudProtocol<T> {

    fun getStateRepresenter() : R

    fun run(action: () -> Any?) {
        action.invoke()
        cloud().post(getStateRepresenter())
    }
}