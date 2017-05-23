package com.example.bloder.rxmvp.home.ui.delegates

import android.app.Activity
import android.support.v4.app.FragmentStatePagerAdapter
import android.support.v4.view.ViewPager
import kotlin.reflect.KProperty

/**
 * Created by bloder on 22/05/17.
 */
class ViewPagerDelegate(val activity: Activity, val resource: Int, val adapter: FragmentStatePagerAdapter) {

    operator fun getValue(thisRef: Any?, property: KProperty<*>) : ViewPager {
        val viewPager = activity.findViewById(resource) as ViewPager
        viewPager.adapter = adapter
        return viewPager
    }
}