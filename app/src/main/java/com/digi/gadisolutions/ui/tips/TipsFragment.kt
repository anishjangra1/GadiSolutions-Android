package com.digi.gadisolutions.ui.tips

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.digi.gadisolutions.R

class TipsFragment : Fragment() {

    private lateinit var newsViewModel: TipsViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        newsViewModel =
            ViewModelProviders.of(this).get(TipsViewModel::class.java)
        val root = inflater.inflate(R.layout.fragment_tips, container, false)
        val textView: TextView = root.findViewById(R.id.text_tips)
        newsViewModel.text.observe(this, Observer {
            textView.text = it
        })
        return root
    }
}