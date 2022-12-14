package com.ewiida.e_commerceapp.ui.homeapp.cartpage

import android.annotation.SuppressLint
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
import androidx.core.content.ContextCompat
import androidx.databinding.DataBindingUtil
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.ewiida.e_commerceapp.ui.homeapp.cartpage.orderdetails.OrderDetailsActivity
import com.ewiida.e_commerceapp.R
import com.ewiida.e_commerceapp.databinding.FragmentCartBinding


class CartPage : Fragment() {

    lateinit var binding: FragmentCartBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_cart, container, false)
        return binding.root
    }


    var bundle = Bundle()
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        cartItemsRVHolder()
        binding.backBtn.setOnClickListener {
            findNavController().popBackStack()
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

    @SuppressLint("SetTextI18n")
    fun cartItemsRVHolder() {
        val cartItems = ArrayList<CartItemDataClass>()
        cartItems.add(
            element = CartItemDataClass(
                R.drawable.womanimage,
                "Roller Rabbit",
                "Vado Odelle Dress",
                198
            )
        )
        cartItems.add(
            element = CartItemDataClass(
                R.drawable.cotchie,
                "Axel Arigato",
                "Clean 90 Triole Sneakers",
                245
            )
        )
        cartItems.add(
            element = CartItemDataClass(
                R.drawable.backbag,
                "Herschel Supply Co.",
                "Daypack Backpack",
                40
            )
        )

        val cartItemAdapter = CartItemsRvAdapter(cartItems)
        binding.cartItemsRv.adapter = cartItemAdapter

        cartItemAdapter.onRemoveListener = {
            cartItemAdapter.removeItem(it)

            //reduce price when removing item with minus one btn
            var totalPrice = binding.priceOfAllCartItems.text.toString()
            totalPrice = totalPrice.slice(0 until totalPrice.length - 2)
            var t = totalPrice.toString().toInt()
            t -= it.price
            binding.priceOfAllCartItems.text = "${t.toString()} $"

            //reduce number of items when removing items with minus one btn
            //noi = number of items
            var noi = binding.numberOfCartItems.text.toString()
            var n = noi[7]
            n -= 1
            binding.numberOfCartItems.text = "Total ($n item):"
        }
        binding.cartItemsRv.layoutManager = LinearLayoutManager(activity)
        var itemsPrice = 0
        for (i in cartItems) {
            itemsPrice += i.price
        }
        binding.numberOfCartItems.text = "Total (${cartItems.size} item):"
        binding.priceOfAllCartItems.text = "$itemsPrice $"

        val v = binding.cartItemsRv


        //swipe section
        var itemTouchHelper =
            ItemTouchHelper(object : ItemTouchHelper.SimpleCallback(0, ItemTouchHelper.LEFT) {
                override fun onMove(
                    recyclerView: RecyclerView,
                    viewHolder: RecyclerView.ViewHolder,
                    target: RecyclerView.ViewHolder
                ): Boolean {
                    TODO("Not yet implemented")
                }

                val icon = ContextCompat.getDrawable(context!!, R.drawable.delete)!!
                private val paint = Paint()

                @SuppressLint("NotifyDataSetChanged")
                override fun onSwiped(viewHolder: RecyclerView.ViewHolder, direction: Int) {
                    cartItems.removeAt(viewHolder.adapterPosition)
                    cartItemAdapter.notifyDataSetChanged()
                    var itemsPrice = 0

                    for (i in cartItems) {
                        itemsPrice += i.price
                    }
                    binding.numberOfCartItems.text = "Total (${cartItems.size} item):"
                    binding.priceOfAllCartItems.text = "$itemsPrice $"
                }

                override fun onChildDraw(
                    c: Canvas, recyclerView: RecyclerView, viewHolder: RecyclerView.ViewHolder,
                    dX: Float, dY: Float, actionState: Int, isCurrentlyActive: Boolean
                ) {

                    super.onChildDraw(
                        c,
                        recyclerView,
                        viewHolder,
                        dX,
                        dY,
                        actionState,
                        isCurrentlyActive
                    )

                    if (dX != 0f && isCurrentlyActive) {
                        val itemView = viewHolder.itemView
                        paint.color = Color.parseColor("#000000")
                        val top = itemView.top + (itemView.height - icon.intrinsicHeight) / 2
                        val left =
                            itemView.width - icon.intrinsicHeight - (itemView.height - icon.intrinsicHeight) / 2


                        if (dX < 0) {
                            val background = RectF(
                                itemView.right.toFloat() + dX, itemView.top.toFloat(),
                                itemView.right.toFloat(), itemView.bottom.toFloat()
                            )
                            c.drawRect(background, paint)
                            icon.setBounds(
                                left,
                                top,
                                left + icon.intrinsicWidth,
                                top + icon.intrinsicHeight
                            )
                        } else {
                            val background = RectF(
                                itemView.left.toFloat() + dX, itemView.top.toFloat(),
                                itemView.left.toFloat(), itemView.bottom.toFloat()
                            )
                            c.drawRect(background, paint)
                            icon.setBounds(
                                top,
                                top,
                                top + icon.intrinsicWidth,
                                top + icon.intrinsicHeight
                            )
                        }
                        icon.draw(c)
                    }
                }

            }).attachToRecyclerView(v)

    }

}