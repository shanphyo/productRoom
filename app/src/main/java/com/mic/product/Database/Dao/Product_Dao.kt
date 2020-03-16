package com.mic.product.Database.Dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.mic.product.Database.Entity.Product

@Dao
interface ProductDao {
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun  saveProduct(p:Product)

    @Query("select * from Product")
    fun productList() : LiveData<List<Product>>



}