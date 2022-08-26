package org.nick.master.library

import android.content.Context
import android.content.Intent
import androidx.fragment.app.Fragment
import org.nick.master.library.databinding.ACommonBinding

abstract class AbsCommonActivity : BaseActivity<ACommonBinding>() {

    companion object {
        private const val ARG = "tag"

        fun build(context: Context, tag: String): Intent {
            return Intent(context, AbsCommonActivity::class.java).putExtra(ARG, tag)
        }
    }

    private var fragment: Fragment? = null

    override fun initData() {
        val tag = intent.getStringExtra(ARG) ?: ""

        fragment = getFragment(tag)
        fragment?.let {
            supportFragmentManager.beginTransaction()
                .add(binding.fragmentContainerView.id, it)
                .commitAllowingStateLoss()
        }
    }

    abstract fun getFragment(tag: String): Fragment?

}