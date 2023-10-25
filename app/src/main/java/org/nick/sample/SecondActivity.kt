package org.nick.sample

import org.nick.master.library.BaseActivity
import org.nick.sample.databinding.ASecondBinding

class SecondActivity : BaseActivity<ASecondBinding>() {

    private val adapter = SecondAdapter()

    private fun list() = listOf("张三", "里斯1", "里斯2", "里斯3", "里斯4", "里斯5", "里斯6", "里斯7", "里斯8")
    override fun initData() {
        binding.rv.let {
            it.adapter = adapter
            adapter.setNewData(list())
        }
    }
}