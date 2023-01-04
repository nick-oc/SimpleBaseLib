package org.nick.master.library

import android.os.Bundle
import android.view.LayoutInflater
import androidx.appcompat.app.AppCompatActivity
import androidx.viewbinding.ViewBinding
import org.nick.master.library.utils.InjectUtil

open class BaseActivity<B : ViewBinding>(inflater: ((LayoutInflater) -> B)? = null) : AppCompatActivity() {

    val binding: B by lazy {
        inflater?.invoke(layoutInflater) ?: try {
            InjectUtil.injectBinding(javaClass.genericSuperclass!!, this)
        } catch (e: Exception) {
            InjectUtil.injectBinding(javaClass.superclass.genericSuperclass!!, this)
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        initData()
    }

    open fun initData() {}

}