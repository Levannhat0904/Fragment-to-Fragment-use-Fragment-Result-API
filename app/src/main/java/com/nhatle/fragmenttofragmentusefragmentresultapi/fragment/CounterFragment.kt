package com.nhatle.fragmenttofragmentusefragmentresultapi.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import com.nhatle.fragmenttofragmentusefragmentresultapi.R


/**
 * A simple [Fragment] subclass.
 * Use the [CounterFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class CounterFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_counter, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val button = view.findViewById<Button>(R.id.btn_click)
        button.setOnClickListener {
            button.isEnabled = false
            val bundle = Bundle().apply {
                putInt(ResultFragment.COUNTER_KEY, 1)
            }
            parentFragmentManager.setFragmentResult(ResultFragment.REQUEST_KEY, bundle)
        }
    }
}