package org.nick.master.library

import android.os.Bundle
import android.view.LayoutInflater
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
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
        resetWindow()
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(binding.root) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        initData()
    }

    open fun resetWindow() {
        enableEdgeToEdge()
    }

    open fun initData() {}

}