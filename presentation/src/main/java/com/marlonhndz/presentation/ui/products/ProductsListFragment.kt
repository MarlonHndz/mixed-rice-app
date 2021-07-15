package com.marlonhndz.presentation.ui.products

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.marlonhndz.presentation.databinding.ProductsListFragmentBinding


class ProductsListFragment : Fragment() {

    private lateinit var binding: ProductsListFragmentBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = ProductsListFragmentBinding.inflate(inflater, container, false)
            .apply {
                lifecycleOwner = viewLifecycleOwner
            }
        return binding.root
    }
}
