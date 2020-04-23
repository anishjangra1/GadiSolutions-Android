package com.digi.gadisolutions.ui.car_compare

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.digi.gadisolutions.R

class CarCompareFragment : Fragment() {

    private lateinit var carCompareViewModel: CarCompareViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        carCompareViewModel =
            ViewModelProviders.of(this).get(CarCompareViewModel::class.java)
        val root = inflater.inflate(R.layout.fragment_compare, container, false)
        val textView: TextView = root.findViewById(R.id.text_compare)
        carCompareViewModel.text.observe(this, Observer {
            textView.text = it
        })
        return root
    }
}