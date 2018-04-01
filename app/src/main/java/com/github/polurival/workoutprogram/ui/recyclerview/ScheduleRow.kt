package com.github.polurival.workoutprogram.ui.recyclerview

/**
 * @author Polurival on 01.04.2018.
 */
enum class RowType {
    HEADER,
    ROW
}

data class ScheduleRow(var type: RowType, var schedule: AdapterModel)