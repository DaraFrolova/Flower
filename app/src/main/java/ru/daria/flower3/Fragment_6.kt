package ru.dara.flower3

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
//import ru.dara.flower3.R
import android.content.Context
import android.content.res.Resources
//import android.content.res.Resources
//import android.graphics.Bitmap
//import android.graphics.BitmapFactory
//import android.graphics.Canvas
//import android.graphics.Paint
import android.view.Gravity
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import android.widget.Toast
import android.widget.LinearLayout
import androidx.navigation.findNavController

//import android.widget.RelativeLayout
//import android.graphics.BitmapFactory
//import android.content.res.Resources

    var nf: Int = 0
    var kol : Int = 0
    var price : Int = 0
    var resAr = arrayOf(R.id.ff20, R.id.ff10, R.id.ff12, R.id.ff23, R.id.ff43, R.id.ff42, R.id.ff22,
     R.id.ff11, R.id.ff31, R.id.ff32, R.id.ff33, R.id.ff13, R.id.ff24, R.id.ff44, R.id.ff53, R.id.ff52,
    R.id.ff51, R.id.ff41, R.id.ff21 )

class Fragment_6 : Fragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
    val view = inflater.inflate(R.layout.fragment_6, container, false)

    var applicationContext: Context
    applicationContext = requireContext()

    val login = Fragment_6Args.fromBundle(requireArguments()).login2

    val Button_1 = view.findViewById<Button>(R.id.button_f6_1)

        // getting the recyclerview by its id
        val recyclerview = view.findViewById<RecyclerView>(R.id.recyclerview)

        // this creates a vertical layout Manager
        recyclerview.layoutManager = LinearLayoutManager(applicationContext, LinearLayoutManager.HORIZONTAL, false)

        // ArrayList of class ItemsViewModel
        val data = ArrayList<ItemsViewModel>()

        // This loop will create 20 Views containing
        // the image with the count of view
	var f0 : String
	var nam0 : String

        for (i in 1..43) {

        nam0= "Цветок "+i.toString()
        f0= "f"+i.toString()
       val res0 = resources.getIdentifier(f0, "drawable", applicationContext.packageName)
            data.add(ItemsViewModel(res0, nam0,f0))
}
            data.add(ItemsViewModel(R.drawable.blank1, "стереть","blank1"))





        val adapter = CustomAdapter(data)  { partItem: ItemsViewModel ->  partItemClicked(partItem) }


        recyclerview.adapter = adapter

        Button_1.setOnClickListener {

        val action = Fragment_6Directions.actionFragment6ToFragment7(login,kol,price)
        view.findNavController().navigate(action)

}

        return view
    }

    companion object {

        @JvmStatic
        fun newInstance() = Fragment_6()
    }

    private fun partItemClicked(partItem : ItemsViewModel) {
    var applicationContext: Context
    applicationContext = requireContext()
        

val resourceId = resources.getIdentifier(partItem.file, "drawable", applicationContext.packageName)

    val Image1 = ImageView(applicationContext)
    Image1.setImageResource(resourceId)
    val imageView: ImageView = view!!.findViewById(resAr[nf])
    imageView.setImageResource(resourceId)
    kol = kol+1
     if (kol>18 )
       kol = 18
    nf=nf+1
     if (nf >18)
       nf = 0
    price = kol * 50
     val Text_1: TextView = view!!.findViewById(R.id.kol_f6)
     val Text_2: TextView = view!!.findViewById(R.id.price_f6)
     Text_1.text = kol.toString()
     Text_2.text = price.toString()




    }





}




