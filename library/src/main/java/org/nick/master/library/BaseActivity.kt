package org.nick.master.library

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.viewbinding.ViewBinding
import org.nick.master.library.utils.InjectUtil

open class BaseActivity<B : ViewBinding> : AppCompatActivity() {

    val binding: B by lazy {
        InjectUtil.injectBinding(javaClass.genericSuperclass!!, this)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        initData()
    }

    open fun initData() {}

}