package ru.dara.flower3

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import androidx.navigation.findNavController
import ru.dara.flower3.R

/**
 * A simple [Fragment] subclass.
 * Use the [StartFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class Fragment_2 : Fragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?

): View? {
    val view = inflater.inflate(R.layout.fragment_2, container, false)
//    val EditText_2 = view.findViewById<EditText>(R.id.fragment_2_edit)

    val Button_1 = view.findViewById<Button>(R.id.button_in)
    Button_1.setOnClickListener {
//        val ms2 = EditText_2.text.toString()
//        val action = Fragment_2Directions.actionFragment2ToFragment3(ms2)
//        view.findNavController().navigate(action)
        val navController = view.findNavController() // 
        navController.navigate(R.id.action_fragment_2_to_fragment_4)
    }

    val Button_2 = view.findViewById<Button>(R.id.button_registration)
     Button_2.setOnClickListener {
        val navController = view.findNavController() // 
        navController.navigate(R.id.action_fragment_2_to_fragment_3)
    }


    // Inflate the layout for this fragment
    return view
}

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @return A new instance of fragment StartFragment.
         */
        @JvmStatic
        fun newInstance() = Fragment_2()
    }
}

class Ms_FragmentDirections {

}




