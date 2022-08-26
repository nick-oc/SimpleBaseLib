package org.nick.sample

import org.nick.master.library.BaseActivity
import org.nick.sample.databinding.ActivityMainBinding

class MainActivity : BaseActivity<ActivityMainBinding>() {

    private var count = 0

    override fun initData() {
        binding.btn.setOnClickListener {
            binding.btn.text = "测试${count++}"
        }
    }

}