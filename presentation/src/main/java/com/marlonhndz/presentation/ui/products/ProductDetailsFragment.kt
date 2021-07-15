package com.marlonhndz.presentation.ui.products

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.marlonhndz.presentation.databinding.ProductDetailsFragmentBinding


class ProductDetailsFragment : Fragment() {

    private lateinit var binding: ProductDetailsFragmentBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = ProductDetailsFragmentBinding.inflate(inflater, container, false)
            .apply {
                lifecycleOwner = viewLifecycleOwner
            }
        return binding.root
    }
}