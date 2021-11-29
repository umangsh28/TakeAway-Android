package ug.sharma.takeaway

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.util.Log
import android.widget.Button
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout
import ug.sharma.takeaway.databinding.ActivityMainBinding
import ug.sharma.takeaway.interfacee.OnItemClick
import ug.sharma.takeaway.mainvmodel.MainVmodel
import ug.sharma.takeaway.model.ResponseDTOItem
import ug.sharma.takeaway.recycler.VAdapter
import android.widget.Switch
import okhttp3.internal.notifyAll
import java.util.*
import kotlin.Comparator


class MainActivity : AppCompatActivity(), OnItemClick {

    private lateinit var activityMainBinding: ActivityMainBinding

    private lateinit var mainViewModel: MainVmodel

    private lateinit var viewAdapter: VAdapter

    private var list = emptyList<ResponseDTOItem>()

    var page = 1

    private var ascending = false


    private var gridLayoutManager: GridLayoutManager? = null

    private var swipeRefreshLayout: SwipeRefreshLayout? = null



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        activityMainBinding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        swipeRefreshLayout = activityMainBinding.swipeLayout



        initializeRefreshListener()


        callapi()



    }


    @SuppressLint("NotifyDataSetChanged")
    private fun callapi() {
        mainViewModel = ViewModelProvider(this).get(MainVmodel::class.java)

        mainViewModel.CallApiByView(page)

        mainViewModel.liveData.observe(this, {
            when (it) {
                is MainUiModel.OnSucess -> {
                    list = it.responseDTO
                    setRecycler()

                }
                is MainUiModel.Onerror -> {
                    Log.d("umang", "error == ${it.error}")
                }
            }
            viewAdapter.notifyDataSetChanged()

        })
    }






    private fun setRecycler() {

        //sort by update
        viewAdapter = VAdapter(list.sortedBy { it.updated }, this)
        gridLayoutManager = GridLayoutManager(this, 2)
        Log.d("umang", gridLayoutManager.toString())
        activityMainBinding.recycler.adapter = viewAdapter
        activityMainBinding.recycler.layoutManager = gridLayoutManager

    }


    fun initializeRefreshListener() {
        swipeRefreshLayout!!.setOnRefreshListener { // This method gets called when user pull for refresh,

            callapi()

            val handler = Handler()
            handler.postDelayed(Runnable {
                if (swipeRefreshLayout!!.isRefreshing) {
                    swipeRefreshLayout!!.isRefreshing = false
                }
            }, 1000)
        }
    }

    override fun OnPicClick(result: ResponseDTOItem) {
        //sending data to second activity
        val i = Intent(this, DetailMovie::class.java)
        i.putExtra("imag", result.image.medium)
        i.putExtra("name", result.name)
        i.putExtra("birth", result.birthday)
        i.putExtra("gender", result.gender)
        i.putExtra("url", result.url)
        startActivity(i)
    }


}