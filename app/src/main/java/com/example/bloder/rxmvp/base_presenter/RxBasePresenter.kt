package com.example.bloder.rxmvp.base_presenter

import com.example.bloder.rxmvp.rx.RxFood
import io.reactivex.Observable
import io.reactivex.ObservableTransformer
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import org.reactivestreams.Subscriber
import org.reactivestreams.Subscription
import java.util.*

/**
 * Created by bloder on 20/05/17.
 */
interface RxBasePresenter<K> {

    var rxTicket: RxFood
    var viewBuilder: HashMap<K, () -> Unit>
    var interactorBuilder: HashMap<K, () -> Unit>

    fun <T : RxFood.Representer> buildViewResponse(event: T)
    fun <T : RxFood.Representer> buildInteractorResponse(event: T)
    fun <T : RxFood.Representer> doReactiveWith(event: Class<T>)
    fun <T : RxFood.Representer> onRx(event: Class<T>) : Observable<in T>? = rxTicket.observable().ofType(event).compose(composeSeq())

    fun <T> composeSeq() : ObservableTransformer<T, T> = ObservableTransformer {
        flowable -> flowable.observeOn(AndroidSchedulers.mainThread()).subscribeOn(Schedulers.newThread())
    }

    fun onPost(event: RxFood.Representer, id: K) {
        buildInteractorResponse(event)
        buildViewResponse(event)
        interactorBuilder[id]?.invoke()
        viewBuilder[id]?.invoke()
    }


    fun make(action: (Any?) -> Any) : Subscriber<Any> = object : Subscriber<Any> {
        override fun onSubscribe(s: Subscription?) {}
        override fun onComplete() {}
        override fun onError(e: Throwable?) {}
        override fun onNext(t: Any?) {
            action.invoke(t)
        }
    }
}