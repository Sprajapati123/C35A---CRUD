package com.example.c35a_crud.repository

import com.example.c35a_crud.model.UserModel
import com.google.firebase.auth.FirebaseUser

interface UserRepository {

//    {
//     "success" : true
//    "message" : "login successfull"
//    }

    //    {
//     "success" : true
//    "message" : "register successfull"
//    "userId" : "1234"
//    }

    fun login(email:String,password:String,
              callback:(Boolean,String)->Unit)

    fun signup(email:String,password:String,
               callback: (Boolean, String,String) -> Unit)

    fun addUserToDatabase(userId: String,userModel: UserModel,
                          callback: (Boolean, String) -> Unit)

    fun forgetPassword(email:String,
                       callback: (Boolean, String) -> Unit)

    fun getCurrentUser() : FirebaseUser?



}