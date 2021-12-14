package com.marlonhndz.presentation.ui.products

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.marlonhndz.domain.models.Product
import com.marlonhndz.presentation.R
import com.marlonhndz.presentation.databinding.ProductsListFragmentBinding
import kotlinx.android.synthetic.main.home_toolbar.view.*
import org.koin.android.ext.android.inject
import org.koin.androidx.viewmodel.ext.android.viewModel

class ProductsListFragment : Fragment() {

    private lateinit var binding: ProductsListFragmentBinding

    private val productsViewModel: ProductsViewModel by viewModel()
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
        setUpViews()
        setUpListenersFromView()
        setUpProductsRecyclerView()
        loadData()
    }

    private fun setUpObservers() {
        productsViewModel.productsList.observe(viewLifecycleOwner) { products ->
            binding.refreshProducts.isRefreshing = false
            productAdapter.replaceItems(products)
        }
    }

    private fun setUpViews() {
        with(binding.homeToolbar.main_toolbar) {
            inflateMenu(R.menu.home_menu)
            setOnMenuItemClickListener {
                when (it.itemId) {
                    R.id.menu_cart_fragment -> findNavController().navigate(
                        ProductsListFragmentDirections.actionHomeListToHomeShoppingCart()
                    )
                }
                true
            }
        }
    }

    private fun setUpListenersFromView() {
        binding.refreshProducts.setOnRefreshListener {
            productsViewModel.fetchProducts()
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
        productsViewModel.fetchProducts()
    }
}
