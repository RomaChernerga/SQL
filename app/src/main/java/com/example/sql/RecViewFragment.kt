package com.example.sql

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.floatingactionbutton.FloatingActionButton


class RecViewFragment : Fragment() {

    private val tvEmpty = view?.findViewById<TextView>(R.id.tView_noElements)
    private val recView = view?.findViewById<RecyclerView>(R.id.recView)



    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_rec_view, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val createNew = view.findViewById<FloatingActionButton>(R.id.btn_create)

        createNew?.setOnClickListener {
            Toast.makeText(requireActivity(), "переход", Toast.LENGTH_SHORT).show()
            activity?.supportFragmentManager
                ?.beginTransaction()
                ?.replace(R.id.placeholder, EditFragment::class.java.newInstance())
                ?.addToBackStack(null)
                ?.commit()

        }

    }

}