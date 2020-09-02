package com.hva.madlevel1task

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.hva.madlevel1task.databinding.ActivityHigherLowerBinding
import kotlinx.android.synthetic.main.activity_higher_lower.*

class HigherLowerActivity : AppCompatActivity() {
    private lateinit var binding: ActivityHigherLowerBinding
    private var currentThrow: Int = 1;
    private var lastThrow: Int = 1;

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHigherLowerBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initViews()
    }

    private fun initViews() {
        binding.higherButton.setOnClickListener { onHigherClick() }
        binding.equalsButton.setOnClickListener { onEqualClick() }
        binding.lowerButton.setOnClickListener { onLowerClick() }

        updateUI()
    }

    private fun updateUI() {
        binding.infoThrow.text = getString(R.string.last_throw, lastThrow)

        when (currentThrow) {
            1 -> binding.IvDice.setImageResource(R.drawable.dice1)
            2 -> binding.IvDice.setImageResource(R.drawable.dice2)
            3 -> binding.IvDice.setImageResource(R.drawable.dice3)
            4 -> binding.IvDice.setImageResource(R.drawable.dice4)
            5 -> binding.IvDice.setImageResource(R.drawable.dice5)
            6 -> binding.IvDice.setImageResource(R.drawable.dice6)
        }
    }

    private fun rollDice() {
        lastThrow = currentThrow
        currentThrow = (1..6).random()
        updateUI()
    }

    private fun onHigherClick() {
        rollDice()

        if (currentThrow > lastThrow) {
            onAnswerCorrect()
        } else {
            onAnswerIncorrect()
        }
    }

    private fun onLowerClick() {
        rollDice()

        if (currentThrow < lastThrow) {
            onAnswerCorrect()
        } else {
            onAnswerIncorrect()
        }
    }

    private fun onEqualClick() {
        rollDice()

        if (currentThrow == lastThrow) {
            onAnswerCorrect()
        } else {
            onAnswerIncorrect()
        }
    }

    private fun onAnswerCorrect() {
        Toast.makeText(this, "Your answer is correct!", Toast.LENGTH_LONG).show()
    }

    private fun onAnswerIncorrect() {
        Toast.makeText(this, "Your answer is incorrect!", Toast.LENGTH_LONG).show()
    }
}