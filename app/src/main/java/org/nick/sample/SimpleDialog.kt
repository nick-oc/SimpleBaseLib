package org.nick.sample

import android.content.Context
import android.view.ViewGroup.LayoutParams
import org.nick.master.library.BaseDialog
import org.nick.sample.databinding.DialogSimpleBinding

class SimpleDialog(context: Context) : BaseDialog<DialogSimpleBinding>(context) {

    override fun initView() {
        resetWindowGravity(w = LayoutParams.MATCH_PARENT)

        setCancelable(false)
        setCanceledOnTouchOutside(false)
        binding.switchM.isChecked = false
        binding.switchM.setOnCheckedChangeListener { _, isChecked ->
            setCancelable(isChecked)
            setCanceledOnTouchOutside(isChecked)
        }
    }

}