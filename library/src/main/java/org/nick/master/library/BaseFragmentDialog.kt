package org.nick.master.library

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.Window
import androidx.fragment.app.DialogFragment
import androidx.viewbinding.ViewBinding
import org.nick.master.library.utils.InjectUtil

abstract class BaseFragmentDialog<B : ViewBinding>(
    private val inflaterT: ((LayoutInflater, ViewGroup?, Boolean) -> B)? = null
) : DialogFragment() {

    open val isFullScreen = false

    lateinit var binding: B

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        if (isFullScreen) {
            setStyle(STYLE_NORMAL, style())
        }
    }

    open fun style(): Int {
        return R.style.FullScreenDialog
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = inflaterT?.invoke(inflater, container, false) ?: InjectUtil
            .injectBinding(javaClass.genericSuperclass!!, requireContext(), container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        initView()
    }

    fun setCanceledOnTouchOutside(boolean: Boolean) {
        dialog?.setCanceledOnTouchOutside(boolean)
    }

    override fun onStart() {
        super.onStart()
        dialog?.window?.let(this::resetWindow)
    }

    /**
     *  设置window属性
     *  window.setBackgroundDrawable(ColorDrawable(Color.WHITE))
     *  val layoutParams = window .attributes
     *
     *  layoutParams.windowAnimations = R.style.CustomDialog         //动画
     *  layoutParams.gravity = Gravity.BOTTOM                       // 位置
     *  layoutParams.width = ViewGroup.LayoutParams.MATCH_PARENT    //宽度满屏
     *
     *  window.attributes = layoutParams
     */
    open fun resetWindow(window: Window) {}

    abstract fun initView()
}