package com.github.polurival.workoutprogram.ui.activity

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.github.polurival.workoutprogram.R
import com.github.polurival.workoutprogram.addFragment
import com.github.polurival.workoutprogram.ui.fragment.CurrentWorkingWeightFragment

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        if (savedInstanceState == null) {
            addFragment(R.id.root_container,
                    CurrentWorkingWeightFragment.newInstance(getString(R.string.bench_press)))
            // only bench press for now
        }
    }
}
