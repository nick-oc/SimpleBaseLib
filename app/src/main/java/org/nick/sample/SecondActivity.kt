package org.nick.sample

import org.nick.master.library.BaseActivity
import org.nick.sample.databinding.ASecondBinding

class SecondActivity : BaseActivity<ASecondBinding>(ASecondBinding::inflate) {

    private val adapter = SecondVAdapter()

    override fun initData() {
        binding.run {
            btAdd.setOnClickListener {
                adapter.addData(getList(2))
            }
            btAddEnd.setOnClickListener {
                adapter.addDataToEnd(getList())
            }
            rv.adapter = adapter

            adapter.setNewData(getList(2))
        }
    }

    private fun getList(size: Int = 1): List<SimpleData> {
        val list = arrayListOf<SimpleData>()
        val start = adapter.itemCount
        for (i in start until start + size) {
            val item = SimpleData(i, "编组 $i", i % 2)
            for (j in 0 until 13) {
                item.contents.add("子项 $j")
            }
            list.add(item)
        }
        return list
    }
}