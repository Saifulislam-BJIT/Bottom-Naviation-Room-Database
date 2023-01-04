package com.saiful.roomdatabaseproject.repository

import androidx.lifecycle.LiveData
import com.saiful.roomdatabaseproject.ui.model.Category
import com.saiful.roomdatabaseproject.ui.model.Product
import com.saiful.roomdatabaseproject.ui.model.ProductDao

class ProductRepository(private val productDao: ProductDao) {

    val readAllProduct: LiveData<List<Product>> = productDao.readAllProduct()
    val readAllCategory: LiveData<List<Category>> = productDao.readAllCategory()

    suspend fun addProduct(product: Product) {
        productDao.addProduct(product)
    }

    suspend fun addCategory(category: Category) {
        productDao.addCategory(category)
    }
}