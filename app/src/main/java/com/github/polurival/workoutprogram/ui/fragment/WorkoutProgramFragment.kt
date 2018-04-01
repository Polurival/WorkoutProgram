package com.github.polurival.workoutprogram.ui.fragment


import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.github.polurival.workoutprogram.R
import com.github.polurival.workoutprogram.model.WorkoutModel
import com.github.polurival.workoutprogram.model.WorkoutScheduler
import com.github.polurival.workoutprogram.ui.recyclerview.AdapterModel
import com.github.polurival.workoutprogram.ui.recyclerview.RowType
import com.github.polurival.workoutprogram.ui.recyclerview.ScheduleAdapter
import com.github.polurival.workoutprogram.ui.recyclerview.ScheduleRow
import kotlinx.android.synthetic.main.fragment_workout_program.*


private const val ENTERED_WEIGHT = "entered_weight"

/**
 * A simple [Fragment] subclass.
 *
 */
class WorkoutProgramFragment : Fragment() {

    private var workoutType: String = ""
    private var enteredWeight: Double = 0.0

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
        workoutType = arguments?.getString(WORKOUT_TYPE)!!
        enteredWeight = (arguments?.getString(ENTERED_WEIGHT))!!.toDouble()
        val workoutSchedule = WorkoutScheduler().calculateProgram(enteredWeight)
        val allRows = prepareItems(workoutSchedule)

        if (schedule_recycler_view.adapter == null) {
            val adapter = ScheduleAdapter(allRows)
            schedule_recycler_view.adapter = adapter
        } else {
            (schedule_recycler_view.adapter as ScheduleAdapter).updateSchedule(allRows)
        }

        super.onActivityCreated(savedInstanceState)
    }

    /**
     * todo вынести это в фабрику
     */
    private fun prepareItems(workoutSchedule: ArrayList<WorkoutModel>): ArrayList<ScheduleRow> {
        val allRows = ArrayList<ScheduleRow>()

        val workoutNameRow = ScheduleRow(RowType.HEADER, AdapterModel("$workoutType ${getString(R.string.day_type)}"))
        allRows.add(workoutNameRow)
        val workoutColumnNamesRow = ScheduleRow(RowType.ROW,
                AdapterModel(null, getString(R.string.week), getString(R.string.weight),
                        getString(R.string.repetitions_number), getString(R.string.approaches_number)))
        allRows.add(workoutColumnNamesRow)

        for (week in workoutSchedule) {
            val weekRow = ScheduleRow(RowType.ROW, AdapterModel(null,
                    week.weekNumber.toString(),
                    week.weight.toString(),
                    week.repetitionsNumber.toString(),
                    week.approachesNumber.toString()))
            allRows.add(weekRow)
        }

        return allRows
    }
}
