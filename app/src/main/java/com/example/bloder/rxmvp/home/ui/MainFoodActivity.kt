package com.example.bloder.rxmvp.home.ui

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.design.widget.TabLayout
import android.widget.FrameLayout
import com.example.bloder.rxmvp.R

class MainFoodActivity : AppCompatActivity() {

    private val tab       by lazy { findViewById(R.id.tab) as TabLayout }
    private val container by lazy { findViewById(R.id.container) as FrameLayout }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_food)
    }
}
