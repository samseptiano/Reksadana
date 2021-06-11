package com.example.bareksaapp.Model

import com.github.mikephil.charting.data.Entry

class ReksadanaModel {
	var nama:String = ""
	var logo:String = ""
	var indicatorColor:Int = 0
	var mi:String = ""
	var dataGrafik: MutableList<Entry>? = null
	var jenisReksadana:String = ""
	var danaKelolaan:String = ""
	var persenImbalHasil:Double = 0.0
	var periodeImbalHasil:Int = 0
	var minimumPembelian:Int = 0
	var jangkaWaktu:Int = 0
	var tingkatResiko:String = ""
	var tanggalPeluncuran:String = ""
	var updDate:String = ""

}
