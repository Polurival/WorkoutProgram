package com.github.polurival.workoutprogram.ui.fragment


import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import com.github.polurival.workoutprogram.R


/**
 * todo программа должна начинаться с этого фрагмента, но пока есть только одно упражнение, в этом нет смысла
 *
 * Здесь происходит выбор базового упражнения, для которого необходимо составить программуу
 *
 */
class WorkoutTypeFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_workout_type, container, false)
    }
}
