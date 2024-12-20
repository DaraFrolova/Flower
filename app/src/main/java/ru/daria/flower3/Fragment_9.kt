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
class Fragment_9 : Fragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
): View? {
    val view = inflater.inflate(R.layout.fragment_9, container, false)
    var applicationContext: Context
    applicationContext = requireContext()
    val db = UserDatabase(applicationContext, null)

    val login = Fragment_9Args.fromBundle(requireArguments()).login1
    val Text_1 = view.findViewById<TextView>(R.id.log1)
    Text_1.text = login

    val adr1 = db.getUser1(login)
    val Text_2 = view.findViewById<TextView>(R.id.adr1)
    Text_2.text = adr1

    val tel1 = db.getUser2(login)
    val Text_3 = view.findViewById<TextView>(R.id.tel1)
    Text_3.text = tel1



    val Button_1 = view.findViewById<Button>(R.id.button_f9_1)
     Button_1.setOnClickListener {
            val tel = view.findViewById<EditText>(R.id.edit_tel).text.toString()
            val adr = view.findViewById<EditText>(R.id.edit_adr).text.toString()
            val email=""
	    val pass =""

                val user = User(login, email, pass, tel, adr)
                val db = UserDatabase(applicationContext, null)
                val up =  db.UpdateUser(login,adr,tel)

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
        fun newInstance() = Fragment_9()
    }
}

