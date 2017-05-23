package com.example.bloder.rxmvp.base_arch.state

import android.support.v4.app.Fragment
import java.util.*

/**
 * Created by bloder on 23/05/17.
 */
interface StateProtocol<T> {

    var state: HashMap<T, Fragment>

    fun prepareStateProtocol() { state = hashMapOf() }
    fun updateRef(from: T, ref: Fragment) { state.put(from, ref) }
    fun restoreFrom(from: T) : Fragment? = state[from]
}