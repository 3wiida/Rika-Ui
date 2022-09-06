package com.ewiida.e_commerceapp.onboarding

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.Lifecycle
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.ewiida.e_commerceapp.databinding.ActivityOnboardingBinding
import com.ewiida.e_commerceapp.loginscreens.LoginActivity
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator

class OnboardingActivity : AppCompatActivity() {

    lateinit var view : ActivityOnboardingBinding
    private val fragmentList = arrayListOf<Fragment>(onBoardingOne(), onBoardingTwo(), onBoardingThree())

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        view = ActivityOnboardingBinding.inflate(layoutInflater)
        setContentView(view.root)

        val adapter = ViewPagerAdapter(fragmentList, supportFragmentManager, lifecycle)
        view.pager.adapter = adapter

        view.indicator.setViewPager(view.pager)

        view.floatingActionButton.setOnClickListener {
            if(!view.pager.currentItem.equals(fragmentList.size-1) ){
                view.pager.currentItem = view.pager.currentItem.plus(1)
            }else{
                var itt: Intent = Intent(this, LoginActivity::class.java)
                startActivity(itt)
                this.finish()
            }
        }
    }

    override fun onBackPressed() {
        //TODO Fix this bug ya 3aaaaaaaam
        if(view.pager.currentItem == 0){
            this.finish()
        }else{
            view.pager.currentItem = view.pager.currentItem.minus(1)
        }
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
