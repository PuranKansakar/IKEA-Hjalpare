package com.example.ikeahjalpare.ui.main

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.ikeahjalpare.R
import kotlinx.android.synthetic.main.main_fragment.*


class MainFragment : Fragment() {

    private lateinit var viewModel: MainViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.activity_main, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(MainViewModel::class.java)
        viewModel.furnitures.observe(this, Observer {
                _furnitures -> actEnterFurniture.setAdapter(ArrayAdapter(context!!, R.layout.support_simple_spinner_dropdown_item, _furnitures))
        })
    }

    companion object {
        fun newInstance() = MainFragment()
    }

}
