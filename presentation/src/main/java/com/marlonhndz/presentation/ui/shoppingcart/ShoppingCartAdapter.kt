package com.marlonhndz.presentation.ui.shoppingcart

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.marlonhndz.domain.models.Order
import com.marlonhndz.presentation.R
import com.marlonhndz.presentation.databinding.ShoppingCartItemBinding
import com.squareup.picasso.Picasso

class ShoppingCartAdapter : RecyclerView.Adapter<ShoppingCartAdapter.ViewHolder>() {

    private var items = mutableListOf<Order>()
    private var listener: Listener? = null

    inner class ViewHolder(private val binding: ShoppingCartItemBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(order: Order) {
            with(binding) {
                txtProductName.text = order.product.name
                txtProductType.text = order.product.type.value
                txtProductDescription.text = order.product.description

                // Image
                Picasso.get()
                    .load(order.product.imageURL)
                    .placeholder(R.drawable.product_placeholder)
                    .into(imvProduct)

                // SetUp Listener
                rootShoppingCartItem.setOnClickListener {
                    listener?.itemClicked(order)
                }
            }
        }
    }

    interface Listener {
        fun itemClicked(order: Order)
    }

    fun addListener(listener: Listener) {
        this.listener = listener
    }

    fun replaceItems(ordersList: List<Order>) {
        items.clear()
        items.addAll(ordersList)
        notifyDataSetChanged()
    }

    fun removeAllItems() {
        items.clear()
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding = ShoppingCartItemBinding.inflate(layoutInflater, parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) = holder.bind(items[position])

    override fun getItemCount() = items.size
}
