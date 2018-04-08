package com.github.polurival.workoutprogram.ui.activity

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.github.polurival.workoutprogram.R
import com.github.polurival.workoutprogram.addFragment
import com.github.polurival.workoutprogram.model.factory.WorkoutType
import com.github.polurival.workoutprogram.ui.fragment.CurrentWorkingWeightFragment

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        if (savedInstanceState == null) {
            // todo здесь добавлять фрагмент WorkoutTypeFragment и о туда уже стартовать CurrentWorkingWeightFragment
            val workoutName = WorkoutType.BENCH_PRESS.name
            addFragment(R.id.root_container, CurrentWorkingWeightFragment.newInstance(workoutName))
            // only bench press for now
        }
    }
}
