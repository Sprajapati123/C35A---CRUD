package com.example.c35a_crud.ui.activity

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.c35a_crud.R
import com.example.c35a_crud.databinding.ActivityProductDashboardBinding
import com.example.c35a_crud.databinding.ActivityUpdateProductBinding
import com.example.c35a_crud.repository.ProductRepositoryImpl
import com.example.c35a_crud.viewmodel.ProductViewModel

class UpdateProductActivity : AppCompatActivity() {
    lateinit var binding: ActivityUpdateProductBinding

    lateinit var productViewModel: ProductViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        binding = ActivityUpdateProductBinding.inflate(layoutInflater)
        setContentView(binding.root)

        var repo = ProductRepositoryImpl()
        productViewModel = ProductViewModel(repo)


        var productId : String= intent.getStringExtra("productId")
                                                        .toString()


        productViewModel.getProductById(productId)

        productViewModel.products.observe(this){
            binding.updateProductName.setText(it?.productName.toString())
            binding.updateProductPrice.setText(it?.price.toString())
            binding.updateProductDesc.setText(it?.productDesc.toString())
        }

        binding.btnUpdate.setOnClickListener {
            var name = binding.updateProductName.text.toString()
            var price = binding.updateProductPrice.text.toString().toInt()
            var desc = binding.updateProductDesc.text.toString()

            var updatedMap = mutableMapOf<String,Any>()

            updatedMap["productName"] = name
            updatedMap["productDesc"] = desc
            updatedMap["price"] = price

            productViewModel.updateProduct(productId,updatedMap){
                success,message->
                if(success){
                    finish()
                }else{

                }
            }
        }


        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}