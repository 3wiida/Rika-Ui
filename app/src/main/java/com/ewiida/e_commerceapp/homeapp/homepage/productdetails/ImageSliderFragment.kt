package com.ewiida.e_commerceapp.homeapp.homepage.productdetails

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.viewpager.widget.ViewPager
import com.ewiida.e_commerceapp.R
import me.relex.circleindicator.CircleIndicator


class ImageSliderFragment : Fragment() {

    private lateinit var viewPager: ViewPager
    private var imageList:ArrayList<Int> = ArrayList()
    private lateinit var viewPagerAdapter: ImageSliderAdapter
    private lateinit var indicator: CircleIndicator

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_image_slider, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        imageList.add(R.raw.ongoing3)
        imageList.add(R.drawable.manimage)
        imageList.add(R.drawable.completed2)
        viewPager=view.findViewById(R.id.viewPager)
        viewPagerAdapter= ImageSliderAdapter(requireContext(),imageList)
        viewPager.adapter=viewPagerAdapter
        indicator=view.findViewById(R.id.indicator)
        indicator.setViewPager(viewPager)
    }
}