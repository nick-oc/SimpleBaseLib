package org.nick.sample

import android.content.Context
import android.content.Intent
import androidx.fragment.app.Fragment
import org.nick.master.library.BaseActivity
import org.nick.sample.databinding.ACommonBinding

class CommonActivity : BaseActivity<ACommonBinding>() {

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

    private fun getFragment(tag: String): Fragment? {
        if (tag == SimpleFragment.TAG) {
            return SimpleFragment()
        }
        return null
    }

    companion object {
        private const val ARG = "tag"
        fun build(context: Context, tag: String): Intent {
            return Intent(context, CommonActivity::class.java).putExtra(ARG, tag)
        }
    }
}