package org.nick.sample

import android.os.Bundle
import android.view.View
import org.nick.master.library.BaseFragment
import org.nick.sample.databinding.FragmentSimpleBinding

class SimpleFragment : BaseFragment<FragmentSimpleBinding>() {
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        binding.bt1.setOnClickListener {
            SimpleDialog(requireContext()).show()
        }
        binding.bt2.setOnClickListener {
            SimpleFragmentDialog().show(requireActivity(), "测试")
        }
    }
}