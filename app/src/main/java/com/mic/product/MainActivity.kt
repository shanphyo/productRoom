package com.mic.product

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.room.Database
import com.mic.product.Adapter.ProductCustomAdapter
import com.mic.product.Database.Entity.Product
import com.mic.product.Database.VModel.VProductModel
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    private  lateinit var vm: VProductModel
    private var plist= emptyList<Product>()
    private var name=" "
    private var price=" "
    private var quantity=" "


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)



        vm=ViewModelProvider(this)
            .get(VProductModel::class.java)
        vm.plist.observe(this,
            Observer { words ->
                words?.let{
                    plist=it

                }
            })


        val pAdapter= ProductCustomAdapter(plist)
        rv.layoutManager= LinearLayoutManager(this)
        rv.adapter=pAdapter
        float_button.setOnClickListener {
                  val intent=Intent(this,procuct::class.java)
                  startActivity(intent)
        }
        var key=intent.getStringExtra("key")
        if(key.isNullOrEmpty()){

        }else {
            if (key.equals("product")) {
                name = intent.getStringExtra("name")
                price = intent.getStringExtra("price")
                quantity = intent.getStringExtra("quantity")
                val p = Product()
                p.pname = name
                p.pprice = price.toDouble()
                p.pquantity = quantity

                vm.save(p)
            }
        }

    }
}
