package com.example.novopay

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import com.example.novopay.databinding.ScreenShortActivityBinding
import kotlin.random.Random

class ScreenShortActivity : AppCompatActivity() {
    private lateinit var binding: ScreenShortActivityBinding

    @SuppressLint("SetTextI18n", "ResourceAsColor", "DiscouragedApi")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ScreenShortActivityBinding.inflate(layoutInflater)
        setContentView(binding.root)

        supportActionBar?.hide()




        val screenshotUri =("")

        var charges = "10"
        if (MainActivity.avAmount.toInt() > 50000) {
            charges = "20"
        }

        val pendingColor = ContextCompat.getColor(this, R.color.pendingColor)
        val failedColor = ContextCompat.getColor(this, R.color.failedColor)

        if(MainActivity.status == "Pending"){
            binding.done.setBackgroundColor(ContextCompat.getColor(this,R.color.buttonPendingColor))
            binding.parentLayout.setBackgroundColor(pendingColor)

            binding.textView.text = "Pending!"
            binding.textView2.text = "Transfer request Pending"
            binding.imageView.setImageResource(R.drawable.baseline_access_time_24)
        }

        if(MainActivity.status == "Failed"){


            binding.textView.text = "Failed!"
            binding.textView2.text = "Transfer request Failed "
            binding.imageView.setImageResource(R.drawable.baseline_close_24)




            binding.done.setBackgroundColor(ContextCompat.getColor(this,R.color.buttonFailedColor))
            binding.parentLayout.setBackgroundColor(failedColor)
        }



        binding.apply {
            tvAmount.text = "₹ " + MainActivity.avAmount
            tvReference.text = MainActivity.avReference
            tvWithdrow.text = "₹ " + Random.nextInt(900)
            tvTotalchang.text = "₹ $charges"
            tvHoldername.text = MainActivity.avReceiverName
            tvAcountnumber.text = MainActivity.avAccountNumber
        }


        binding.done.setOnClickListener {
            val shareIntent = Intent(Intent.ACTION_SEND)
            shareIntent.type = "image/*"
            shareIntent.putExtra(Intent.EXTRA_STREAM, screenshotUri)
            startActivity(Intent.createChooser(shareIntent, "Sharing Screenshot"))
        }
    }
}
