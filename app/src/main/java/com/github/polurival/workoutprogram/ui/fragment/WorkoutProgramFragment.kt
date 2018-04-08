package com.github.polurival.workoutprogram.ui.fragment


import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.github.polurival.workoutprogram.R
import com.github.polurival.workoutprogram.model.factory.WorkoutType
import com.github.polurival.workoutprogram.model.factory.WorkoutFactory
import com.github.polurival.workoutprogram.ui.recyclerview.ScheduleAdapter
import kotlinx.android.synthetic.main.fragment_workout_program.*


private const val ENTERED_WEIGHT = "entered_weight"

/**
 * A simple [Fragment] subclass.
 *
 */
class WorkoutProgramFragment : Fragment() {

    private lateinit var workoutType: String
    private lateinit var enteredWeight: String

    companion object {
        fun newInstance(workoutType: String, enteredWeight: String): WorkoutProgramFragment {
            val fragment = WorkoutProgramFragment()
            val args = Bundle()
            args.putString(WORKOUT_TYPE, workoutType)
            args.putString(ENTERED_WEIGHT, enteredWeight)
            fragment.arguments = args
            return fragment
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_workout_program, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        workoutType = arguments?.getString(WORKOUT_TYPE)!!
        enteredWeight = (arguments?.getString(ENTERED_WEIGHT))!!

        val workoutFactory = WorkoutFactory(WorkoutType.valueOf(workoutType), enteredWeight)
        val allWorkout = workoutFactory.allWorkout()

        if (schedule_recycler_view.adapter == null) {
            val adapter = ScheduleAdapter(allWorkout)
            schedule_recycler_view.adapter = adapter
        } else {
            (schedule_recycler_view.adapter as ScheduleAdapter).updateSchedule(allWorkout)
        }
    }
}
