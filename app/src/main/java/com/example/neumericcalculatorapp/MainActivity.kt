package com.example.neumericcalculatorapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.core.widget.addTextChangedListener
import com.example.neumericcalculatorapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.binaryNumber.addTextChangedListener {
            if (binding.binaryNumber.isFocused) {
                val binaryNumber = it.toString()
                if (binaryNumber.isEmpty()) {
                    binding.decimalNumber.setText("")
                    binding.octalNumber.setText("")
                    binding.hexNumber.setText("")
                } else if (isBinaryNumber(binaryNumber)) {

                    binding.decimalNumber.setText(fromBinaryToDecimal(binaryNumber))
                    binding.octalNumber.setText(fromBinaryToOctal(binaryNumber))
                    binding.hexNumber.setText(fromBinaryToHex(binaryNumber))
                } else {
                    Toast.makeText(
                        applicationContext,
                        "enter binary numbers only",
                        Toast.LENGTH_SHORT
                    ).show()
                }
            }
        }

        binding.decimalNumber.addTextChangedListener {

            if (binding.decimalNumber.isFocused) {
                if (binding.decimalNumber.text.isEmpty()) {
                    binding.binaryNumber.setText("")
                    binding.octalNumber.setText("")
                    binding.hexNumber.setText("")
                } else {
                    val decimalNumber = it.toString()
                    binding.binaryNumber.setText(fromDecimalToBinary(decimalNumber))
                    binding.octalNumber.setText(fromDecimalToOctal(decimalNumber))
                    binding.hexNumber.setText(fromDecimalToHex(decimalNumber))
                }
            }
        }

        binding.octalNumber.addTextChangedListener {
            if (binding.octalNumber.isFocused) {
                val octalNumber = it.toString()
                if (binding.octalNumber.text.isEmpty()) {
                    binding.binaryNumber.setText("")
                    binding.decimalNumber.setText("")
                    binding.hexNumber.setText("")
                } else if (isOctalNumber(octalNumber)) {
                    binding.binaryNumber.setText(fromOctalToBinary(octalNumber))
                    binding.decimalNumber.setText(fromOctalToDecimal(octalNumber))
                    binding.hexNumber.setText(fromOctalToHex(octalNumber))
                } else {
                    Toast.makeText(
                        applicationContext,
                        "octal number between 0 and 7",
                        Toast.LENGTH_SHORT
                    ).show()
                }
            }
        }

        binding.hexNumber.addTextChangedListener {
            if (binding.hexNumber.isFocused) {
                if (binding.hexNumber.text.isEmpty()) {
                    binding.binaryNumber.setText("")
                    binding.decimalNumber.setText("")
                    binding.octalNumber.setText("")
                } else {
                    val hexNumber = it.toString()
                    binding.binaryNumber.setText(fromHexToBinary(hexNumber))
                    binding.decimalNumber.setText(fromHexToDecimal(hexNumber))
                    binding.octalNumber.setText(fromHexToOctal(hexNumber))
                }
            }
        }

        binding.clear.setOnClickListener {
            binding.binaryNumber.setText("")
            binding.decimalNumber.setText("")
            binding.octalNumber.setText("")
            binding.hexNumber.setText("")
        }
    }

    private fun fromBinaryToDecimal(binaryNumber: String): String {
        return binaryNumber.toInt(2).toString(10)
    }

    private fun fromBinaryToOctal(binaryNumber: String): String {
        return binaryNumber.toInt(2).toString(8)
    }

    private fun fromBinaryToHex(binaryNumber: String): String {
        return binaryNumber.toInt(2).toString(16)
    }

    private fun fromDecimalToBinary(decimalNumber: String): String {
        return decimalNumber.toInt(10).toString(2)

    }

    private fun fromDecimalToOctal(decimalNumber: String): String {
        return decimalNumber.toInt(10).toString(8)
    }

    private fun fromDecimalToHex(decimalNumber: String): String {
        return decimalNumber.toInt(10).toString(16)
    }

    private fun fromOctalToBinary(octalNumber: String): String {
        return octalNumber.toInt(8).toString(2)
    }

    private fun fromOctalToDecimal(octalNumber: String): String {
        return octalNumber.toInt(8).toString()
    }

    private fun fromOctalToHex(octalNumber: String): String {

        return octalNumber.toInt(8).toString(16)
    }

    private fun fromHexToBinary(HexNumber: String): String {
        return HexNumber.toInt(16).toString(2)
    }

    private fun fromHexToDecimal(HexNumber: String): String {
        return HexNumber.toInt(16).toString()
    }

    private fun fromHexToOctal(HexNumber: String): String {
        return HexNumber.toInt(16).toString(8)
    }

    private fun isBinaryNumber(binaryNumber: String): Boolean {
        for (i in binaryNumber) {
            if (i != '0' && i != '1') {
                return false
            }
        }
        return true
    }

    private fun isOctalNumber(octalNumber: String): Boolean {
        for (i in octalNumber) {
            if (i !in '0'..'7') {
                return false
            }
        }
        return true
    }

}

