package com.marlonhndz.presentation.ui.customViews

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.widget.LinearLayout
import androidx.core.content.withStyledAttributes
import androidx.databinding.DataBindingUtil
import com.marlonhndz.presentation.R
import com.marlonhndz.presentation.databinding.AddOrRemoveUnitViewBinding

class AddOrRemoveUnitView @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet,
    defStyleAttr: Int = 0
) : LinearLayout(context, attrs, defStyleAttr) {

    private var binding: AddOrRemoveUnitViewBinding
    private var quantityTextSize = 15F
    private var quantity = 0

    init {
        val inflater = context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
        binding = DataBindingUtil.inflate(inflater, R.layout.add_or_remove_unit_view, this, true)

        setUpView()
        setUpAttrs(attrs)
    }

    private fun setUpView() {
        with(binding) {
            quantity = tvQuantityOfProducts.text.toString().toInt()

            btnPlus.setOnClickListener {
                quantity++
                tvQuantityOfProducts.text = quantity.toString()
            }

            btnMinus.setOnClickListener {
                quantity--
                if (quantity < 1) quantity = 1
                tvQuantityOfProducts.text = quantity.toString()
            }
        }
    }

    private fun setUpAttrs(attrs: AttributeSet) {
        context.withStyledAttributes(attrs, R.styleable.AddOrRemoveUnitView) {
            quantityTextSize =
                getString(R.styleable.AddOrRemoveUnitView_text_size)?.toFloat() ?: 15F
        }
        binding.tvQuantityOfProducts.textSize = quantityTextSize
    }

    fun getQuantity() = quantity

    fun setQuantity(productQuantity: Int) {
        quantity = productQuantity
        binding.tvQuantityOfProducts.text = quantity.toString()
    }
}
