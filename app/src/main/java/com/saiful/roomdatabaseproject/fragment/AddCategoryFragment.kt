package com.saiful.roomdatabaseproject.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.saiful.roomdatabaseproject.R
import com.saiful.roomdatabaseproject.ui.model.Category
import com.saiful.roomdatabaseproject.viewmodel.ProductViewModel
import kotlinx.android.synthetic.main.fragment_add_category.*


class AddCategoryFragment : Fragment() {
    private lateinit var productViewModel: ProductViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_add_category, container, false)
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        productViewModel = ViewModelProvider(this)[ProductViewModel::class.java]
        add_category.setOnClickListener { addCategoryIntoDatabase() }

        add_category_et.setOnFocusChangeListener { view, _ -> layout_category_name.error = null }
    }

    private fun addCategoryIntoDatabase() {
        val categoryName = add_category_et.text.toString()
        if(categoryName.isNotEmpty()) {
            val category = Category(0, categoryName)
            productViewModel.addCategory(category)
            findNavController().navigate(R.id.action_addCategoryFragment_to_categoryListFragment)
        }

        layout_category_name.error = getString(R.string.error_msg)
    }
}