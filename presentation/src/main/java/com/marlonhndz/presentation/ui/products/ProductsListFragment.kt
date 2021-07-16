package com.marlonhndz.presentation.ui.products

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.marlonhndz.domain.models.Product
import com.marlonhndz.presentation.databinding.ProductsListFragmentBinding
import org.koin.android.ext.android.inject
import org.koin.androidx.viewmodel.ext.android.viewModel

class ProductsListFragment : Fragment() {

    private lateinit var binding: ProductsListFragmentBinding

    private val productViewModel: ProductViewModel by viewModel()
    private val productAdapter: ProductAdapter by inject()

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

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setUpObservers()
        setUpListenersFromView()
        setUpProductsRecyclerView()
        loadData()
    }

    private fun setUpObservers() {
        productViewModel.products.observe(viewLifecycleOwner) { products ->
            binding.refreshProducts.isRefreshing = false
            productAdapter.replaceItems(products)
        }
    }

    private fun setUpListenersFromView() {
        binding.refreshProducts.setOnRefreshListener {
            productViewModel.fetchProducts()
        }
    }

    private fun setUpProductsRecyclerView() {
        val linearLayoutManager = LinearLayoutManager(this.context)
        binding.rvProductsList.apply {
            layoutManager = linearLayoutManager
            adapter = productAdapter
        }
        productAdapter.addListener(object : ProductAdapter.Listener {
            override fun itemClicked(product: Product) {
                findNavController().navigate(
                    ProductsListFragmentDirections.actionHomeListToHomeDetails(product)
                )
            }
        })
    }

    private fun loadData() {
        productViewModel.fetchProducts()
    }
}
