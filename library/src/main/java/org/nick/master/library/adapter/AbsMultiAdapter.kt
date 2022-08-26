package org.nick.master.library.adapter

import androidx.databinding.ViewDataBinding
import androidx.recyclerview.widget.RecyclerView
import androidx.viewbinding.ViewBinding

abstract class AbsMultiAdapter<D> : RecyclerView.Adapter<VHolder<*>>() {

    protected val data = arrayListOf<D>()
    var onItemClickListener: ((D, Int) -> Unit)? = null
    protected lateinit var mRecyclerView: RecyclerView

    override fun onAttachedToRecyclerView(recyclerView: RecyclerView) {
        super.onAttachedToRecyclerView(recyclerView)
        mRecyclerView = recyclerView
    }

    override fun onBindViewHolder(holder: VHolder<*>, position: Int) {
        val item = getItemData(position)
        holder.b.let { binding ->
            if (binding is ViewDataBinding) {
                binding.root.setOnClickListener {
                    onItemClickListener?.invoke(item, position)
                }
                binding.setVariable(variableId(), item)
                binding.executePendingBindings()
                convert(holder, item, position)
            }
        }
    }

    abstract fun convert(h: VHolder<*>, item: D, position: Int)

    /**
     * 绑定id
     */
    abstract fun variableId(): Int

    override fun getItemCount(): Int {
        return data.size
    }

    /**
     * 上拉加载更多的数据
     *
     * @param list
     */
    open fun addLoadMoreData(list: List<D>) {
        val size = data.size
        data.addAll(list)
        notifyItemInserted(size)
    }

    open fun addLoadMoreData(list: D) {
        val size = data.size
        data.add(list)
        notifyItemInserted(size)
    }

    /**
     * 下拉刷新，得到的新数据插入到原数据头部
     *
     * @param data
     */
    open fun addRefreshData(list: List<D>) {
        data.addAll(0, list)
        notifyItemRangeInserted(0, list.size)
        mRecyclerView.scrollToPosition(0)
    }

    open fun addRefreshData(list: D) {
        data.add(0, list)
        notifyItemInserted(0)

        mRecyclerView.scrollToPosition(0)
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

class VHolder<B : ViewBinding>(val b: B) : RecyclerView.ViewHolder(b.root)