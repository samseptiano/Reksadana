package com.example.bareksaapp.Repository

import com.example.bareksaapp.Fragment.ReksadanaFragment
import com.example.bareksaapp.Model.ReksadanaModel
import com.example.bareksaapp.Model.TabFragmentModel
import com.example.bareksaapp.R
import com.github.mikephil.charting.data.Entry

class DataDummyRepository {

	fun generateDataDummy():List<ReksadanaModel>{
		var returnValue = mutableListOf<ReksadanaModel>()
		var listEntry = mutableListOf<Entry>()

		var reksadanaModel = ReksadanaModel()
		reksadanaModel.danaKelolaan = "3,64 Milliar"
		reksadanaModel.jangkaWaktu = 5
		reksadanaModel.jenisReksadana = "Saham"
		reksadanaModel.logo = ""
		reksadanaModel.mi = "BNI Asset Management"
		reksadanaModel.minimumPembelian = 1000000
		reksadanaModel.indicatorColor = R.color.green_light
		reksadanaModel.tingkatResiko = "Tinggi"
		reksadanaModel.nama = "BNI-AM Inspiring Equity Fund"
		reksadanaModel.persenImbalHasil = 5.50
		reksadanaModel.periodeImbalHasil = 5
		reksadanaModel.tanggalPeluncuran = "16 Apr 2014"
		reksadanaModel.updDate = "20 Sep 2021"
		listEntry = mutableListOf<Entry>()
		listEntry.add(Entry(0f, 0F))
		listEntry.add(Entry(1f, 1F))
		listEntry.add(Entry(2f, 2F))
		listEntry.add(Entry(3f, 3F))
		listEntry.add(Entry(4f, 4F))
		reksadanaModel.dataGrafik = listEntry
		returnValue.add(reksadanaModel)




		reksadanaModel = ReksadanaModel()
		reksadanaModel.danaKelolaan = "3,64 Milliar"
		reksadanaModel.jangkaWaktu = 5
		reksadanaModel.jenisReksadana = "Pendapatan Tetap"
		reksadanaModel.logo = ""
		reksadanaModel.mi = "Ciptadana Asset Management"
		reksadanaModel.minimumPembelian = 1000000
		reksadanaModel.indicatorColor = R.color.violet_light
		reksadanaModel.tingkatResiko = "Tinggi"
		reksadanaModel.nama = "Cipta Dana Cash"
		reksadanaModel.persenImbalHasil = 5.50
		reksadanaModel.periodeImbalHasil = 5
		reksadanaModel.tanggalPeluncuran = "16 Apr 2014"
		reksadanaModel.updDate = "20 Sep 2021"
		listEntry = mutableListOf<Entry>()
		listEntry.add(Entry(0f, 0F))
		listEntry.add(Entry(1f, 1F))
		listEntry.add(Entry(2f, 3F))
		listEntry.add(Entry(3f, 2F))
		listEntry.add(Entry(4f, 4F))
		reksadanaModel.dataGrafik = listEntry
		returnValue.add(reksadanaModel)

		reksadanaModel = ReksadanaModel()
		reksadanaModel.danaKelolaan = "3,64 Milliar"
		reksadanaModel.jangkaWaktu = 5
		reksadanaModel.jenisReksadana = "Pasar Uang"
		reksadanaModel.logo = ""
		reksadanaModel.mi = "Sucor Asset Management"
		reksadanaModel.minimumPembelian = 1000000
		reksadanaModel.indicatorColor = R.color.blue_light
		reksadanaModel.tingkatResiko = "Rendah"
		reksadanaModel.nama = "Ascend Reksa Dana Saham Equity Fund"
		reksadanaModel.persenImbalHasil = 5.50
		reksadanaModel.periodeImbalHasil = 5
		reksadanaModel.tanggalPeluncuran = "16 Apr 2014"
		reksadanaModel.updDate = "20 Sep 2021"
		listEntry = mutableListOf<Entry>()
		listEntry.add(Entry(0f, 0F))
		listEntry.add(Entry(1f, 1F))
		listEntry.add(Entry(2f, 2F))
		listEntry.add(Entry(3f, 2F))
		listEntry.add(Entry(4f, 4F))
		reksadanaModel.dataGrafik = listEntry
		returnValue.add(reksadanaModel)

		return returnValue
	}

	fun insertTab():List<TabFragmentModel>{
		var listFrag = mutableListOf<TabFragmentModel>()
		var tabFragmentModel = TabFragmentModel()
		tabFragmentModel.title = "Imbal Hasil"
		tabFragmentModel.fragment = ReksadanaFragment()
		listFrag.add(tabFragmentModel)

		tabFragmentModel = TabFragmentModel()
		tabFragmentModel.title = "Dana Kelolaan"
		tabFragmentModel.fragment = ReksadanaFragment()
		listFrag.add(tabFragmentModel)
		return listFrag
	}

	fun generatePeriod():List<String>{
		var listPeriods = mutableListOf<String>()

		listPeriods.add("1 W")
		listPeriods.add("1 Y")
		listPeriods.add("3 Y")
		listPeriods.add("5 Y")
		listPeriods.add("10 Y")
		listPeriods.add("ALL")

		return listPeriods
	}

}
