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
import com.saiful.roomdatabaseproject.adapter.CategoryAdapter
import com.saiful.roomdatabaseproject.viewmodel.ProductViewModel
import kotlinx.android.synthetic.main.fragment_category_list.*


class CategoryListFragment : Fragment() {
private lateinit var viewModel: ProductViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_category_list, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel = ViewModelProvider(this)[ProductViewModel::class.java]
        val adapter = CategoryAdapter(requireContext(), viewModel)
        category_list_recyclerview.adapter = adapter
        category_list_recyclerview.layoutManager = LinearLayoutManager(requireContext())
        viewModel.readAllCategory.observe(viewLifecycleOwner, Observer { adapter.setCategory(it) })

        fab_add_category.setOnClickListener {
            findNavController().navigate(R.id.action_categoryListFragment_to_addCategoryFragment)
        }
    }

}