package com.example.bloder.rxmvp.base_arch

import android.support.v4.app.Fragment

/**
 * Created by bloder on 23/05/17.
 */
interface StateProtocol<T> {

    val state: HashMap<T, Fragment>

    fun defaultStateInitialization() : HashMap<T, Fragment>

    fun update(from: T, ref: Fragment) { state.put(from, ref) }

    fun restoreFrom(from: T) : Fragment? = state[from]

    fun letWith(from: T, ref: Fragment, action: () -> Any?) {
        action.invoke()
        update(from, ref)
    }
}