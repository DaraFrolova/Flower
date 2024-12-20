package ru.dara.flower3

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.navigation.findNavController
import ru.dara.flower3.R
import android.content.Context
import ru.dara.flower3.User
import ru.dara.flower3.UserDatabase


class Fragment_4 : Fragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
): View? {

    val view = inflater.inflate(R.layout.fragment_4, container, false)
    var applicationContext: Context
    applicationContext = requireContext()

    val Button_1 = view.findViewById<Button>(R.id.button_f4_1)
    val Button_2 = view.findViewById<Button>(R.id.button_f4_2)
     Button_1.setOnClickListener {
            val login = view.findViewById<EditText>(R.id.edit_login).text.toString()
            val pass = view.findViewById<EditText>(R.id.edit_password).text.toString()


            if (login == "" || pass == "")
                Toast.makeText(applicationContext, "Не все поля заполнены", Toast.LENGTH_SHORT).show()
            else {
                val db = UserDatabase(applicationContext, null)
                val isExist = db.getUser(login, pass)
                if (isExist) {
//        val navController = view.findNavController() // 
//        navController.navigate(R.id.action_fragment_4_to_fragment_5)

        val action = Fragment_4Directions.actionFragment4ToFragment5(login)
        view.findNavController().navigate(action)

                } else
                  Toast.makeText(applicationContext, "Такого пользоватля нет", Toast.LENGTH_LONG).show()
                }
}
     Button_2.setOnClickListener {
        val navController = view.findNavController() // 
        navController.navigate(R.id.action_fragment_4_to_fragment_3)
}

        // Inflate the layout for this fragment
        return view
    }

    companion object {

        @JvmStatic
        fun newInstance() = Fragment_4()
    }
}




