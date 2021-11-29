package ug.sharma.takeaway.mainvmodel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.core.Observer
import io.reactivex.rxjava3.disposables.Disposable
import io.reactivex.rxjava3.schedulers.Schedulers
import ug.sharma.takeaway.MainUiModel
import ug.sharma.takeaway.model.ResponseDTO
import ug.sharma.takeaway.repo.MainRepo
import java.util.*

class MainVmodel: ViewModel() {

    private  val mainRepo= MainRepo()

    private val mutableLiveData= MutableLiveData<MainUiModel>()

    val liveData: LiveData<MainUiModel> =mutableLiveData

    private lateinit var disposable: Disposable


     fun CallApiByView(page:Int){

        mainRepo.getDataByRepo(page).subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .sorted()
            .subscribe(object : Observer<ResponseDTO>{
                override fun onSubscribe(d: Disposable) {
                    disposable=d
                }

                override fun onNext(t:ResponseDTO) {
                    mutableLiveData.value=MainUiModel.OnSucess(t)
                    Log.d("Umang", "getDataByviewModel:${t.toString()} ")
                }

                override fun onError(e: Throwable) {

                }

                override fun onComplete() {

                }
            } )

    }
}