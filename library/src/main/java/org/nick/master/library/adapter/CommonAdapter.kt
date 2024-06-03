package org.nick.master.library.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.ViewDataBinding
import org.nick.master.library.utils.InjectUtil

abstract class CommonAdapter<B : ViewDataBinding, D>(
    private val inflaterT: ((LayoutInflater, ViewGroup?, Boolean) -> B)? = null,
) : AbsMultiAdapter<D>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VHolder {
        val inflater = LayoutInflater.from(parent.context)
        val layout: B = inflaterT?.invoke(inflater, parent, false) ?: InjectUtil
            .injectBinding(javaClass.genericSuperclass!!, parent.context, parent, false)
        return VHolder(layout)
    }

    override fun convert(h: VHolder, item: D, position: Int) {
        convertSimple(h.b as B, item, position)
    }

    open fun convertSimple(b: B, item: D, position: Int) {}

}