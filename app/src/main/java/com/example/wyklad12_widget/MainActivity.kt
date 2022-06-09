package com.example.wyklad12_widget

import android.media.AudioAttributes
import android.media.MediaPlayer
import android.media.SoundPool
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.TextView
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_main.imageView2
import kotlinx.android.synthetic.main.new_app_widget.*
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import java.io.IOException
import kotlin.random.Random

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)





        val listUrls = ArrayList<String>()

        CoroutineScope(Dispatchers.IO).launch {
            RetrofitClient.instance
                .getPhotos()
                .await()
                .body()!!.forEach {
                    listUrls.add(it.download_url)
                }

        }

        button3.setOnClickListener{
            Picasso.get().load(listUrls[Random.nextInt(listUrls.size-1)])
                .into(imageView2)
    }





}}