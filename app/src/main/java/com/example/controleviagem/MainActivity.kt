package com.example.controleviagem

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.widget.Toolbar
import com.example.controleviagem.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(), View.OnClickListener {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //toolbar
        setSupportActionBar(binding.toolbar)

        binding.btnCalcular.setOnClickListener(this)
    }

    override fun onClick(v: View) {
        calculate()
    }

    private inline fun isValidate(): Boolean =
                binding.distancia.text.toString() != "" &&
                binding.preco.text.toString() != "" &&
                binding.autonomia.text.toString() != "" &&
                binding.autonomia.text.toString().toFloat() != 0f

    private fun calculate() {

        if (!isValidate())
            return Toast.makeText(this,"Todos campos sao obg",Toast.LENGTH_SHORT).show()

        val distance = binding.distancia.text.toString().toFloat()
        val price = binding.preco.text.toString().toFloat()
        val autonomy = binding.autonomia.text.toString().toFloat()

        val totalValue = (distance * price) / autonomy
        val totalValueStr = "R$ ${"%.2f".format(totalValue)}"

        binding.total.text = totalValueStr
    }
}