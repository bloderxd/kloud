package com.example.bloder.rxmvp.home.representers

import android.support.v4.app.Fragment
import com.example.bloder.rxmvp.home.identifiers.FoodId
import com.example.bloder.rxmvp.rx.RxFood

/**
 * Created by bloder on 20/05/17.
 */
class FoodRepresenter(val id: FoodId, val ref: Fragment) : RxFood.Representer