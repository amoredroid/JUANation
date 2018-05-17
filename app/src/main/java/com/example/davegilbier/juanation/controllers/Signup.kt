package com.example.davegilbier.juanation.controllers


import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.android.volley.Request
import com.android.volley.Response
import com.android.volley.toolbox.JsonObjectRequest
import com.android.volley.toolbox.Volley
import com.example.davegilbier.juanation.R
import kotlinx.android.synthetic.main.signup.*
import org.jetbrains.anko.toast
import org.json.JSONObject

class Signup : AppCompatActivity() {

    val url = "http://localhost:8000/register"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.signup)

        val jsonobj = JSONObject()
        btn_sign_up.setOnClickListener {

            jsonobj.put("firstname", fullname.text)
            jsonobj.put("username", username.text.toString())
            jsonobj.put("password", password.text.toString())
            jsonobj.put("email", email.text)
            jsonobj.put("location", location.text)



            val que = Volley.newRequestQueue(this)
            val req = JsonObjectRequest(Request.Method.POST, url, jsonobj,
                    Response.Listener { response ->
                        toast(response["success"].toString())

                        val intent = Intent(this, Profile::class.java)
                        startActivity(intent)


                    }, Response.ErrorListener { error ->
                toast("" + error.message)

            })
            que.add(req)



        }

    }
}