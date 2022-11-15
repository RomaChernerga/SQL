package com.example.sql

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import android.widget.ImageButton
import android.widget.ImageView
import androidx.constraintlayout.widget.ConstraintLayout
import com.google.android.material.floatingactionbutton.FloatingActionButton


class EditFragment : Fragment() {

//    private val dbManager= MyPhoneBookManager(requireActivity())
    private val nameText = view?.findViewById<EditText>(R.id.editText_name)
    private val phoneText = view?.findViewById<EditText>(R.id.editText_phone)


    private val imBtnEdit = view?.findViewById<ImageButton>(R.id.imBtn_edit)
    private val imageAvatar = view?.findViewById<ImageView>(R.id.image_avatar)

//    private val textView = view?.findViewById<TextView>(R.id.textView)
    private val btnSave = view?.findViewById<FloatingActionButton>(R.id.btn_save)

//    private val onUpdate = view?.findViewById<Button>(R.id.btn_update)
//    private val onDelete = view?.findViewById<Button>(R.id.btn_delete)
//    private val onShow = view?.findViewById<Button>(R.id.btn_show)



    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_edit, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val btnAddImage = view.findViewById<FloatingActionButton>(R.id.btn_addImage)
        val myImageLayout = view.findViewById<ConstraintLayout>(R.id.myImageLayout)
        btnAddImage.setOnClickListener {
            myImageLayout?.visibility = View.VISIBLE
            btnAddImage.visibility = View.GONE
        }

        val imBtnDelete = view.findViewById<ImageButton>(R.id.imBtn_delete)
        imBtnDelete.setOnClickListener {
            myImageLayout?.visibility = View.GONE
            btnAddImage.visibility = View.VISIBLE
        }




        btnSave?.setOnClickListener {
//            dbManager.openDB()
//            dbManager.insertToDB(name_text?.text.toString(), phone_text?.text.toString())
        }

//        onUpdate?.setOnClickListener {
//
//        }
//
//        onDelete?.setOnClickListener {
//            dbManager.delete()
//        }
//
//        onShow?.setOnClickListener {
//            textView?.text  = ""
//            dbManager.openDB()
//            val dataList = dbManager.readDBData()
//            for (item in dataList) {
//                textView?.append(item)
//                textView?.append("\n")
//            }
//        }
    }

    override fun onDestroy() {
        super.onDestroy()
//        dbManager.closeDB()
    }

}