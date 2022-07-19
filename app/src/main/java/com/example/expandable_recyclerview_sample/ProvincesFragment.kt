package com.example.expandable_recyclerview_sample

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.expandable_recyclerview_sample.databinding.FragmentAnimalsBinding

class AnimalsFragment : Fragment() {

    private lateinit var recyclerView: RecyclerView

    private var binding: FragmentAnimalsBinding? = null
    private var adapter: ProvinceAdapter?= null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        binding= FragmentAnimalsBinding.inflate(layoutInflater)

        return binding!!.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val layoutManager = LinearLayoutManager(context)
        recyclerView = view.findViewById(R.id.recycler_view)
        recyclerView.layoutManager = layoutManager
        recyclerView.setHasFixedSize(true)
        adapter = ProvinceAdapter()
        recyclerView.adapter = adapter
    }
    override fun onDestroyView() {
        super.onDestroyView()
        binding = null
    }
}