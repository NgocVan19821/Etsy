package com.example.etsy.viewmodels

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class AttributeViewModel: ViewModel() {

    var color = MutableLiveData<Int>()
    var nameColor = MutableLiveData<String>()

    var size = MutableLiveData<String>()
    var price = MutableLiveData<Double>()

    var nameBank = MutableLiveData<String>()
    var imgBank = MutableLiveData<String>()


}