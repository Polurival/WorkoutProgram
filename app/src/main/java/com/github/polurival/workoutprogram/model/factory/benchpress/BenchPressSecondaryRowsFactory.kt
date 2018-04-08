package com.github.polurival.workoutprogram.model.factory.benchpress

import com.github.polurival.workoutprogram.R
import com.github.polurival.workoutprogram.ResourceManager
import com.github.polurival.workoutprogram.model.WorkoutModel
import com.github.polurival.workoutprogram.model.factory.BaseRowsFactory
import com.github.polurival.workoutprogram.ui.recyclerview.AdapterModel
import com.github.polurival.workoutprogram.ui.recyclerview.RowType
import com.github.polurival.workoutprogram.ui.recyclerview.ScheduleRow

/**
 * @author Polurival on 08.04.2018.
 */
class BenchPressSecondaryRowsFactory(weight: String) : BaseRowsFactory(weight) {

    override fun createTitleRow(resourceManager: ResourceManager): ScheduleRow {
        return ScheduleRow(RowType.HEADER, AdapterModel(resourceManager.getString(R.string.bench_press)))
    }

    override fun calculate(): ArrayList<WorkoutModel> {
        val workoutSchedule = arrayListOf<WorkoutModel>()

        var weight = weight.toDouble() - 17.5
        val repeatCount = 10

        for (weekNumber in 1..12) {
            when (weekNumber) {
                2, 4, 6, 8, 9, 11, 12 -> weight += 2.5
            }
            workoutSchedule.add(WorkoutModel(null, weekNumber, weight, repeatCount))
        }

        return workoutSchedule
    }
}