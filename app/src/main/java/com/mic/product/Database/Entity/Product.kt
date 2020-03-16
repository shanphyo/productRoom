package com.mic.product.Database.Entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
class Product{
    @PrimaryKey(autoGenerate = true)
    var pid:Int = 0

    @ColumnInfo(name = "pname")
    var pname:String=" "

    @ColumnInfo(name="pprice")
    var pprice:Double=0.0

    @ColumnInfo(name="pquantity")
    var pquantity:String=" "


}