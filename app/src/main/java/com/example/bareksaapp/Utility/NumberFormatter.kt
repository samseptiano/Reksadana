package com.example.bareksaapp.Utility

object NumberFormatter {

	fun converMinPembelian(number:Int):String{
		var returnVal = ""
		if(number >= 1000000000 ){
			returnVal = (number/1000000000).toString()+" Miliar"
		}
		else if(number >= 1000000 ){
			returnVal = (number/1000000).toString()+" Juta"
		}
		else {
			returnVal = (number/1000).toString()+" Ribu"
		}
		return returnVal
	}
}
