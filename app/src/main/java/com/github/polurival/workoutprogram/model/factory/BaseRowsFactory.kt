package com.github.polurival.workoutprogram.model.factory

import com.github.polurival.workoutprogram.model.WorkoutModel
import com.github.polurival.workoutprogram.ui.recyclerview.AdapterModel
import com.github.polurival.workoutprogram.ui.recyclerview.RowType
import com.github.polurival.workoutprogram.ui.recyclerview.ScheduleRow

/**
 * @author Polurival on 08.04.2018.
 */
abstract class BaseRowsFactory(val weight: String) : ScheduleFactory {

    override fun createBodyRow(): ArrayList<ScheduleRow> {
        val allBodyRows = ArrayList<ScheduleRow>()
        val weeks = calculate()
        for (week in weeks) {
            val weekRow = ScheduleRow(RowType.ROW, AdapterModel(null,
                    week.weekNumber.toString(),
                    week.weight.toString(),
                    week.repetitionsNumber.toString(),
                    week.approachesNumber.toString()))
            allBodyRows.add(weekRow)
        }
        return allBodyRows
    }

    abstract fun calculate(): ArrayList<WorkoutModel>
}