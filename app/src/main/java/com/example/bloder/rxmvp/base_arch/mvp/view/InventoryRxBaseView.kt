package com.example.bloder.rxmvp.base_arch.mvp.view

import com.example.bloder.rxmvp.base_arch.state.StateProtocol
import com.example.bloder.rxmvp.rx.Cloud

/**
 * Created by bloder on 23/05/17.
 */
interface InventoryRxBaseView<T : Cloud.Representer, R : StateProtocol.Representer> : StateProtocol<R>, RxBaseView<T> {

    fun onReceiveState(representer: R)

    fun turnOnStateReceiver() {
        prepareStateProtocol()
        onReceiveFrom(getStateRepresenter()).subscribe { t -> onReceiveState(t as R) }
    }
}