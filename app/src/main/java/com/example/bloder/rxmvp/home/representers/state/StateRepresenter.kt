package com.example.bloder.rxmvp.home.representers.state

import android.support.v4.app.Fragment
import com.example.bloder.rxmvp.home.identifiers.state.ChildId
import com.example.bloder.rxmvp.rx.Cloud

/**
 * Created by bloder on 23/05/17.
 */
data class StateRepresenter(val from: ChildId, val ref: Fragment) : Cloud.Representer