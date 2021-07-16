package com.marlonhndz.presentation.ui.products

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.marlonhndz.domain.models.Product
import com.marlonhndz.presentation.R
import com.marlonhndz.presentation.databinding.ProductItemBinding
import com.squareup.picasso.Picasso

class ProductAdapter : RecyclerView.Adapter<ProductAdapter.ViewHolder>() {

    private var items = mutableListOf<Product>()
    private var listener: Listener? = null

    inner class ViewHolder(private val binding: ProductItemBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(product: Product) {
            with(binding){
                txtProductName.text = product.name
                txtProductType.text = product.type.value
                txtProductDescription.text = product.description

                // Image
                Picasso.get()
                    .load(product.imageURL)
                    .placeholder(R.drawable.product_placeholder)
                    .into(imvProduct)

                // SetUp Listener
                productItem.setOnClickListener {
                    listener?.itemClicked(product)
                }
            }
        }
    }

    interface Listener {
        fun itemClicked(product: Product)
    }

    fun addListener(listener: Listener) {
        this.listener = listener
    }

    fun replaceItems(listProducts: List<Product>) {
        items.clear()
        items.addAll(listProducts)
        notifyDataSetChanged()
    }

    fun removeAllItems() {
        items.clear()
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding = ProductItemBinding.inflate(layoutInflater, parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) = holder.bind(items[position])

    override fun getItemCount() = items.size
}
