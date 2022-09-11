package com.ewiida.e_commerceapp.homeapp.homepage.productdetails

import android.annotation.SuppressLint
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.viewpager.widget.PagerAdapter
import androidx.viewpager.widget.ViewPager
import com.ewiida.e_commerceapp.R

class ImageSliderAdapter(private val context: Context,private val imageList:ArrayList<Int>):PagerAdapter() {
    override fun getCount(): Int {
        return imageList.size
    }

    override fun isViewFromObject(view: View, `object`: Any): Boolean {
        return view === `object`
    }

    @SuppressLint("InflateParams")
    override fun instantiateItem(container: ViewGroup, position: Int): Any {
        val v=(context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater).inflate(
            R.layout.image_slider_item,null)
        val img=v.findViewById<ImageView>(R.id.imageSliderIv)

        img.setImageResource(imageList[position])

        val vp=container as ViewPager
        vp.addView(v,0)
        return v
    }

    override fun destroyItem(container: ViewGroup, position: Int, `object`: Any) {
        val vp=container as ViewPager
        val v =`object` as View
        vp.removeView(v)
    }
}