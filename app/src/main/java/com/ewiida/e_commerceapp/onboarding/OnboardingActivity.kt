package com.ewiida.e_commerceapp.onboarding

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import androidx.lifecycle.Lifecycle
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.ewiida.e_commerceapp.R
import com.ewiida.e_commerceapp.databinding.ActivityOnboardingBinding

class OnboardingActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val view = ActivityOnboardingBinding.inflate(layoutInflater)
        setContentView(view.root)

        val fragmentList = arrayListOf<Fragment>(onBoardingOne(), onBoardingTwo(), onBoardingThree())
        val adapter = ViewPagerAdapter(fragmentList, supportFragmentManager, lifecycle)
        view.pager.adapter = adapter

    }

    class ViewPagerAdapter(list : ArrayList<Fragment>, manager : FragmentManager,
                           lifecycle: Lifecycle) : FragmentStateAdapter(manager, lifecycle){

        private val fragmentList = list

        override fun getItemCount(): Int {
            return fragmentList.size
        }

        override fun createFragment(position: Int): Fragment {
            return fragmentList[position]
        }

    }


}