package com.yudiz.customviewwithbinding

import android.text.Editable
import android.text.TextWatcher
import androidx.databinding.BindingAdapter
import androidx.databinding.InverseBindingAdapter
import androidx.databinding.InverseBindingListener
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.yudiz.customviewwithbinding.util.CustomEditText

object CustomEditTextBinding {

    @JvmStatic
    @BindingAdapter(value = ["editTextValueAttrChanged"])
    fun setListener(customField: CustomEditText, listener: InverseBindingListener?) {
        if (listener != null) {
            customField.edt.addTextChangedListener(object : TextWatcher {
                override fun beforeTextChanged(
                    charSequence: CharSequence,
                    i: Int,
                    i1: Int,
                    i2: Int
                ) {}

                override fun onTextChanged(charSequence: CharSequence, i: Int, i1: Int, i2: Int) {}
                override fun afterTextChanged(editable: Editable) {
                    listener.onChange()
                }
            })
        }
    }

    @JvmStatic
    @BindingAdapter("editTextValue")
    fun setRealValue(customField: CustomEditText, value: String) {
        if(customField.edt.text.toString() != value) {
            customField.edt.setText(value)
        }
    }

    @JvmStatic
    @InverseBindingAdapter(attribute = "editTextValue")
    fun getRealValue(customField: CustomEditText): String {
        return customField.edt.text.toString()
    }
}