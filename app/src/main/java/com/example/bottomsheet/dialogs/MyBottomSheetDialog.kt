package com.example.bottomsheet.dialogs

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import com.example.bottomsheet.R
import com.google.android.material.bottomsheet.BottomSheetDialogFragment


class MyBottomSheetDialog: BottomSheetDialogFragment() {

    private lateinit var listener:BottomSheetListener //implements the interface
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view=inflater.inflate(R.layout.bottom_sheet_layout,container,false)
        val button1: Button=view.findViewById(R.id.Button1) //we using using the inflated view to use our buttons
        val button2: Button=view.findViewById(R.id.Button2) //plus the compiler wont let u use button1.findViewById

        button1.setOnClickListener {

           listener.onButtonClicked("Button 1 Clicked")
            dismiss()//closes the dialog
        }
        button2.setOnClickListener {
           listener.onButtonClicked("Button 2 Clicked")
            dismiss()//closes the dialog when we click on one button
        }
        return view
    }

    interface BottomSheetListener
    {
        fun onButtonClicked(input:String)
    }

    override fun onAttach(context: Context) {  //we use this to assign our listener to something cause its on the view not the button
        super.onAttach(context)
        if (context is BottomSheetListener){
                 listener=context            //if this activity is implementing the bottomsheetListener interface
        }
        else {
          throw RuntimeException(context.toString()+"you must implement the interface")
        }
    }

}