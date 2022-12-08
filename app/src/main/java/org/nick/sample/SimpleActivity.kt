package org.nick.sample

import androidx.fragment.app.Fragment
import org.nick.master.library.AbsCommonActivity

class SimpleActivity : AbsCommonActivity() {

    override fun getFragment(tag: String): Fragment {
        return SimpleFragment()
    }

}