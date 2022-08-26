package org.nick.master.library.adapter

import android.view.ViewGroup
import androidx.databinding.ViewDataBinding
import org.nick.master.library.InjectUtil

abstract class CommonAdapter<B : ViewDataBinding, D> : AbsMultiAdapter<D>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VHolder<B> {
        val layout: B = InjectUtil.injectBinding(parent.context, parent, false)
        return VHolder(layout)
    }

    override fun convert(h: VHolder<*>, item: D, position: Int) {
        convertSimple(h as VHolder<B>, item, position)
    }

    open fun convertSimple(h: VHolder<B>, item: D, position: Int) {}

    override fun getItemCount(): Int {
        return data.size
    }

}