package ru.dara.flower3

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.navigation.findNavController
import ru.dara.flower3.R


class Fragment_7 : Fragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

    val view = inflater.inflate(R.layout.fragment_7, container, false)
    var applicationContext: Context
    applicationContext = requireContext()
    val login = Fragment_7Args.fromBundle(requireArguments()).login3
    val kol = Fragment_7Args.fromBundle(requireArguments()).kol0
    val price = Fragment_7Args.fromBundle(requireArguments()).price0
    val db = UserDatabase(applicationContext, null)

        // Inflate the layout for this fragment

    val Text_1 = view.findViewById<TextView>(R.id.log1)
    Text_1.text = login

    val adr1 = db.getUser1(login)
    val Text_2 = view.findViewById<TextView>(R.id.adr1)
    Text_2.text = adr1

    val tel1 = db.getUser2(login)
    val Text_3 = view.findViewById<TextView>(R.id.tel1)
    Text_3.text = tel1

    val Text_4 = view.findViewById<TextView>(R.id.kol1)
    Text_4.text = kol.toString()

    val Text_5 = view.findViewById<TextView>(R.id.price1)
    Text_5.text = price.toString()


    val Button_1 = view.findViewById<Button>(R.id.button_f7_2)
     Button_1.setOnClickListener {

        val action = Fragment_7Directions.actionFragment7ToFragment9(login)
        view.findNavController().navigate(action)
}


        return view
    }

    companion object {

        @JvmStatic
        fun newInstance() = Fragment_7()
    }
}




