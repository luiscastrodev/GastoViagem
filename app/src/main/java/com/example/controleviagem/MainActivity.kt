package com.example.controleviagem

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), View.OnClickListener {

    //private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //binding = ActivityMainBinding.inflate(layoutInflater)
       // setContentView(binding.root)
        setContentView(R.layout.activity_main)

        //toolbar
        setSupportActionBar(toolbar)

        btnCalcular.setOnClickListener(this)
    }

    override fun onClick(v: View) {
        calculate()
    }

    private inline fun isValidate(): Boolean =
                distancia.text.toString() != "" &&
                preco.text.toString() != "" &&
                autonomia.text.toString() != "" &&
                autonomia.text.toString().toFloat() != 0f

    private fun calculate() {

        if (!isValidate())
            return Toast.makeText(this,"Todos campos sao obg",Toast.LENGTH_SHORT).show()

        val distance = distancia.text.toString().toFloat()
        val price = preco.text.toString().toFloat()
        val autonomy = autonomia.text.toString().toFloat()

        val totalValue = (distance * price) / autonomy
        val totalValueStr = "R$ ${"%.2f".format(totalValue)}"

        total.text = totalValueStr
    }
}