package com.github.polurival.workoutprogram.ui.recyclerview


import android.support.v7.util.DiffUtil
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.github.polurival.workoutprogram.R

/**
 * https://www.raywenderlich.com/172711/intermediate-recyclerview
 *
 * @author Polurival on 01.04.2018.
 */
class ScheduleAdapter(private var scheduleList: ArrayList<ScheduleRow>) : RecyclerView.Adapter<DefaultViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DefaultViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val inflatedView: View = when (viewType) {
            RowType.HEADER.ordinal -> layoutInflater.inflate(R.layout.schedule_header_item, parent, false)
            RowType.ROW.ordinal -> layoutInflater.inflate(R.layout.schedule_row_item, parent, false) as ViewGroup
            else -> throw IllegalArgumentException("Wrong type of ViewHolder")
        }
        inflatedView.layoutParams
        return DefaultViewHolder(inflatedView)
    }

    override fun getItemCount(): Int {
        return scheduleList.size
    }

    override fun onBindViewHolder(holder: DefaultViewHolder, position: Int) {
        val scheduleRow = scheduleList[position]
        val workOutModel = scheduleRow.schedule

        if (scheduleRow.type == RowType.HEADER) {
            workOutModel.workoutName?.let { holder.setText(R.id.workout_name_text_view, it) }
        } else if (scheduleRow.type == RowType.ROW) {
            workOutModel.weekNumber?.let { holder.setText(R.id.week_text_view, it) }
            workOutModel.weight?.let { holder.setText(R.id.weight_text_view, it) }
            workOutModel.repetitionsNumber?.let { holder.setText(R.id.repetitions_number_text_view, it) }
            workOutModel.approachesNumber?.let { holder.setText(R.id.approaches_number_text_view, it) }
        }
    }

    override fun getItemViewType(position: Int): Int {
        return scheduleList[position].type.ordinal
    }

    fun updateSchedule(newScheduleList: ArrayList<ScheduleRow>) {
        DiffUtil.calculateDiff(ScheduleRowDiffCallback(scheduleList, newScheduleList), false)
                .dispatchUpdatesTo(this)
        scheduleList = newScheduleList
    }

    fun removeRow(row: Int) {
        scheduleList.removeAt(row)
        notifyItemRemoved(row)
    }
}

class ScheduleRowDiffCallback(private val oldRows: ArrayList<ScheduleRow>, private val newRows: ArrayList<ScheduleRow>)
    : DiffUtil.Callback() {

    override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        val oldRow = oldRows[oldItemPosition]
        val newRow = newRows[newItemPosition]
        return oldRow.type == newRow.type
    }

    override fun getOldListSize(): Int = oldRows.size

    override fun getNewListSize(): Int = newRows.size

    override fun areContentsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        val oldRow = oldRows[oldItemPosition]
        val newRow = newRows[newItemPosition]
        return oldRow == newRow
    }
}