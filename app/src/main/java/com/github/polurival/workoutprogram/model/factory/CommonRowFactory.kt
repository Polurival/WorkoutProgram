package com.github.polurival.workoutprogram.model.factory

import com.github.polurival.workoutprogram.ResourceManager
import com.github.polurival.workoutprogram.ui.recyclerview.AdapterModel
import com.github.polurival.workoutprogram.ui.recyclerview.RowType
import com.github.polurival.workoutprogram.ui.recyclerview.ScheduleRow

/**
 * Фабрика, которая включает в себя ScheduleFactory
 * а также может создавать разделители, дни недели и прочее
 *
 * @author Polurival on 08.04.2018.
 */
interface CommonRowFactory {

    fun getAllWorkout(): ArrayList<ScheduleRow>

    fun getDayRow(resourceManager: ResourceManager, stringId: Int): ScheduleRow {
        return ScheduleRow(RowType.DAY,
                AdapterModel(resourceManager.getString(stringId)))
    }

    fun getDividerRow(): ScheduleRow {
        return ScheduleRow(RowType.DIVIDER, AdapterModel())
    }
}