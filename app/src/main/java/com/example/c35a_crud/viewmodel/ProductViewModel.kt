package com.example.c35a_crud.viewmodel

import androidx.lifecycle.MutableLiveData
import com.example.c35a_crud.model.ProductModel
import com.example.c35a_crud.repository.ProductRepository

class ProductViewModel(val repo : ProductRepository) {
    fun addProduct(
        productModel: ProductModel,
        callback: (Boolean, String) -> Unit
    ) {
        repo.addProduct(productModel, callback)
    }

    fun updateProduct(
        productId: String,
        data: MutableMap<String, Any>,
        callback: (Boolean, String) -> Unit
    ) {
        repo.updateProduct(productId, data, callback)
    }

    fun deleteProduct(
        productId: String,
        callback: (Boolean, String) -> Unit
    ) {
        repo.deleteProduct(productId, callback)
    }

    var _products = MutableLiveData<ProductModel>()
    var products = MutableLiveData<ProductModel>()
        get() = _products

    var _allProducts = MutableLiveData<List<ProductModel>>()
    var allProducts = MutableLiveData<List<ProductModel>>()
        get() = _allProducts


    fun getProductById(productId: String){
        repo.getProductById(productId){
            products,success,message->
            if(success){
                _products.value = products
            }
        }
    }

    fun getAllProduct() {
        repo.getAllProduct{
                products,success,message->
            if(success){
                _allProducts.value = products
            }
        }
    }
}