package com.ewiida.e_commerceapp.homeapp.cartpage

import android.content.Intent
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.graphics.RectF
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.core.content.ContextCompat
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.ewiida.e_commerceapp.OrderDetailsActivity
import com.ewiida.e_commerceapp.R
import com.ewiida.e_commerceapp.databinding.FragmentCartBinding
import com.ewiida.e_commerceapp.homeapp.homepage.Home
import com.google.android.material.bottomnavigation.BottomNavigationView
import java.util.prefs.Preferences


class Cart : Fragment() {
    lateinit var binding:FragmentCartBinding
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = DataBindingUtil.inflate(inflater,R.layout.fragment_cart, container, false)
         return binding.root


    }


    var bundle=Bundle()
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        cartItemsRVHadler()
        binding.backBtn.setOnClickListener{
            var f= Home()
            var fm=activity?.supportFragmentManager
            var ft=fm?.beginTransaction()
            ft?.replace(R.id.container,f)
            ft?.commit()
            var bnb=activity?.findViewById<github.com.st235.lib_expandablebottombar.ExpandableBottomBar>(R.id.bottomNavigationView)
            bnb?.menu?.select(R.id.menuItemHome)
        }

        binding.linearLayout2.setOnClickListener {
            val intent = Intent(activity, OrderDetailsActivity::class.java)
            startActivity(intent)
        }
        binding.proceedToCheckoutBtn.setOnClickListener {
            val intent = Intent(activity, OrderDetailsActivity::class.java)
            startActivity(intent)
        }
        binding.addToCartBtn.setOnClickListener {
            val intent = Intent(activity, OrderDetailsActivity::class.java)
            startActivity(intent)
        }

    }

    fun cartItemsRVHadler(){
        var cartItems=ArrayList<cart_item_data_class>()
        cartItems.add(element = cart_item_data_class(R.drawable.womanimage,"Roller Rabbit","Vado Odelle Dress",198))
        cartItems.add(element = cart_item_data_class(R.drawable.cotchie,"Axel Arigato","Clean 90 Triole Snakers",245))
        cartItems.add(element = cart_item_data_class(R.drawable.backbag,"Herschel Supply Co.","Daypack Backpack",40))

        var cartItemAdapter=cart_items_rv_adabter(cartItems)
        binding.cartItemsRv.adapter=cartItemAdapter

        cartItemAdapter.onRemoveListener={
            cartItemAdapter.removeItem(it)
        }
        binding.cartItemsRv.layoutManager=LinearLayoutManager(activity)
        var itemsPrice=0
        for(i in cartItems){
            itemsPrice+=i.price
        }
        binding.numberOfCartItems.text="Total (${cartItems.size} item):"
        binding.priceOfAllCartItems.text="$itemsPrice $"

        var v=binding.cartItemsRv


        //swipe section
        var itemTouchHelper=ItemTouchHelper(object :ItemTouchHelper.SimpleCallback(0,ItemTouchHelper.LEFT){
            override fun onMove(recyclerView: RecyclerView, viewHolder: RecyclerView.ViewHolder, target: RecyclerView.ViewHolder): Boolean {
                TODO("Not yet implemented")
            }
            val icon = ContextCompat.getDrawable(context!!, R.drawable.delete)!!
            private val paint = Paint()
            override fun onSwiped(viewHolder: RecyclerView.ViewHolder, direction: Int) {
                cartItems.removeAt(viewHolder.adapterPosition)
                cartItemAdapter.notifyDataSetChanged()
                var itemsPrice=0

                for(i in cartItems){
                    itemsPrice+=i.price
                }
                binding.numberOfCartItems.text="Total (${cartItems.size} item):"
                binding.priceOfAllCartItems.text="$itemsPrice $"
            }
            override fun onChildDraw(c: Canvas, recyclerView: RecyclerView, viewHolder: RecyclerView.ViewHolder,
                                     dX: Float, dY: Float, actionState: Int, isCurrentlyActive: Boolean) {

                super.onChildDraw(c, recyclerView, viewHolder, dX, dY, actionState, isCurrentlyActive)

                if (dX != 0f && isCurrentlyActive) {
                    val itemView = viewHolder.itemView
                    paint.color = Color.parseColor("#000000")
                    val top = itemView.top + (itemView.height - icon.intrinsicHeight) / 2
                    val left = itemView.width - icon.intrinsicHeight - (itemView.height - icon.intrinsicHeight) / 2


                    if (dX < 0) {
                        val background = RectF(itemView.right.toFloat() + dX, itemView.top.toFloat(),
                            itemView.right.toFloat(), itemView.bottom.toFloat())
                        c.drawRect(background, paint)
                        icon.setBounds(left, top, left + icon.intrinsicWidth, top + icon.intrinsicHeight)
                    } else {
                        val background = RectF(itemView.left.toFloat() + dX, itemView.top.toFloat(),
                            itemView.left.toFloat(), itemView.bottom.toFloat())
                        c.drawRect(background, paint)
                        icon.setBounds(top, top, top + icon.intrinsicWidth, top + icon.intrinsicHeight)
                    }
                    icon.draw(c)
                }
            }

        }).attachToRecyclerView(v!!)

    }

}