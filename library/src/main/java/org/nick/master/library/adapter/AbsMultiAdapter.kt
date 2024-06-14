package org.nick.master.library.adapter

import androidx.databinding.ViewDataBinding
import androidx.recyclerview.widget.RecyclerView
import androidx.viewbinding.ViewBinding
import org.nick.master.library.BR

abstract class AbsMultiAdapter<D, H : VHolder> : RecyclerView.Adapter<H>() {

    protected val data = arrayListOf<D>()
    var onItemClickListener: ((D, Int) -> Unit)? = null
    protected lateinit var mRecyclerView: RecyclerView

    override fun onAttachedToRecyclerView(recyclerView: RecyclerView) {
        super.onAttachedToRecyclerView(recyclerView)
        mRecyclerView = recyclerView
    }

    override fun onBindViewHolder(holder: H, position: Int) {
        val item = getItemData(position)
        holder.b.let { binding ->
            binding.root.setOnClickListener {
                onItemClickListener?.invoke(item, position)
            }
            if (binding is ViewDataBinding) {
                val variableId = variableId()
                if (variableId == 0) throw IllegalArgumentException("使用 ViewDataBinding 时必须重写 variableId() 方法")
                binding.setVariable(variableId, item)
                binding.executePendingBindings()
            }
            convert(holder, item, position)
        }
    }

    abstract fun convert(h: H, item: D, position: Int)

    /**
     * 当使用ViewDataBinding时必须重写
     * 绑定id
     */
    open fun variableId(): Int {
        return BR._all
    }

    override fun getItemCount(): Int {
        return data.size
    }

    open fun addData(list: List<D>, index: Int = 0) {
        data.addAll(index, list)
        notifyItemRangeChanged(index, data.size)
    }

    open fun addDataToEnd(list: List<D>) {
        addData(list, data.size)
    }

    /**
     * 替换全部旧数据
     *
     * @param list
     */
    open fun setNewData(list: List<D>?) {
        data.clear()
        list?.let { data.addAll(it) }
        notifyDataSetChanged()
    }


    fun getItemData(position: Int): D {
        return data[position]
    }

    fun getData(): List<D> {
        return data
    }
}

open class VHolder(val b: ViewBinding) : RecyclerView.ViewHolder(b.root)