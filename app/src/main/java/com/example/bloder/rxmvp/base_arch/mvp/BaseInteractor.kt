package com.example.bloder.rxmvp.base_arch.mvp

/**
 * Created by bloder on 23/05/17.
 */
interface BaseInteractor {
    val presenter: RxBasePresenter<*>
}