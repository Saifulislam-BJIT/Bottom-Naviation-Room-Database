package com.saiful.roomdatabaseproject.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.saiful.roomdatabaseproject.R
import com.saiful.roomdatabaseproject.ui.model.Product
import com.saiful.roomdatabaseproject.viewmodel.ProductViewModel
import kotlinx.android.synthetic.main.product_list.view.*

class ProductAdapter(private val context: Context, private val viewModel: ProductViewModel) :
    RecyclerView.Adapter<ProductAdapter.ProductViewHolder>() {
    private var productList = emptyList<Product>()

    class ProductViewHolder(binding: View) : RecyclerView.ViewHolder(binding) {

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductViewHolder {
        return ProductViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.product_list,parent,false)
        )
    }

    override fun onBindViewHolder(holder: ProductViewHolder, position: Int) {
        val currentProduct = productList[position]
        holder.itemView.product_item_name.text = currentProduct.name.toString()
        holder.itemView.product_item_price.text = "Price: ${currentProduct.price.toString()}"
        holder.itemView.product_item_Quantity.text = "Quantity: ${currentProduct.quantity.toString()}"
    }

    override fun getItemCount(): Int {
        return productList.size
    }

    fun setProduct(product: List<Product>) {
        this.productList = product
        notifyDataSetChanged()
    }
}