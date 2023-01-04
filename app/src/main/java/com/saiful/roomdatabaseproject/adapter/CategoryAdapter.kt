package com.saiful.roomdatabaseproject.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.saiful.roomdatabaseproject.R
import com.saiful.roomdatabaseproject.ui.model.Category
import com.saiful.roomdatabaseproject.viewmodel.ProductViewModel
import kotlinx.android.synthetic.main.category_list.view.*

class CategoryAdapter(
    private val context: Context,
    private val viewModel: ProductViewModel
): RecyclerView.Adapter<CategoryAdapter.CategoryViewHolder>() {

    private var categoryList = emptyList<Category>()

    class CategoryViewHolder(binding: View): RecyclerView.ViewHolder(binding) {

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CategoryViewHolder {
        return CategoryViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.category_list, parent, false)
        )
    }

    override fun onBindViewHolder(holder: CategoryViewHolder, position: Int) {
        val currentCategory = categoryList[position]
        holder.itemView.category_item_name.text = currentCategory.name
    }

    override fun getItemCount(): Int {
        return categoryList.size
    }

    fun setCategory(categoryList: List<Category>) {
        this.categoryList = categoryList
        notifyDataSetChanged()
    }
}