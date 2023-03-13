package com.example.neumericcalculatorapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.widget.addTextChangedListener
import com.example.neumericcalculatorapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.edBinaryNumber.addTextChangedListener {
            val binaryNumber = it.toString()
            if (binding.edBinaryNumber.isFocused) {
                if (binaryNumber.isEmpty()) {
                    checkBinaryIsEmpty()
                } else {
                    binding.edDecimalNumber.setText(fromBinaryToDecimal(binaryNumber))
                    binding.edOctalNumber.setText(fromBinaryToOctal(binaryNumber))
                    binding.edHexNumber.setText(fromBinaryToHex(binaryNumber))
                }
            }
        }

        binding.edDecimalNumber.addTextChangedListener {

            if (binding.edDecimalNumber.isFocused) {
                if (binding.edDecimalNumber.text.isEmpty()) {
                    checkDecimalIsEmpty()
                } else {
                    val decimalNumber = it.toString()
                    binding.edBinaryNumber.setText(fromDecimalToBinary(decimalNumber))
                    binding.edOctalNumber.setText(fromDecimalToOctal(decimalNumber))
                    binding.edHexNumber.setText(fromDecimalToHex(decimalNumber))
                }
            }
        }

        binding.edOctalNumber.addTextChangedListener {
            if (binding.edOctalNumber.isFocused) {
                val edOctalNumber = it.toString()
                if (binding.edOctalNumber.text.isEmpty()) {
                    checkOctalIsEmpty()
                } else {
                    binding.edBinaryNumber.setText(fromOctalToBinary(edOctalNumber))
                    binding.edDecimalNumber.setText(fromOctalToDecimal(edOctalNumber))
                    binding.edHexNumber.setText(fromOctalToHex(edOctalNumber))
                }
            }
        }

        binding.edHexNumber.addTextChangedListener {
            if (binding.edHexNumber.isFocused) {
                if (binding.edHexNumber.text.isEmpty()) {
                    checkHexDecimalIsEmpty()
                } else {
                    val edHexNumber = it.toString()
                    binding.edBinaryNumber.setText(fromHexToBinary(edHexNumber))
                    binding.edDecimalNumber.setText(fromHexToDecimal(edHexNumber))
                    binding.edOctalNumber.setText(fromHexToOctal(edHexNumber))
                }
            }
        }

        binding.clear.setOnClickListener {
            binding.edBinaryNumber.text.clear()
            binding.edDecimalNumber.text.clear()
            binding.edOctalNumber.text.clear()
            binding.edHexNumber.text.clear()
        }
    }


    private fun fromBinaryToDecimal(binaryNumber: String): String {
        return binaryNumber.toLong(2).toString(10)
    }

    private fun fromBinaryToOctal(binaryNumber: String): String {
        return binaryNumber.toLong(2).toString(8)
    }

    private fun fromBinaryToHex(binaryNumber: String): String {
        return binaryNumber.toLong(2).toString(16)
    }

    private fun fromDecimalToBinary(decimalNumber: String): String {
        return decimalNumber.toLong(10).toString(2)

    }


    private fun fromDecimalToOctal(decimalNumber: String): String {
        return decimalNumber.toLong(10).toString(8)
    }

    private fun fromDecimalToHex(decimalNumber: String): String {
        return decimalNumber.toLong(10).toString(16)
    }

    private fun fromOctalToBinary(edOctalNumber: String): String {
        return edOctalNumber.toLong(8).toString(2)
    }

    private fun fromOctalToDecimal(edOctalNumber: String): String {
        return edOctalNumber.toLong(8).toString()
    }

    private fun fromOctalToHex(edOctalNumber: String): String {

        return edOctalNumber.toLong(8).toString(16)
    }

    private fun fromHexToBinary(edHexNumber: String): String {
        return edHexNumber.toLong(16).toString(2)
    }

    private fun fromHexToDecimal(edHexNumber: String): String {
        return edHexNumber.toLong(16).toString()
    }

    private fun fromHexToOctal(edHexNumber: String): String {
        return edHexNumber.toLong(16).toString(8)
    }

    private fun checkDecimalIsEmpty() {
        binding.edBinaryNumber.setText("")
        binding.edOctalNumber.setText("")
        binding.edHexNumber.setText("")
    }

    private fun checkBinaryIsEmpty() {
        binding.edDecimalNumber.setText("")
        binding.edOctalNumber.setText("")
        binding.edHexNumber.setText("")
    }

    private fun checkOctalIsEmpty() {
        binding.edBinaryNumber.setText("")
        binding.edDecimalNumber.setText("")
        binding.edHexNumber.setText("")
    }

    private fun checkHexDecimalIsEmpty() {
        binding.edBinaryNumber.setText("")
        binding.edDecimalNumber.setText("")
        binding.edOctalNumber.setText("")
    }

}

