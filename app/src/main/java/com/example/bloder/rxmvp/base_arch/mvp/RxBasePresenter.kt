package com.example.bloder.rxmvp.base_arch.mvp

import com.example.bloder.rxmvp.base_arch.mvp.view.InventoryRxBaseView
import com.example.bloder.rxmvp.base_arch.rx.RxBase
import com.example.bloder.rxmvp.rx.Cloud

/**
 * Created by bloder on 20/05/17.
 */
interface RxBasePresenter<T : Cloud.Representer> : RxBase<T> {
    val interactor: BaseInteractor
    val view: InventoryRxBaseView<*, *>
}