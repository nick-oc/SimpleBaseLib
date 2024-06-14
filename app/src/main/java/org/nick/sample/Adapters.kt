package org.nick.sample

import android.graphics.Color
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.ViewDataBinding
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ItemDecoration
import androidx.viewbinding.ViewBinding
import org.nick.master.library.adapter.AbsMultiAdapter
import org.nick.master.library.adapter.CommonAdapter
import org.nick.master.library.adapter.GridDivider
import org.nick.master.library.adapter.VHolder
import org.nick.sample.databinding.ISimpleHBinding
import org.nick.sample.databinding.ISimpleVBinding

abstract class SimpleAdapter<B : ViewDataBinding, D>(inflater: ((LayoutInflater, ViewGroup?, Boolean) -> B)? = null) :
    CommonAdapter<B, D>(inflater) {

    override fun variableId(): Int {
        return BR.item
    }
}

class SecondVAdapter : SimpleAdapter<ISimpleVBinding, SimpleData>() {

    private fun generateItemAdapter(list: List<SimpleData>) {
        list.forEach {
            it.tag = SecondHAdapter().apply { setNewData(it.contents) }
        }
    }

    override fun setNewData(list: List<SimpleData>?) {
        list?.let { generateItemAdapter(it) }
        super.setNewData(list)
    }

    override fun addData(list: List<SimpleData>, index: Int) {
        generateItemAdapter(list)
        super.addData(list, index)
    }

    override fun convertSimple(b: ISimpleVBinding, item: SimpleData, position: Int) {
        b.rv.let { rv ->
            rv.adapter = item.tag as SecondHAdapter

            (rv.layoutManager as GridLayoutManager).let { lm ->
                lm.spanCount = if (item.type == 0) 3 else 1

                if (rv.itemDecorationCount == 0) rv.addItemDecoration(GridDivider(spaceColor = Color.YELLOW))
            }
        }
    }

}

class SecondHAdapter : SimpleAdapter<ISimpleHBinding, String>()
