package com.syukron.dinopedia

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.ContactsContract
import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions

class DetailActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)
        val actionBar = supportActionBar
        actionBar!!.title = "Detail Dinosaurus"
        actionBar.setDisplayHomeAsUpEnabled(true)


        val detailPicture: ImageView = findViewById(R.id.img_detailPicture)
        val tvdetailName: TextView = findViewById(R.id.tv_detailName)
        val tvdetailInfo: TextView = findViewById(R.id.tv_detailInfo)

        val txImg = intent.getIntExtra(EXTRA_PHOTO,0)
        val txName = intent.getStringExtra(EXTRA_NAME)
        val txInfo = intent.getStringExtra(EXTRA_INFO)


        tvdetailName.text = txName
        Glide.with(this)
            .load(txImg)
            .apply(RequestOptions().override(500,500))
            .into(detailPicture)
        tvdetailInfo.text = txInfo

    }

    companion object {
        const val EXTRA_PHOTO = "extra_photo"
        const val EXTRA_NAME = "extra_name"
        const val EXTRA_INFO = "extra_info"

    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true

    }
}