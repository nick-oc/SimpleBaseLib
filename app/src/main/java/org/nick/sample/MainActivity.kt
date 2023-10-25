package org.nick.sample

import android.content.Intent
import org.nick.master.library.BaseActivity
import org.nick.sample.databinding.ActivityMainBinding

class MainActivity : BaseActivity<ActivityMainBinding>(ActivityMainBinding::inflate) {

    private var count = 0

    override fun initData() {
        binding.btn.setOnClickListener {
            binding.btn.text = "测试${count++}"
        }
        binding.btn1.setOnClickListener {
            startActivity(Intent(this, SimpleActivity::class.java))
        }
        binding.btn2.setOnClickListener {
            startActivity(Intent(this, SecondActivity::class.java))
        }

        binding.btn3.setOnClickListener {
            startActivity(Intent(this, ThirdActivity::class.java))
        }
    }

}