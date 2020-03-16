package com.mic.product.Database.MainDatabase

import android.content.Context
import android.util.Log
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.mic.product.Database.Dao.ProductDao
import com.mic.product.Database.Entity.Product

@Database(entities = [(Product::class)],version = 1)
abstract class ProductDatabase:RoomDatabase(){
    abstract  fun pDao():ProductDao
    companion object{
        private  var INSTANCE : ProductDatabase? =null
        fun getDataBase(
            context: Context
        ): ProductDatabase{
            val tempInstance = INSTANCE
            if(tempInstance !=null){
                return tempInstance
            }
            synchronized(this){
                val instance= Room.databaseBuilder(
                    context,
                    ProductDatabase::class.java,
                    "Product_database"
                ).build()
                INSTANCE=instance
                Log.d("Instance ","${tempInstance}")
                return instance
            }
        }
    }

}