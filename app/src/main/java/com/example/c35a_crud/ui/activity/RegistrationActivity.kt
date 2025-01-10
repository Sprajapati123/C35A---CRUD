package com.example.c35a_crud.ui.activity

import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.c35a_crud.R
import com.example.c35a_crud.databinding.ActivityRegistrationBinding
import com.example.c35a_crud.model.UserModel
import com.example.c35a_crud.repository.UserRepositoryImpl
import com.example.c35a_crud.viewmodel.UserViewModel
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase

class RegistrationActivity : AppCompatActivity() {

    lateinit var binding: ActivityRegistrationBinding

    lateinit var userViewModel: UserViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        binding = ActivityRegistrationBinding.inflate(layoutInflater)
        setContentView(binding.root)

        var repo = UserRepositoryImpl()
        userViewModel = UserViewModel(repo)


        binding.signUp.setOnClickListener {
            var email = binding.registerEmail.text.toString()
            var password = binding.registerPassword.text.toString()
            var firstName = binding.registerFname.text.toString()
            var lastName = binding.registerLName.text.toString()
            var address = binding.registerAddress.text.toString()
            var phone = binding.registerContact.text.toString()



            userViewModel.signup(email, password) {
                      success, message, userId ->
                if (success) {
                    var userModel = UserModel(
                        userId.toString(), firstName,
                        lastName, address,
                        phone, email
                    )
                    userViewModel.addUserToDatabase(userId,userModel){
                        success,message->
                        if(success){
                            Toast.makeText(
                                this@RegistrationActivity,
                                message,
                                Toast.LENGTH_LONG
                            ).show()
                        }else{
                            Toast.makeText(
                                this@RegistrationActivity,
                                message,
                                Toast.LENGTH_LONG
                            ).show()
                        }
                    }
                } else {
                    Toast.makeText(
                        this@RegistrationActivity,
                        message,
                        Toast.LENGTH_LONG
                    ).show()
                }
            }

//            auth.createUserWithEmailAndPassword(email, password)
//                .addOnCompleteListener {
//                    if (it.isSuccessful) {
//
//                        var userId = auth.currentUser?.uid
//
//                        var userModel = UserModel(
//                            userId.toString(), firstName,
//                            lastName, address,
//                            phone, email
//                        )
//
//                        ref.child(userId.toString()).setValue(userModel)
//                            .addOnCompleteListener {
//                            if(it.isSuccessful){
//                                Toast.makeText(
//                                    this@RegistrationActivity,
//                                    "Registration success", Toast.LENGTH_LONG
//                                ).show()
//                            }else{
//                                Toast.makeText(
//                                    this@RegistrationActivity,
//                                    it.exception?.message, Toast.LENGTH_LONG
//                                ).show()
//                            }
//                        }
//
//
//                    } else {
//                        Toast.makeText(
//                            this@RegistrationActivity,
//                            it.exception?.message, Toast.LENGTH_LONG
//                        ).show()
//                    }
//                }
        }


        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}