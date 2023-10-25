package org.nick.master.library

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.viewbinding.ViewBinding
import org.nick.master.library.utils.InjectUtil

open class BaseFragment<T : ViewBinding>(
    private val inflaterT: ((LayoutInflater, ViewGroup?, Boolean) -> T)? = null
) : Fragment() {

    lateinit var binding: T

    override fun onAttach(context: Context) {
        super.onAttach(context)
        initArguments()
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = inflaterT?.invoke(inflater, container, false) ?: InjectUtil
            .injectBinding(javaClass.genericSuperclass!!, requireContext(), container, false)
        return binding.root
    }

    open fun initArguments() {}

}