package com.example.bloder.rxmvp.home.ui.fragments

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.bloder.rxmvp.R

/**
 * Created by bloder on 22/05/17.
 */
abstract class BaseMainFragment : Fragment() {

    protected val foodList by lazy { view?.findViewById(R.id.food_list) as RecyclerView }

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater?.inflate(R.layout.base_fragment, container)
    }

    override fun onViewCreated(view: View?, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }

    abstract fun shouldWork() : Boolean
    abstract fun work()
}