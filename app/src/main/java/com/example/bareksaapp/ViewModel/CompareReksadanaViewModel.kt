package com.example.bareksaapp.ViewModel

import android.text.TextUtils
import android.util.Patterns
import androidx.databinding.BaseObservable
import androidx.databinding.Bindable
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.bareksaapp.Fragment.ReksadanaFragment
import com.example.bareksaapp.Model.ReksadanaModel
import com.example.bareksaapp.Model.TabFragmentModel
import com.example.bareksaapp.R
import com.example.bareksaapp.Repository.DataDummyRepository
import com.github.mikephil.charting.data.Entry


class CompareReksadanaViewModel : ViewModel() {
	 var reksadanaList = MutableLiveData<List<ReksadanaModel>>()
	 var listFragment = MutableLiveData<List<TabFragmentModel>>()
	 var listPeriod = MutableLiveData<List<String>>()

	 var dummy = DataDummyRepository()

	fun setReksadanaList() {
		reksadanaList.postValue(dummy.generateDataDummy())
	}
	fun setFragment() {
		listFragment.postValue(dummy.insertTab())
	}
	fun setPeriod() {
		listPeriod.postValue(dummy.generatePeriod())
	}


	fun getReksadanaList(): LiveData<List<ReksadanaModel>> {
		return reksadanaList
	}
	fun getFragment(): LiveData<List<TabFragmentModel>> {
		return listFragment
	}
	fun getPeriod(): LiveData<List<String>> {
		return listPeriod
	}




	// ==================== DATA DUMMY ==========================


}

