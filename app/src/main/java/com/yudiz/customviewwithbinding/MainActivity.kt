package com.yudiz.customviewwithbinding

import android.os.Bundle
import android.util.Log
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.lifecycleScope
import com.yudiz.customviewwithbinding.databinding.MainActivityBinding
import com.yudiz.customviewwithbinding.viewmodel.MainViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.collect

class MainActivity : AppCompatActivity() {

    private val vm: MainViewModel by viewModels()
    private lateinit var binding: MainActivityBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = DataBindingUtil.setContentView<MainActivityBinding>(this, R.layout.activity_main)
            .apply {
                lifecycleOwner = this@MainActivity
                vm = this@MainActivity.vm
            }

        lifecycleScope.launchWhenCreated {
            vm.stateFlow.collect {
                Log.e("MAIN ACT FLOW", "onCreate: $it")
            }
        }
    }
}