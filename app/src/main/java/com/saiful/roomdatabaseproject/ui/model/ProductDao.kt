package com.saiful.roomdatabaseproject.ui.model

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface ProductDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun addProduct(product: Product)

    @Query("SELECT * FROM product_table ORDER BY id DESC")
    fun readAllProduct(): LiveData<List<Product>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun addCategory(category: Category)

    @Query("SELECT * FROM category_table ORDER BY id DESC")
    fun readAllCategory(): LiveData<List<Category>>
}