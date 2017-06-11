package com.example.bloder.rxmvp.base_arch.mvp.view

import com.example.bloder.rxmvp.base_arch.mvp.RxBasePresenter
import com.example.bloder.rxmvp.base_arch.rx.CloudProtocol
import com.example.bloder.rxmvp.rx.Cloud

/**
 * Created by bloder on 26/05/17.
 */
interface RxBaseView<T : Cloud.Representer> : CloudProtocol<T> {
    val presenter : RxBasePresenter<*>?
}