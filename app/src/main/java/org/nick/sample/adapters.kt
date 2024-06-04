package org.nick.sample

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.ViewDataBinding
import androidx.viewbinding.ViewBinding
import org.nick.master.library.adapter.AbsMultiAdapter
import org.nick.master.library.adapter.CommonAdapter
import org.nick.master.library.adapter.VHolder
import org.nick.sample.databinding.ISimpleBinding

abstract class SimpleAdapter<B : ViewDataBinding, D>(inflater: ((LayoutInflater, ViewGroup?, Boolean) -> B)? = null) :
    CommonAdapter<B, D>(inflater) {

    override fun variableId(): Int {
        return BR.item
    }
}

class SecondAdapter : SimpleAdapter<ISimpleBinding, String>()

class MultiHolder(binding: ViewBinding) : VHolder(binding) {
    fun bindData(item: Int) {

    }
}

class MultiAdapter() : AbsMultiAdapter<Int, MultiHolder>() {

    override fun convert(h: MultiHolder, item: Int, position: Int) {
        h.bindData(item)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MultiHolder {
        val binding = ISimpleBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return MultiHolder(binding)
    }
}