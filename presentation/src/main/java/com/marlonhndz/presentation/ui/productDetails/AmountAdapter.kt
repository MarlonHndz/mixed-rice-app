package com.marlonhndz.presentation.ui.productDetails

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.marlonhndz.domain.models.Amount
import com.marlonhndz.presentation.databinding.AmountItemBinding

class AmountAdapter : RecyclerView.Adapter<AmountAdapter.ViewHolder>() {

    private var items = mutableListOf<Amount>()
    private var listener: AmountAdapter.Listener? = null

    inner class ViewHolder(private val binding: AmountItemBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(amount: Amount) {
            with(binding) {
                txtAmountPrice.text = amount.price.toString()
                txtAmountWeight.text = amount.weight
                txtAmountServings.text = amount.servings

                // SetUp Listener
                amountItem.setOnClickListener {
                    listener?.itemClicked(amount)
                }
            }
        }
    }

    interface Listener {
        fun itemClicked(amount: Amount)
    }

    fun addListener(listener: Listener) {
        this.listener = listener
    }

    fun replaceItems(listAmounts: List<Amount>) {
        items.clear()
        items.addAll(listAmounts)
        notifyDataSetChanged()
    }

    fun removeAllItems() {
        items.clear()
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AmountAdapter.ViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding = AmountItemBinding.inflate(layoutInflater, parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: AmountAdapter.ViewHolder, position: Int) =
        holder.bind(items[position])

    override fun getItemCount() = items.size
}
