package com.saiful.roomdatabaseproject.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.saiful.roomdatabaseproject.R
import com.saiful.roomdatabaseproject.adapter.ProductAdapter
import com.saiful.roomdatabaseproject.viewmodel.ProductViewModel
import kotlinx.android.synthetic.main.fragment_products_list.*


class ProductsListFragment : Fragment() {

    private lateinit var productViewModel: ProductViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_products_list, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        productViewModel = ViewModelProvider(this)[ProductViewModel::class.java]
        val adapter = ProductAdapter(requireContext(), productViewModel)
        products_list_recyclerview.adapter = adapter
        products_list_recyclerview.layoutManager = LinearLayoutManager(requireContext())
        productViewModel.readAllProduct.observe(viewLifecycleOwner,
            Observer { adapter.setProduct(it) }
        )

        fab_add_product.setOnClickListener {
            findNavController().navigate(R.id.action_productsListFragment_to_addProductFragment)
        }
    }
}