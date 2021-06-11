package com.example.bareksaapp.Adapter

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import com.example.bareksaapp.Model.TabFragmentModel

class MyPagerAdapter(fm: FragmentManager,fragmentList:List<TabFragmentModel>): FragmentPagerAdapter(fm){

	private var pages = mutableListOf<Fragment>()
	private var pagesTitle = mutableListOf<String>()

	init {
		for(i in fragmentList.indices){
			fragmentList.get(i).fragment?.let { pages.add(it) }
			fragmentList.get(i).title?.let { pagesTitle.add(it) }
		}
	}

	override fun getItem(position: Int): Fragment {
		return pages[position]
	}

	override fun getCount(): Int {
		return pages.size
	}

	override fun getPageTitle(position: Int): CharSequence? {
		return pagesTitle[position]
	}
}
