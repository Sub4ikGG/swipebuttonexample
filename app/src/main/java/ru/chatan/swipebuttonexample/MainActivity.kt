package ru.chatan.swipebuttonexample

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.core.view.WindowCompat
import ru.chatan.swipebutton.SwipeButton
import ru.chatan.swipebuttonexample.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private var _binding: ActivityMainBinding? = null
    private val binding get() = _binding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        _binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        WindowCompat.setDecorFitsSystemWindows(window, false)
    }

    override fun onStart() {
        super.onStart()

        binding.swipeButton.setListener(
            object : SwipeButton.OnSwipeButtonListener {
                override fun onSwiped() {
                    binding.swipeButton.setText(text = "SWIPED!")
                }
            }
        )

        binding.swipeReloadButton.setOnClickListener {
            binding.swipeButton.reload(setDefaultText = true)
        }
    }

    override fun onDestroy() {
        super.onDestroy()

        _binding = null
    }
}