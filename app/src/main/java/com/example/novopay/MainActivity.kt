package com.example.novopay

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import com.example.novopay.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    companion object {
        lateinit var avAmount: String
        lateinit var avReference: String
        lateinit var avReceiverName: String
        lateinit var avAccountNumber: String
         var status=  "Pending"
    }

    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityMainBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        supportActionBar?.hide()

        val statusArray = resources.getStringArray(R.array.section)
        val arrayAdapter = ArrayAdapter(this, android.R.layout.simple_dropdown_item_1line, statusArray)
        binding.statusSpinner.adapter = arrayAdapter


        binding.statusSpinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
                // Handle the selected item as needed
                when (statusArray[position]) {
                    "Success" -> {
                       status = "Success"
                    }

                    "Pending" -> {
                        status = "Pending"
                    }

                    "Failed" -> {
                        status = "Failed"
                    }
                }
            }

            override fun onNothingSelected(parent: AdapterView<*>?) {
                // Handle the case where nothing is selected
            }
        }

        binding.btnDone.setOnClickListener {


            binding.apply {

                val amountText = amount.text.toString()
                if (amountText.isEmpty()) {
                    binding.amount.error = "Please enter an amount"
                } else {
                    avAmount = amount.text.toString()


                    val refencenumber = referncenceNumbere.text.toString()
                    if (refencenumber.isEmpty()) {
                        binding.referncenceNumbere.error = "enter referncenceNumbere "
                    } else {
                        avReference = referncenceNumbere.text.toString()



                        val reciveivername = receiverName.text.toString()
                        if (reciveivername.isEmpty()) {
                            binding.receiverName.error = "enter receiver Name "
                        } else {
                            avReceiverName = receiverName.text.toString()


                            val acountname = accountNumber.text.toString()
                            if (acountname.isEmpty()) {
                                binding.accountNumber.error = "enter account Number"
                            } else {
                                avAccountNumber = accountNumber.text.toString()

                                startActivity(
                                    Intent(
                                        this@MainActivity,
                                        ScreenShortActivity::class.java
                                    )
                                )
                            }
                        }
                    }
                }
            }
        }
    }

}
