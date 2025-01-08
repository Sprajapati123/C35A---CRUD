package com.example.c35a_crud.repository

interface UserRepository {

//    {
//     "success" : true
//    "message" : "login successfull"
//    }
    fun login(email:String,password:String,callback:(Boolean,String) -> Unit)

    fun signup()

    fun addUserToDatabase()

    fun forgetPassword()

    fun getCurrentUser()
}