package com.example.bloder.rxmvp.base_arch.mvp

import com.example.bloder.rxmvp.base_arch.mvp.view.RxBaseView
import com.example.bloder.rxmvp.base_arch.rx.CloudProtocol
import com.example.bloder.rxmvp.rx.Cloud

/**
 * Created by bloder on 20/05/17.
 */
interface RxBasePresenter<T : Cloud.Representer> : CloudProtocol<T> {
    val interactor: BaseInteractor
    val view: RxBaseView<*>
}