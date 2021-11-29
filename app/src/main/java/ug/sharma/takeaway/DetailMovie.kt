package ug.sharma.takeaway

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import com.bumptech.glide.Glide
import ug.sharma.takeaway.databinding.ActivityDetailMovieBinding


class DetailMovie : AppCompatActivity() {
    private lateinit var detailMovieBinding: ActivityDetailMovieBinding



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        detailMovieBinding = DataBindingUtil.setContentView(this,R.layout.activity_detail_movie)


        val imag=intent.getStringExtra("imag")
        val name=intent.getStringExtra("name")
        val gender=intent.getStringExtra("gender")
        val url=intent.getStringExtra("url")
        val birth=intent.getStringExtra("birth")

        if(imag!=null) {
            Glide.with(detailMovieBinding.BigImg).load(imag).into(detailMovieBinding.BigImg)
        }else{
            Toast.makeText(this,"Image is Not Available",Toast.LENGTH_SHORT).show()
        }

        detailMovieBinding.namee.text=name.toString()
        if(gender==null){
            detailMovieBinding.gender.text="Not Available"
        }else{
            detailMovieBinding.gender.text=gender.toString()
        }

        if(birth==null){
            detailMovieBinding.birthday.text="Not Available"
        }else{
            detailMovieBinding.birthday.text=birth.toString()
        }

        detailMovieBinding.url.text=url.toString()



        webview()


    }

    private fun webview() {
        val url=intent.getStringExtra("url")
        detailMovieBinding.url.setOnClickListener {
            Intent(Intent.ACTION_VIEW, Uri.parse(url)).apply {
                startActivity(this)
            }
        }
    }
}