package com.example.bareksaapp.Fragment

import android.media.session.MediaSession
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.bareksaapp.Adapter.IndicatorAdapter
import com.example.bareksaapp.Model.ReksadanaModel
import com.example.bareksaapp.R
import com.example.bareksaapp.ViewModel.CompareReksadanaViewModel
import com.github.mikephil.charting.charts.LineChart
import com.github.mikephil.charting.components.Description
import com.github.mikephil.charting.components.Legend
import com.github.mikephil.charting.components.XAxis
import com.github.mikephil.charting.components.YAxis
import com.github.mikephil.charting.data.*
import com.github.mikephil.charting.formatter.IAxisValueFormatter
import com.github.mikephil.charting.interfaces.datasets.ILineDataSet
import com.github.mikephil.charting.utils.ColorTemplate
import com.google.android.material.tabs.TabLayout
import kotlinx.android.synthetic.main.activity_main.*


class ReksadanaFragment : Fragment() {

	lateinit var compareReksadanaViewModel: CompareReksadanaViewModel
	var listReksadana = mutableListOf<ReksadanaModel>()
	var listPeriod = mutableListOf<String>()

	lateinit var rootView:View

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
		inflater: LayoutInflater, container: ViewGroup?,
		savedInstanceState: Bundle?
	): View? {
        // Inflate the layout for this fragment
        rootView = inflater.inflate(R.layout.fragment_reksadana, container, false)
		return rootView
    }

	override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
		super.onViewCreated(view, savedInstanceState)
		initViewModel()

	}

	fun initTab(){

		var tab = rootView.findViewById(R.id.simpleTabLayout) as TabLayout
		for(i in 0 until listPeriod.size){
			val firstTab: TabLayout.Tab = tab.newTab()
			firstTab.text = listPeriod[i]
			tab.addTab(firstTab)
		}

	}




	fun initViewModel(){
		compareReksadanaViewModel = ViewModelProvider(this).get(CompareReksadanaViewModel::class.java)
		compareReksadanaViewModel.setReksadanaList()
		compareReksadanaViewModel.setPeriod()
		compareReksadanaViewModel.getReksadanaList().observe(
			viewLifecycleOwner,
			Observer { listFrag ->
				listReksadana = listFrag as MutableList<ReksadanaModel>
				initRvIndicator()
				initRvDetail()
				initChart()


			})
		compareReksadanaViewModel.getPeriod().observe(viewLifecycleOwner, Observer { listPeriods ->
			listPeriod = listPeriods as MutableList<String>
			initTab()

		})
	}

	fun initRvIndicator(){
		var recyclerView = rootView.findViewById(R.id.rvIndicator) as RecyclerView
		var tvLastUpdDate = rootView.findViewById(R.id.tvLastUpdateDate) as TextView

		if(listReksadana.size != 0) {
			tvLastUpdDate.text = "("+listReksadana.get(0).updDate+")"
		}

		var adapter = context?.let { IndicatorAdapter(listReksadana, R.layout.indicator_item, it) }

		val layoutManager: RecyclerView.LayoutManager = LinearLayoutManager(
			context,
			LinearLayoutManager.HORIZONTAL,
			false
		)

		recyclerView.setLayoutManager(layoutManager)

		recyclerView.setAdapter(adapter)
	}

	fun initRvDetail(){
		var recyclerView = rootView.findViewById(R.id.rvReksadanaDetail) as RecyclerView

		var adapter =
			context?.let { IndicatorAdapter(listReksadana, R.layout.reksadana_detail_item, it) }

		val layoutManager: RecyclerView.LayoutManager = GridLayoutManager(
			context, listReksadana
				.size
		)

		recyclerView.setLayoutManager(layoutManager)

		recyclerView.setAdapter(adapter)
	}


	fun initChart(){

		var mChart = rootView.findViewById(R.id.line) as LineChart
		mChart.setDrawGridBackground(false)
		mChart.description = null
		mChart.setTouchEnabled(true)
		mChart.setDragEnabled(false)
		mChart.setScaleEnabled(false)
		mChart.setPinchZoom(false)
		mChart.getXAxis().setTextSize(10f)
		mChart.getAxisLeft().setTextSize(10f)

		val xl: XAxis = mChart.getXAxis()
		xl.position = XAxis.XAxisPosition.BOTTOM
		xl.setAvoidFirstLastClipping(true)
		xl.setLabelCount(5, true);

		val leftAxis: YAxis = mChart.getAxisLeft()
		leftAxis.isEnabled = false
		leftAxis.setLabelCount(5, true);
		val rightAxis: YAxis = mChart.getAxisRight()
		rightAxis.isEnabled = true
		rightAxis.setLabelCount(5, true);
		val l: Legend = mChart.getLegend()

		l.form = Legend.LegendForm.LINE
		l.setEnabled(false);

		rightAxis.setDrawGridLines(true);
		xl.setDrawGridLines(false);

		rightAxis.setValueFormatter( IAxisValueFormatter { value, axis ->
			when(value.toInt()){
				//write your logic here
				0 -> return@IAxisValueFormatter "0 %"
				1 -> return@IAxisValueFormatter "10 %"
				2 -> return@IAxisValueFormatter "20 %"
				3 -> return@IAxisValueFormatter "30 %"
				4 -> return@IAxisValueFormatter "40 %"
				else -> return@IAxisValueFormatter ""
			}
		})
		xl.setValueFormatter( IAxisValueFormatter { value, axis ->
			when(value.toInt()){
				//write your logic here
				0 -> return@IAxisValueFormatter "Jan 20"
				1 -> return@IAxisValueFormatter "Mar 20"
				2 -> return@IAxisValueFormatter "Mai 20"
				3 -> return@IAxisValueFormatter "Jul 20"
				4 -> return@IAxisValueFormatter "Sep 20"
				else -> return@IAxisValueFormatter ""
			}
		})


		val data = populateDataChart()
		mChart.data = data
		mChart.invalidate()
	}


	fun populateDataChart():LineData{
		var lineData = LineData()
		for(i in 0 until listReksadana.size){
			val set = LineDataSet(listReksadana.get(i).dataGrafik,listReksadana.get(i).nama)
			set.setColors(listReksadana.get(i).indicatorColor)
			set.lineWidth = 1.5f
			lineData.addDataSet(set)
		}
		return lineData
	}


}


