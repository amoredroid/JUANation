package com.example.davegilbier.juanation.controllers

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.android.volley.Request
import com.android.volley.Response
import com.android.volley.toolbox.JsonObjectRequest
import com.android.volley.toolbox.Volley
import com.example.davegilbier.juanation.MainActivity
import com.example.davegilbier.juanation.R
import kotlinx.android.synthetic.main.login.*
import org.jetbrains.anko.toast
import org.json.JSONObject

class Login : AppCompatActivity() {

    val url = "http://localhost:8000/login"
    // "http://172.17.0.250:8000/register"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.login)



        val jsonobj = JSONObject()
        btn_sign_in.setOnClickListener{

            jsonobj.put("username", username.text.toString())
            jsonobj.put("password", password.text.toString())

            val que = Volley.newRequestQueue(this@Login)
            val req = JsonObjectRequest(Request.Method.POST,url,jsonobj,
                    Response.Listener{response ->

                        if (response == null) { //!= null
                            val intent = Intent(this, MainActivity::class.java)
                            startActivity(intent)
                            toast(("Welcome").toString())

                        }
                    }, Response.ErrorListener{
                toast("Login failed.").toString()

            })
            que.add(req)

        }

        tV_signup.setOnClickListener{
            val intent = Intent(this, Signup::class.java)
            startActivity(intent)
        }

//        btn_sign_in.setOnClickListener{
//            val intent = Intent(this, Profile::class.java)
//            startActivity(intent)
//        }

    }

}
