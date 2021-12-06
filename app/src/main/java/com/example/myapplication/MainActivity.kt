package com.example.myapplication

import android.Manifest
import android.app.Activity
import android.content.ComponentName
import android.content.Context
import android.content.Intent
import android.content.ServiceConnection
import android.os.Bundle
import android.os.IBinder
import android.util.Log
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.widget.ViewPager2
import layout.ViewPager2Adapter

class MainActivity : FragmentActivity() {
        private var mViewPager2: ViewPager2? = null


        override fun onCreate(savedInstanceState: Bundle?) {
            super.onCreate(savedInstanceState)
            setContentView(R.layout.activity_main)


            val fragments: ArrayList<Fragment> = ArrayList()
            with(fragments) {
                add(ConnectFragment.newInstance())
                add(GraphFragment.newInstance())
            }

            mViewPager2 = findViewById<View>(R.id.viewPager) as ViewPager2
            mViewPager2?.let {
                it.adapter = ViewPager2Adapter(this, fragments)
            }
        }
    }