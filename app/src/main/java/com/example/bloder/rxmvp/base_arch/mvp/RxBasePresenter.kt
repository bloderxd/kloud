package com.example.bloder.rxmvp.base_arch.mvp

import com.example.bloder.rxmvp.base_arch.mvp.view.StateKeeperRxBaseView
import com.example.bloder.rxmvp.base_arch.rx.RxBase
import com.example.bloder.rxmvp.rx.Cloud
import io.reactivex.Observer
import io.reactivex.disposables.Disposable
import java.util.*

/**
 * Created by bloder on 20/05/17.
 */
interface RxBasePresenter<K> : RxBase {

    val interactor: BaseInteractor
    val view: StateKeeperRxBaseView<*>
    var viewBuilder: HashMap<K, () -> Unit>
    var interactorBuilder: HashMap<K, () -> Unit>

    fun <T : Cloud.Representer> buildViewResponse(event: T)
    fun <T : Cloud.Representer> buildInteractorResponse(event: T)

    fun onPost(event: Cloud.Representer, id: K) {
        buildInteractorResponse(event)
        buildViewResponse(event)
        interactorBuilder[id]?.invoke()
        viewBuilder[id]?.invoke()
    }

    fun make(action: (Any?) -> Any) : Observer<Any> = object : Observer<Any> {
        override fun onSubscribe(d: Disposable?) {}
        override fun onComplete() {}
        override fun onError(e: Throwable?) {}
        override fun onNext(t: Any?) {
            action.invoke(t)
        }
    }
}