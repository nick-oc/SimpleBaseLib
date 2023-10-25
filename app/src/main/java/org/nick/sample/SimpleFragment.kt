package org.nick.sample

import android.os.Bundle
import android.view.View
import org.nick.master.library.BaseFragment
import org.nick.sample.databinding.FragmentSimpleBinding

class SimpleFragment : BaseFragment<FragmentSimpleBinding>() {
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        val text = binding.tv.text
        binding.tv.text = "$text test2"

        binding.tv.setOnClickListener {
            SimpleDialog(requireContext()).show()
        }
    }
}