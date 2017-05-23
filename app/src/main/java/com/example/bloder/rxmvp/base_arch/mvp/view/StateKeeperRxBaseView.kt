package com.example.bloder.rxmvp.base_arch.mvp.view

import com.example.bloder.rxmvp.base_arch.mvp.RxBasePresenter
import com.example.bloder.rxmvp.base_arch.rx.RxBase
import com.example.bloder.rxmvp.base_arch.state.StateProtocol
import com.example.bloder.rxmvp.home.representers.state.StateRepresenter

/**
 * Created by bloder on 23/05/17.
 */
interface StateKeeperRxBaseView<T> : StateProtocol<T>, RxBase {

    val presenter : RxBasePresenter<*>

    fun initPresenter()

    fun updateState(state: StateRepresenter)

    fun turnOnStateReceiver() {
        onReceiveFrom(StateRepresenter::class.java).subscribe { t -> updateState(t as StateRepresenter) }
    }
}