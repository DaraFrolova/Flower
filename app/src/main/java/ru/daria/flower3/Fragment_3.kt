package ru.dara.flower3

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import android.widget.TextView
import ru.dara.flower3.R
import androidx.navigation.findNavController
import android.content.Context
import ru.dara.flower3.User
import ru.dara.flower3.UserDatabase

/**
 * A simple [Fragment] subclass.
 * Use the [StartFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class Fragment_3 : Fragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
): View? {
    val view = inflater.inflate(R.layout.fragment_3, container, false)
    var applicationContext: Context
    applicationContext = requireContext()

    val Button_1 = view.findViewById<Button>(R.id.button_f3_1)
     Button_1.setOnClickListener {
            val login = view.findViewById<EditText>(R.id.edit_login).text.toString()
            val email = view.findViewById<EditText>(R.id.edit_mail).text.toString()
            val pass = view.findViewById<EditText>(R.id.edit_password).text.toString()
            val tel = " "
            val adr = " "

            if (login == "" || email == "" || pass == "")
                Toast.makeText(applicationContext,"Не все поля заполнены", Toast.LENGTH_SHORT).show()
            else{
                val user = User(login, email, pass, tel, adr)
                val db = UserDatabase(applicationContext, null)
                db.addUser(user)
                Toast.makeText(applicationContext,"Пользователь $login добавлен",Toast.LENGTH_LONG ).show()

             //   userLogin.text.clear()
             //   userEmail.text.clear()
             //   userPass.text.clear()
            }
}

    val Button_2 = view.findViewById<Button>(R.id.button_f3_2)
     Button_2.setOnClickListener {

        val navController = view.findNavController() // 
        navController.navigate(R.id.action_fragment_3_to_fragment_4)
}

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
        fun newInstance() = Fragment_3()
    }
}




