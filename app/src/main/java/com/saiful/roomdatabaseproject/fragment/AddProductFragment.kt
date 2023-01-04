package com.saiful.roomdatabaseproject.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.saiful.roomdatabaseproject.R
import com.saiful.roomdatabaseproject.ui.model.Product
import com.saiful.roomdatabaseproject.viewmodel.ProductViewModel
import kotlinx.android.synthetic.main.fragment_add_product.*

class AddProductFragment : Fragment() {

    private lateinit var productViewModel: ProductViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_add_product, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        productViewModel = ViewModelProvider(this)[ProductViewModel::class.java]
        add_product.setOnClickListener { addProductIntoDatabase() }

        product_name_et.setOnFocusChangeListener { view, _ -> layout_product_name.error = null }
        product_price_et.setOnFocusChangeListener { view, _ -> layout_product_price.error = null }
        product_quantity_et.setOnFocusChangeListener { view, _ -> layout_product_quantity.error = null }
    }

    private fun addProductIntoDatabase() {
        val productName = product_name_et.text.toString()
        val productPrice = product_price_et.text.toString()
        val productQuantity = product_quantity_et.text.toString()

        if (productName.isNotEmpty() && productPrice.isNotEmpty() && productQuantity.isNotEmpty()) {
            val product = Product(0, productName, productPrice.toInt(), productQuantity.toInt())
            productViewModel.addProduct(product)

            findNavController().navigate(R.id.action_addProductFragment_to_productsListFragment)
        }
        if (productName.isEmpty()) layout_product_name.error = getString(R.string.error_msg)
        if (productPrice.isEmpty()) layout_product_price.error = getString(R.string.error_msg)
        if (productQuantity.isEmpty()) layout_product_quantity.error = getString(R.string.error_msg)
    }

}