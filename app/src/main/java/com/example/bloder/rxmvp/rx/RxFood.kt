package com.example.bloder.rxmvp.rx

import io.reactivex.subjects.PublishSubject
import io.reactivex.subjects.Subject

/**
 * Created by bloder on 20/05/17.
 */
class RxFood {

    private val subject : Subject<Any> = PublishSubject.create()

    fun post(representer: Representer) {
        subject.onNext(representer)
    }

    fun observable() : Subject<Any> = subject

    interface Representer
}