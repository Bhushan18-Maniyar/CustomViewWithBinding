package com.yudiz.customviewwithbinding.util

import android.content.Context
import android.content.res.TypedArray
import android.util.AttributeSet
import android.widget.EditText
import android.widget.ImageView
import android.widget.LinearLayout
import androidx.lifecycle.LifecycleObserver
import com.yudiz.customviewwithbinding.R

class CustomEditText @JvmOverloads constructor(
    context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0
) : LinearLayout(context, attrs, defStyleAttr), LifecycleObserver {

    lateinit var edt: EditText
    private lateinit var iv: ImageView
    private var typedArray: TypedArray? = null

    init {
        val v = inflate(context, R.layout.custom_view_layout, this)
        orientation = HORIZONTAL

        edt = v.findViewById(R.id.edt)
        iv = v.findViewById(R.id.iv)

        attrs?.let {
            typedArray = context.theme?.obtainStyledAttributes (
                attrs,
                R.styleable.CustomField,
                defStyleAttr,
                0
            )
        }

        iv.setImageDrawable(typedArray?.getDrawable(R.styleable.CustomField_startDrawable))
        edt.apply {
            hint = typedArray?.getString(R.styleable.CustomField_android_hint)
        }
    }
}