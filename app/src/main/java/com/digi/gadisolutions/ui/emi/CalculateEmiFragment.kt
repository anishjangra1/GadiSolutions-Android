package com.digi.gadisolutions.ui.emi

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.digi.gadisolutions.R

class CalculateEmiFragment : Fragment() {

    private lateinit var calculateEmiViewModel: CalculateEmiViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        calculateEmiViewModel =
            ViewModelProviders.of(this).get(CalculateEmiViewModel::class.java)
        val root = inflater.inflate(R.layout.fragment_calculate_emi, container, false)
        val textView: TextView = root.findViewById(R.id.text_emi)
        calculateEmiViewModel.text.observe(this, Observer {
            textView.text = it
        })
        return root
    }
}