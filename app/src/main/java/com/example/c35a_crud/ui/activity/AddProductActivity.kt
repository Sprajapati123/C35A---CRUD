package com.example.c35a_crud.ui.activity

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.c35a_crud.R
import com.example.c35a_crud.databinding.ActivityAddProductBinding
import com.example.c35a_crud.model.ProductModel
import com.example.c35a_crud.repository.ProductRepositoryImpl
import com.example.c35a_crud.utils.LoadingUtils
import com.example.c35a_crud.viewmodel.ProductViewModel

class AddProductActivity : AppCompatActivity() {
    lateinit var binding: ActivityAddProductBinding

    lateinit var productViewModel: ProductViewModel

    lateinit var loadingUtils: LoadingUtils

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityAddProductBinding.inflate(layoutInflater)
        setContentView(binding.root)

        loadingUtils = LoadingUtils(this)

        var repo = ProductRepositoryImpl()
        productViewModel = ProductViewModel(repo)

        binding.btnAddProduct.setOnClickListener {
            val name = binding.editProductName.text.toString()
            val price = binding.editProductPrice.text.toString().toInt()
            val desc = binding.editProductDesc.text.toString()

            var model = ProductModel("",name,desc,price)


        }
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}