package com.example.bareksaapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.widget.Toolbar
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.bareksaapp.Adapter.MyPagerAdapter
import com.example.bareksaapp.Fragment.ReksadanaFragment
import com.example.bareksaapp.Model.TabFragmentModel
import com.example.bareksaapp.ViewModel.CompareReksadanaViewModel
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
	var listFragment = mutableListOf<TabFragmentModel>()
	lateinit var compareReksadanaViewModel: CompareReksadanaViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
		initViewModel()
    }

	fun initViewModel(){
		compareReksadanaViewModel = ViewModelProvider(this).get(CompareReksadanaViewModel::class.java)

		compareReksadanaViewModel.setFragment()
		compareReksadanaViewModel.getFragment().observe(this, Observer { listFrag ->
			listFragment = listFrag as MutableList<TabFragmentModel>
			initView()
		})
	}
	fun initView(){
		val toolbar = findViewById<Toolbar>(R.id.toolbar)
		toolbar.title = "Perbandingan"
		viewpager_main.adapter = MyPagerAdapter(supportFragmentManager,listFragment)
		tabs_main.setupWithViewPager(viewpager_main)
	}


}
