package com.vansuita.unityembedandroidapp

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.vansuita.unityembedandroidapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    var isUnityLoaded = false
    private val binding by lazy { ActivityMainBinding.inflate(layoutInflater) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        binding.show.setOnClickListener {
            showUnity()
        }

        binding.unload.setOnClickListener {
            unloadUnity()
        }
    }


    private fun showUnity() {
        isUnityLoaded = true
        val intent = Intent(this, MainUnityActivity::class.java)
        intent.flags = Intent.FLAG_ACTIVITY_REORDER_TO_FRONT
        startActivity(intent)
    }

    private fun unloadUnity() {
        if(isUnityLoaded) {
            val intent = Intent(this, MainUnityActivity::class.java)
            intent.flags = Intent.FLAG_ACTIVITY_REORDER_TO_FRONT
            intent.putExtra("doQuit", true)
            startActivity(intent)
            isUnityLoaded = false
        }
    }

    override fun onBackPressed() {
        finishAffinity()
    }

}