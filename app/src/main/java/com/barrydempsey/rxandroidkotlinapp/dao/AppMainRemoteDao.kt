package com.barrydempsey.rxandroidkotlinapp.dao

import android.content.Context
import com.barrydempsey.rxandroidkotlinapp.dao.api.AppFlightsService
import com.barrydempsey.rxandroidkotlinapp.model.Flight
import com.barrydempsey.rxandroidkotlinapp.dao.api.FlightsService
import io.reactivex.Observable

class AppMainRemoteDao(private val service: FlightsService): MainRemoteDao {

  override fun retrieveListOfFlights(): Observable<ArrayList<Flight>> {
    return service.getListOfFlightsFromServer()
  }

  companion object {

    @JvmStatic
    fun newInstance(context: Context) = AppMainRemoteDao(
        AppFlightsService(context))

  }

}