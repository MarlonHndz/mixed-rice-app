package com.marlonhndz.presentation.ui.productDetails

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.navArgs
import androidx.recyclerview.widget.LinearLayoutManager
import com.marlonhndz.domain.models.Amount
import com.marlonhndz.presentation.R
import com.marlonhndz.presentation.databinding.ProductDetailsFragmentBinding
import com.squareup.picasso.Picasso
import org.koin.android.ext.android.inject

class ProductDetailsFragment : Fragment() {

    private lateinit var binding: ProductDetailsFragmentBinding
    private val args: ProductDetailsFragmentArgs by navArgs()

    private val amountAdapter: AmountAdapter by inject()

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

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setUpViews()
        setUpAmountsRecyclerView()
    }

    private fun setUpViews() {
        val product = args.myProduct
        binding.tvProductName.text = product.name
        binding.tvProductDescription.text = product.description

        // Image
        Picasso.get()
            .load(product.imageURL)
            .placeholder(R.drawable.product_placeholder)
            .into(binding.imvProductBanner)

        loadAmounts(product.amounts)
    }

    private fun setUpAmountsRecyclerView() {
        val linearLayoutManager = LinearLayoutManager(this.context)
        binding.amountList.rvAmountList.apply {
            layoutManager = linearLayoutManager
            adapter = amountAdapter
        }
        amountAdapter.addListener(object : AmountAdapter.Listener {
            override fun itemClicked(amount: Amount) {
                Toast.makeText(
                    this@ProductDetailsFragment.context,
                    "Item por ${amount.price} selected",
                    Toast.LENGTH_SHORT
                ).show()
            }
        })
    }

    private fun loadAmounts(amounts : List<Amount>) {
        amountAdapter.replaceItems(amounts)
    }
}
