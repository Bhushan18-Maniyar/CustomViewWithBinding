package com.yudiz.customviewwithbinding.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

class MainViewModel : ViewModel() {

    val _liveData: MutableLiveData<String> = MutableLiveData("")
    val liveData: LiveData<String> = _liveData

    val _stateFlow : MutableStateFlow<String> = MutableStateFlow("")
    val stateFlow: StateFlow<String> = _stateFlow

}