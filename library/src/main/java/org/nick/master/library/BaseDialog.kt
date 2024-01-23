package org.nick.master.library

import android.app.Dialog
import android.content.Context
import android.os.Bundle
import android.view.Gravity
import android.view.LayoutInflater
import android.widget.LinearLayout
import androidx.annotation.StyleRes
import androidx.viewbinding.ViewBinding
import org.nick.master.library.utils.InjectUtil

abstract class BaseDialog<B : ViewBinding>(
    context: Context,
    @StyleRes style: Int = R.style.CustomDialog,
    inflater: ((LayoutInflater) -> B)? = null
) : Dialog(context, style) {

    protected val binding: B by lazy {
        inflater?.invoke(layoutInflater) ?: try {
            InjectUtil.injectBinding(javaClass.genericSuperclass!!, context)
        } catch (e: Exception) {
            InjectUtil.injectBinding(javaClass.superclass.genericSuperclass!!, context)
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        initView()
    }

    protected open fun initView() {
        resetWindowGravity()
    }

    /**
     * 显示位置和尺寸,默认全屏，需要请自设
     */
    protected fun resetWindowGravity(
        gravity: Int = Gravity.CENTER,
        w: Int = LinearLayout.LayoutParams.WRAP_CONTENT,
        h: Int = LinearLayout.LayoutParams.WRAP_CONTENT,
    ) {
//        // DialogFragment 需要占满宽高时需要设置
//        window?.decorView?.apply {
//            setPadding(0, 0, 0, 0)
//            setBackgroundColor(Color.GRAY)
//        }
        window?.apply {
            setGravity(gravity)
            // 将dialog设为宽度匹配父容器
            attributes.width = w
            attributes.height = h
        }
    }
}