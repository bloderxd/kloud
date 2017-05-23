package com.example.bloder.rxmvp.base_arch

import com.example.bloder.rxmvp.rx.RxFood
import com.example.bloder.rxmvp.rx.RxFoodDelegate
import io.reactivex.Observable
import io.reactivex.ObservableTransformer
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

/**
 * Created by bloder on 23/05/17.
 */
interface RxBaseView<K> : StateProtocol<K> {

    var rxTicket: RxFood

    fun <T : RxFood.Representer> onReceiveFrom(event: Class<T>) : Observable<in T> = rxTicket.observable().ofType(event).compose(composeSeq())

    fun <T> composeSeq() : ObservableTransformer<T, T> = ObservableTransformer {
        flowable -> flowable.observeOn(AndroidSchedulers.mainThread()).subscribeOn(Schedulers.newThread())
    }

    fun reactive() : RxFoodDelegate = RxFoodDelegate()
}