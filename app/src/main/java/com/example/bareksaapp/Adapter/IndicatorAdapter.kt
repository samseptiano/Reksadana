package com.example.bareksaapp.Adapter

import android.content.Context
import android.graphics.Point
import android.graphics.Typeface
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.WindowManager
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.bareksaapp.Model.ReksadanaModel
import com.example.bareksaapp.R
import com.example.bareksaapp.Utility.NumberFormatter


class IndicatorAdapter(dataList: MutableList<ReksadanaModel>?, view: Int, ctx: Context) :
	RecyclerView.Adapter<IndicatorAdapter.IndicatorViewHolder>() {

	private val dataList: MutableList<ReksadanaModel>?
	private var vieww:Int = 0
	private val ctx:Context
	var highestHeight = 0
	var currentItemHeight = 0
	var highestHeightType = 0
	var currentItemHeightType = 0

	override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): IndicatorViewHolder {
		val layoutInflater = LayoutInflater.from(parent.context)
		val view: View = layoutInflater.inflate(vieww, parent, false)



		if(vieww == R.layout.reksadana_detail_item) {

			val myViewHolder = IndicatorViewHolder(view)
			myViewHolder.name = view.findViewById(R.id.name)
			myViewHolder.jenisReksadana = view.findViewById(R.id.jenisReksadana)

			if (dataList != null) {
				for (m in dataList) {
					currentItemHeight =
						getHeightOfLargestDescription(ctx, m.nama, myViewHolder.name)

					if (currentItemHeight > highestHeight) {
						highestHeight = currentItemHeight
					}

					currentItemHeightType =
						getHeightOfLargestDescription(ctx, m.jenisReksadana, myViewHolder.jenisReksadana)
					if (currentItemHeightType > highestHeightType) {
						highestHeightType = currentItemHeightType
					}
				}
			}
		}

		return IndicatorViewHolder(view)
	}

	override fun onBindViewHolder(holder: IndicatorViewHolder, position: Int) {
		if (dataList != null) {
			if(vieww == R.layout.indicator_item){
				holder.nameIndicator.text = dataList.get(position).persenImbalHasil.toString()+"%"
				holder.iconIndicator.setBackgroundResource(getIndicatorIcon(dataList.get(position).indicatorColor));

			}
			else if(vieww == R.layout.reksadana_detail_item) {
				holder.name.setHeight(highestHeight);
				holder.name.text = dataList.get(position).nama.toString()
				holder.lnName.setBackgroundTintList(
					ctx.getResources().getColorStateList(
						dataList.get(
							position
						).indicatorColor
					)
				);
				holder.jenisReksadana.text = dataList.get(position).jenisReksadana.toString()
				holder.jenisReksadana.setHeight(highestHeightType);

				holder.jenisReksadana.setBackgroundTintList(
					ctx.getResources().getColorStateList(
						dataList.get(
							position
						).indicatorColor
					)
				);
				holder.imbalHasil.text = dataList.get(position).persenImbalHasil.toString()+"% /"+dataList.get(
					position
				).periodeImbalHasil.toString()+" thn"
				holder.imbalHasil.setBackgroundTintList(
					ctx.getResources().getColorStateList(
						dataList.get(
							position
						).indicatorColor
					)
				);
				holder.danaKelolaan.text = dataList.get(position).danaKelolaan.toString()
				holder.danaKelolaan.setBackgroundTintList(
					ctx.getResources().getColorStateList(
						dataList.get(
							position
						).indicatorColor
					)
				);
				holder.minPembelian.text = NumberFormatter.converMinPembelian(dataList.get(position).minimumPembelian).toString()
				holder.minPembelian.setBackgroundTintList(
					ctx.getResources().getColorStateList(
						dataList.get(
							position
						).indicatorColor
					)
				);
				holder.jangkaWaktu.text = dataList.get(position).jangkaWaktu.toString()+" tahun"
				holder.jangkaWaktu.setBackgroundTintList(
					ctx.getResources().getColorStateList(
						dataList.get(
							position
						).indicatorColor
					)
				);
				holder.tingkatResiko.text = dataList.get(position).tingkatResiko.toString()
				holder.tingkatResiko.setBackgroundTintList(
					ctx.getResources().getColorStateList(
						dataList.get(
							position
						).indicatorColor
					)
				);
				holder.peluncuran.text = dataList.get(position).tanggalPeluncuran.toString()
				holder.peluncuran.setBackgroundTintList(
					ctx.getResources().getColorStateList(
						dataList.get(
							position
						).indicatorColor
					)
				);

				holder.icon.text = dataList.get(position).nama.first().toString();

			}
		}
	}

	override fun getItemCount(): Int {
		return dataList?.size!!
	}

	fun getHeightOfLargestDescription(
		context: Context,
		text: CharSequence?,
		textView: TextView
	): Int {
		val wm = context.getSystemService(Context.WINDOW_SERVICE) as WindowManager
		val displaySize = Point()
		wm.defaultDisplay.getSize(displaySize)
		val deviceWidth: Int = displaySize.x/((dataList?.size?:1)+1)
		textView.setTypeface(Typeface.DEFAULT)
		textView.setText(text, TextView.BufferType.SPANNABLE)
		val widthMeasureSpec =
			View.MeasureSpec.makeMeasureSpec(deviceWidth, View.MeasureSpec.AT_MOST)
		val heightMeasureSpec = View.MeasureSpec.makeMeasureSpec(0, View.MeasureSpec.UNSPECIFIED)
		textView.measure(widthMeasureSpec, heightMeasureSpec)
		return textView.measuredHeight
	}

	fun getIndicatorIcon(iconColor: Int): Int {

		var icon = 0
		when(iconColor){
			R.color.green_light -> {
				icon = R.drawable.circle_indicator_green
			}
			R.color.violet_light -> {
				icon = R.drawable.circle_indicator_violet

			}
			R.color.blue_light -> {
				icon = R.drawable.circle_indicator

			}
		}
		return icon
	}

	inner class IndicatorViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
		 lateinit var icon: TextView
		 lateinit var name: TextView
		lateinit var iconIndicator: ImageView
		lateinit var nameIndicator: TextView
		lateinit var lnName: LinearLayout
		lateinit var jenisReksadana: TextView
		lateinit var imbalHasil: TextView
		lateinit var danaKelolaan: TextView
		lateinit var minPembelian: TextView
		lateinit var jangkaWaktu: TextView
		lateinit var tingkatResiko: TextView
		lateinit var peluncuran: TextView


		 init{

			if(vieww == R.layout.indicator_item) {
				iconIndicator = itemView.findViewById(R.id.iconIndicator)
				nameIndicator = itemView.findViewById(R.id.nameIndicator)
			}
			else if(vieww == R.layout.reksadana_detail_item){
				name = itemView.findViewById(R.id.name)
				icon = itemView.findViewById(R.id.iconLogo)
				lnName = itemView.findViewById(R.id.lnName)
				jenisReksadana = itemView.findViewById(R.id.jenisReksadana)
				imbalHasil = itemView.findViewById(R.id.imbalHasil)
				danaKelolaan = itemView.findViewById(R.id.danaKelolaan)
				minPembelian = itemView.findViewById(R.id.minPembelian)
				jangkaWaktu = itemView.findViewById(R.id.jangkaWaktu)
				tingkatResiko = itemView.findViewById(R.id.tingkatResiko)
				peluncuran = itemView.findViewById(R.id.peluncuran)

			}
		}
	}

	init {
		this.dataList = dataList
		this.vieww = view
		this.ctx = ctx
	}
}
