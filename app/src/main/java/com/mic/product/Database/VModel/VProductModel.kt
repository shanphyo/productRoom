package com.mic.product.Database.VModel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import com.mic.product.Database.Entity.Product
import com.mic.product.Database.MainDatabase.ProductDatabase

import com.mic.product.Database.Respository.productResposity
import kotlinx.coroutines.launch

class VProductModel(application: Application):AndroidViewModel(application){
    private  val res:productResposity
    val plist:LiveData<List<Product>>
    init {
        val db= ProductDatabase.getDataBase(application).pDao()
        res=productResposity(db)
        plist=res.productlist
    }

    fun save(product:Product)=viewModelScope.launch {
        res.save(product)
    }
}