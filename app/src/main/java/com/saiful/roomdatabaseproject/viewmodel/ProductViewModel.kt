package com.saiful.roomdatabaseproject.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import com.saiful.roomdatabaseproject.repository.ProductRepository
import com.saiful.roomdatabaseproject.ui.model.Category
import com.saiful.roomdatabaseproject.ui.model.Product
import com.saiful.roomdatabaseproject.ui.model.ProductDatabase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class ProductViewModel(application: Application) : AndroidViewModel(application) {
    val readAllProduct: LiveData<List<Product>>
    val readAllCategory: LiveData<List<Category>>
    private val repository: ProductRepository

    init {
        val productDao = ProductDatabase.getDatabase(application).getProductDao()
        repository = ProductRepository(productDao)
        readAllProduct = repository.readAllProduct
        readAllCategory = repository.readAllCategory
    }

    fun addProduct(product: Product) {
        viewModelScope.launch(Dispatchers.IO) {
            repository.addProduct(product)
        }
    }

    fun addCategory(category: Category) {
        viewModelScope.launch(Dispatchers.IO) {
            repository.addCategory(category)
        }
    }
}