package com.github.polurival.workoutprogram.ui.fragment


import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.github.polurival.workoutprogram.R
import com.github.polurival.workoutprogram.replaceFragment
import com.github.polurival.workoutprogram.ui.filter.WeightInputFilter
import kotlinx.android.synthetic.main.fragment_current_working_weight.*


const val WORKOUT_TYPE = "workout_name"

/**
 * A simple [Fragment] subclass.
 *
 */
class CurrentWorkingWeightFragment : Fragment() {

    companion object {
        fun newInstance(workoutName: String): CurrentWorkingWeightFragment {
            val fragment = CurrentWorkingWeightFragment()
            val args = Bundle()
            args.putString(WORKOUT_TYPE, workoutName)
            fragment.arguments = args
            return fragment
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_current_working_weight, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        val workoutType = arguments?.getString(WORKOUT_TYPE)

        enter_weight_edit_text.filters = arrayOf(WeightInputFilter())
        workout_type_text_view.text = workoutType

        make_program_button.setOnClickListener({
            val enteredWeight = enter_weight_edit_text.text.toString()
            activity?.replaceFragment(R.id.root_container, WorkoutProgramFragment.newInstance(workoutType!!, enteredWeight))
        })
    }
}
