package com.example.bloder.rxmvp.base_arch.rx

import com.example.bloder.rxmvp.rx.Cloud
import com.example.bloder.rxmvp.rx.CloudDelegate
import io.reactivex.Observable
import io.reactivex.ObservableTransformer
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

/**
 * Created by bloder on 23/05/17.
 */
interface RxBase<T : Cloud.Representer> {

    var cloud: Cloud

    fun onReceive(event: T)

    fun <T : Cloud.Representer> onReceiveFrom(event: Class<T>) : Observable<in T> = cloud.observable().ofType(event).compose(composeSeq())

    fun <T> composeSeq() : ObservableTransformer<T, T> = ObservableTransformer {
        flowable -> flowable.observeOn(AndroidSchedulers.mainThread()).subscribeOn(Schedulers.newThread())
    }

    fun getRepresenter() : Class<T>

    fun registerReceiver() {
        onReceiveFrom(getRepresenter()).subscribe { t -> onReceive(t as T) }
    }

    fun cloud() : CloudDelegate = CloudDelegate()
}