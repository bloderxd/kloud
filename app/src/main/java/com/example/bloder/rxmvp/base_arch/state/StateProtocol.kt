package com.example.bloder.rxmvp.base_arch.state

import android.support.v4.app.Fragment
import com.example.bloder.rxmvp.rx.Cloud
import java.util.*

/**
 * Created by bloder on 23/05/17.
 */
interface StateProtocol<T : StateProtocol.Representer> {

    var state: HashMap<T, Fragment>

    fun prepareStateProtocol() { state = hashMapOf() }
    fun saveState(from: T, ref: Fragment) { state.put(from, ref) }
    fun restoreStateFrom(from: T) : Fragment? = state[from]
    fun getStateRepresenter() : Class<T>

    interface Representer : Cloud.Representer
}