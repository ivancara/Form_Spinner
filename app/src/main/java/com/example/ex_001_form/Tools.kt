package com.example.ex_001_form

import android.content.Context
import android.widget.Toast

class Tools {
    fun ExibeMensagem (context: Context, resource:Int){
        Toast.makeText(context, resource, Toast.LENGTH_SHORT).show()
    }

    fun ExibeMensagem (context: Context, resource:String){
        Toast.makeText(context, resource, Toast.LENGTH_SHORT).show()
    }
}