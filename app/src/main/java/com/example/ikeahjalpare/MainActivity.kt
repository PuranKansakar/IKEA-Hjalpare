package com.example.ikeahjalpare

import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.AutoCompleteTextView
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.ikeahjalpare.ui.main.MainViewModel

class MainActivity : AppCompatActivity() {
    private lateinit var viewModel: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        viewModel = ViewModelProvider(this).get(MainViewModel::class.java)

        val actFurniture: AutoCompleteTextView =
            findViewById<AutoCompleteTextView>(R.id.textInstructions)

        viewModel.furniture.observe(this, Observer { furniture ->
            actFurniture.setAdapter(
                ArrayAdapter(
                    this,
                    R.layout.support_simple_spinner_dropdown_item,
                    furniture
                )
            )
        })
    }
}