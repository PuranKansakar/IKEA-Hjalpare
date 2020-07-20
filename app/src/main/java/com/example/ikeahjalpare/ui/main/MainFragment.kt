package com.example.ikeahjalpare.ui.main

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import com.example.ikeahjalpare.R
import kotlinx.android.synthetic.main.activity_main.*

class MainFragment : Fragment() {
    private lateinit var viewModel: MainViewModel

    companion object {
        fun newInstance() = MainFragment
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        ViewModelProvider(this).get(MainViewModel:: class.java)
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
        viewModel = ViewModelProvider(this).get(MainViewModel::class.java)
        viewModel.furnitures.observe(this, Observer {
                furnitures -> actFurniture.setAdapter(ArrayAdapter(context!!, R.layout.support_simple_spinner_dropdown_item, furnitures))
        })
    }
}