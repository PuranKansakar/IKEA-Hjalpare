package com.example.ikeahjalpare.ui.main

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.example.ikeahjalpare.R

class MainFragment : Fragment() {
    private lateinit var viewModel: MainViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        ViewModelProviders.of(this).get(MainViewModel:: class.java)
        val root = inflater.inflate(R.layout.activity_main, container, false)
        val textView:TextView = root.findViewById(R.id.activity_main)
        MainViewModel.text.observe(this.Observer {
            textView.text = it
        })
        return root
        //return inflater.inflate(activity_main, container, false)
    }
    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(MainViewModel::class.java)
        viewModel.furnitures.observe(this, Observer {
                furnitures -> actFurniture.setAdapter(ArrayAdapter(context!!, R.layout.support_simple_spinner_dropdown_item, furnitures))
        })
    }
}