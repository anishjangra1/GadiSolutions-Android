package com.digi.gadisolutions.ui.emi

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class CalculateEmiViewModel : ViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = "This is Calculate Emi Fragment"
    }
    val text: LiveData<String> = _text
}