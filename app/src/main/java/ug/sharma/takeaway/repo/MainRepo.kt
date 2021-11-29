package ug.sharma.takeaway.repo

import android.util.Log
import io.reactivex.rxjava3.core.Observable
import ug.sharma.takeaway.model.ResponseDTO
import ug.sharma.takeaway.network.network

class MainRepo {

     fun getDataByRepo(page:Int): Observable<ResponseDTO> {
        Log.d("Umang", "getDataByRepo:${network.getDataByNetwork().getdata(page)} ")
        return network.getDataByNetwork().getdata(page)
    }

}