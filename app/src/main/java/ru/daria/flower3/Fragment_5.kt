package ru.dara.flower3

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Button
import android.widget.EditText
import androidx.navigation.findNavController
import android.content.Context


class Fragment_5 : Fragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {

        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
    val view = inflater.inflate(R.layout.fragment_5, container, false)
    var applicationContext: Context
    applicationContext = requireContext()
    val login = Fragment_5Args.fromBundle(requireArguments()).login1
   
    val Text_1 = view.findViewById<TextView>(R.id.text_f5_2)
    Text_1.text = login


    val Button_1 = view.findViewById<Button>(R.id.button_f5_1)
    val Button_4 = view.findViewById<Button>(R.id.button_f5_4)

     Button_1.setOnClickListener {
        val action = Fragment_5Directions.actionFragment5ToFragment6(login)
        view.findNavController().navigate(action)
}

     Button_4.setOnClickListener {

        val action = Fragment_5Directions.actionFragment5ToFragment9(login)
        view.findNavController().navigate(action)
}


        return view
    }

    companion object {

        @JvmStatic
        fun newInstance() = Fragment_4()
    }
}