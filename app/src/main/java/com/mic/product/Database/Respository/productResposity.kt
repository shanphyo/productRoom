package com.mic.product.Database.Respository

import androidx.lifecycle.LiveData
import com.mic.product.Database.Dao.ProductDao
import com.mic.product.Database.Entity.Product

class productResposity(private  val pDao:ProductDao){
    val productlist:LiveData<List<Product>> = pDao.productList()

    suspend fun save(product:Product){
        pDao.saveProduct(product)
    }

}