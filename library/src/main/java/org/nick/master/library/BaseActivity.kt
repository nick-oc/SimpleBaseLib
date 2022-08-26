package org.nick.master.library

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.viewbinding.ViewBinding

open class BaseActivity<B : ViewBinding> : AppCompatActivity() {

    val binding: B by lazy {
        InjectUtil.injectBinding(this)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        initData()
    }

    open fun initData() {}

}