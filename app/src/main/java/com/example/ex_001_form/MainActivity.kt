package com.example.ex_001_form

import android.content.AbstractThreadedSyncAdapter
import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.RadioButton
import kotlinx.android.synthetic.main.inicio.*

class MainActivity : AppCompatActivity() {
    private lateinit var context: Context
    private lateinit var cidades: ArrayList<String>
    private lateinit var adapter: ArrayAdapter<String>
    private val tools = Tools()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.inicio)

        initVars()
        initActions()
    }

    private fun initActions() {
        btn_lerdados.setOnClickListener {
            if(fieldValidation()){
                tools.ExibeMensagem(context,"${et_nome.text.toString()}\n${et_idade.text.toString()}\n${findViewById<RadioButton>(rg_sexo.checkedRadioButtonId).text}\n${sp_cidade.getItemAtPosition(sp_cidade.selectedItemPosition)}")
            }
        }
        rg_sexo.setOnCheckedChangeListener { group, checkedId ->
            when(checkedId){
                R.id.rb_feminino ->{
                    iv_image.setImageResource(R.drawable.ic_view_stream_black_24dp)
                }
                R.id.rb_masculino ->{
                    iv_image.setImageResource(R.drawable.ic_view_carousel_black_24dp)
                }
                else ->{
                    iv_image.setImageResource(R.drawable.ic_view_carousel_black_24dp)
                }
            }
        }
    }

    private fun fieldValidation(): Boolean {
        if(et_nome.text.isNullOrEmpty()){
            tools.ExibeMensagem(context, R.string.err_nome)
            return false
        }
        if(et_idade.text.isNullOrEmpty()){
            tools.ExibeMensagem(context, R.string.err_idade)
            return false
        }

        return true
    }

    private fun initVars() {
        context = this
        gerarCidades(100)
        adapter = ArrayAdapter(
            context,
            android.R.layout.simple_spinner_item,
            cidades
        )
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        sp_cidade.adapter = adapter
    }

    private fun gerarCidades(quantidade: Int) {
        cidades = ArrayList<String>()
        for (i in 1..quantidade){
            cidades.add("Cidade - $i")
        }
    }
}
