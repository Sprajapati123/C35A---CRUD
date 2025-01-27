package com.example.c35a_crud.repository

interface CartRepository {

    fun addToCart()

    fun removeAllCart()

    fun removeCartBYId()

    fun updateCart()

    fun getCartById()

    fun getAllCart()
}