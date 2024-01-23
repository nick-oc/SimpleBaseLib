package org.nick.sample

import android.view.Gravity
import android.view.Window
import androidx.fragment.app.FragmentActivity
import org.nick.master.library.BaseFragmentDialog
import org.nick.sample.databinding.DialogSimpleFBinding

class SimpleFragmentDialog : BaseFragmentDialog<DialogSimpleFBinding>(DialogSimpleFBinding::inflate) {

    override val isFullScreen: Boolean
        get() = true
    override fun initView() {
        isCancelable = false
        setCanceledOnTouchOutside(false)

        binding.bt.setOnClickListener { dismiss() }
        binding.switchM.isChecked = false
        binding.switchM.setOnCheckedChangeListener { _, isChecked ->
            isCancelable = isChecked
            setCanceledOnTouchOutside(isChecked)
        }
    }

    override fun resetWindow(window: Window) {
        window.apply {
            attributes.width = -1
            attributes.height = -2
            setGravity(Gravity.CENTER)
        }
    }

    fun show(activity: FragmentActivity, msg: String) {
        showNow(activity.supportFragmentManager, this::class.java.simpleName)
        binding.tv.text = msg
    }

}