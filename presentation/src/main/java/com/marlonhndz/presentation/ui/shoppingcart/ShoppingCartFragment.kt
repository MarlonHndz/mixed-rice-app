package com.marlonhndz.presentation.ui.shoppingcart

import android.content.ActivityNotFoundException
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.marlonhndz.domain.models.Order
import com.marlonhndz.presentation.databinding.ShoppingCartFragmentBinding
import org.koin.android.ext.android.inject
import org.koin.androidx.viewmodel.ext.android.viewModel

class ShoppingCartFragment : Fragment() {

    private lateinit var binding: ShoppingCartFragmentBinding

    private val shoppingCartViewModel: ShoppingCartViewModel by viewModel()
    private val shoppingCartAdapter: ShoppingCartAdapter by inject()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = ShoppingCartFragmentBinding.inflate(inflater, container, false)
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
        shoppingCartViewModel.ordersList.observe(viewLifecycleOwner) { orders ->
            shoppingCartAdapter.replaceItems(orders)
        }
    }

    private fun setUpListenersFromView() {
        binding.btnMakePurchase.setOnClickListener {
            shoppingCartViewModel.ordersList.value?.let {
                if (it.isEmpty()) {
                    Toast.makeText(context, "Pedí algún arroz pelotudo!!", Toast.LENGTH_SHORT)
                        .show()
                } else {
                    sendWhatsappMessage(it)
                }
            }
        }
    }

    private fun setUpProductsRecyclerView() {
        val linearLayoutManager = LinearLayoutManager(this.context)
        binding.rvProductsList.apply {
            layoutManager = linearLayoutManager
            adapter = shoppingCartAdapter
        }
        shoppingCartAdapter.addListener(object : ShoppingCartAdapter.Listener {
            override fun itemClicked(order: Order) {
                // TODO
            }
        })
    }

    private fun loadData() {
        shoppingCartViewModel.fetchOrders()
    }

    private fun sendWhatsappMessage(orderList: List<Order>) { // TODO: MOVE THIS TO A USECASE
        val whatsappNumber = "573103822897"
        val whatsappMessage =
            "Hola Soy *Takashi*, \n estoy ubicado en *PUEBLO PALETA* \n" +
                "y me gustaría solicitar los siguientes productos: \n" +
                "${
                orderList.map {
                    "\n" + it.product.name
                }
                }"

        val whatsappIntent = Intent(Intent.ACTION_SEND)
        whatsappIntent.setType("text/plain")
        whatsappIntent.setPackage("com.whatsapp")
        whatsappIntent.putExtra(Intent.EXTRA_TEXT, whatsappMessage)

        whatsappIntent.putExtra("jid", "$whatsappNumber@s.whatsapp.net")

        try {
            startActivity(whatsappIntent)
        } catch (error: ActivityNotFoundException) {
            error.printStackTrace()
            Toast.makeText(context, "NO TIENES WHATSAPP PUTO SUBNORMAL", Toast.LENGTH_SHORT).show()
        }
    }
}
