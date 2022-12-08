package org.nick.master.library

import android.app.Dialog
import android.content.Context
import android.os.Bundle
import android.view.Gravity
import android.widget.LinearLayout
import androidx.viewbinding.ViewBinding
import org.nick.master.library.utils.InjectUtil

abstract class BaseDialog<B : ViewBinding>(context: Context) : Dialog(context) {

    protected val binding: B by lazy {
        InjectUtil.injectBinding(javaClass.genericSuperclass!!, context)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        resetWindowGravity()
        initView()
    }

    abstract fun initView()

    /**
     * window 显示位置
     */
    protected fun resetWindowGravity() {
        window?.apply {
            setGravity(Gravity.CENTER)
            // 将dialog设为宽度匹配父容器
            attributes.height = LinearLayout.LayoutParams.MATCH_PARENT
            attributes.width = LinearLayout.LayoutParams.MATCH_PARENT
        }
    }

}