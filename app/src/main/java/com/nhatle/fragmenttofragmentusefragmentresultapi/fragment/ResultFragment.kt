package com.nhatle.fragmenttofragmentusefragmentresultapi.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.nhatle.fragmenttofragmentusefragmentresultapi.R


/**
 * A simple [Fragment] subclass.
 * Use the [ResultFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class ResultFragment : Fragment() {
    private lateinit var tvResult: TextView
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_result, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        tvResult = view.findViewById(R.id.tv_result)
        parentFragmentManager.setFragmentResultListener(
            REQUEST_KEY,
            this
        ) { _, bundle ->
            val counterValue = bundle.getInt(COUNTER_KEY)
            // Update UI
            tvResult.text = counterValue.toString()
        }
    }
    companion object{
        const val REQUEST_KEY = "BUNDLE_COUNTER_KEY"
        const val COUNTER_KEY = "COUNTER_KEY"
    }
}