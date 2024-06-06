package org.nick.sample

import android.graphics.Color
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import org.nick.master.library.BaseActivity
import org.nick.master.library.adapter.GridDivider
import org.nick.master.library.utils.dp
import org.nick.sample.databinding.ASecondBinding

class SecondActivity : BaseActivity<ASecondBinding>(ASecondBinding::inflate) {

    private val adapter = SecondAdapter()

    private fun list() = listOf("张三", "里斯1", "里斯2", "里斯3", "里斯4", "里斯5", "里斯6", "里斯7", "里斯8")
    override fun initData() {
        binding.run {
            rv.addItemDecoration(GridDivider(12.dp, Color.BLUE))
            rv.adapter = adapter
            adapter.setNewData(list())

            bt.setOnClickListener {
                val count = etCount.text.toString().toInt()
                val orientation = if (swOrientation.isChecked) RecyclerView.HORIZONTAL else RecyclerView.VERTICAL
                val lm = if (swManager.isChecked) GridLayoutManager(this@SecondActivity, count)
                else LinearLayoutManager(this@SecondActivity)
                lm.orientation = orientation
                rv.layoutManager = lm
            }
        }
    }
}