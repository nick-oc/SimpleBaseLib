package org.nick.sample

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.ViewDataBinding
import org.nick.master.library.adapter.CommonAdapter
import org.nick.sample.databinding.ISimpleBinding

abstract class SimpleAdapter<B : ViewDataBinding, D>(inflater: ((LayoutInflater, ViewGroup?, Boolean) -> B)? = null) :
    CommonAdapter<B, D>(inflater) {

    override fun variableId(): Int {
        return BR.item
    }
}

class SecondAdapter : SimpleAdapter<ISimpleBinding, String>()