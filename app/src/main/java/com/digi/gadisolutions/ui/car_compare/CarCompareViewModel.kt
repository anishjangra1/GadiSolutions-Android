package com.digi.gadisolutions.ui.car_compare

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class CarCompareViewModel : ViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = "This is Car Compare Fragment"
    }
    val text: LiveData<String> = _text
}