package com.example.c35a_crud.repository

import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase

class CartRepoistoryImpl : CartRepository {

    val database: FirebaseDatabase = FirebaseDatabase.getInstance()
    val ref: DatabaseReference = database.reference.child("cart")

    override fun addToCart() {
        TODO("Not yet implemented")
    }

    override fun removeAllCart() {
        TODO("Not yet implemented")
    }

    override fun removeCartBYId() {
        TODO("Not yet implemented")
    }

    override fun updateCart() {
        TODO("Not yet implemented")
    }

    override fun getCartById() {
        TODO("Not yet implemented")
    }

    override fun getAllCart() {
        TODO("Not yet implemented")
    }
}