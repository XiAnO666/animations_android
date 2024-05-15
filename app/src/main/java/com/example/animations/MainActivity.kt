package com.example.animations

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.animation.AlphaAnimation
import android.view.animation.RotateAnimation
import android.view.animation.ScaleAnimation
import android.view.animation.TranslateAnimation
import android.view.View
import android.view.animation.Animation
import com.example.animations.databinding.ActivityMainBinding
import android.os.Handler
import android.os.Looper

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private var progressStatus = 0
    private val handler = Handler(Looper.getMainLooper())

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        binding.button.setOnClickListener {
            val fadeOut = AlphaAnimation(1.0f, 0.0f)
            fadeOut.duration = 1000
            binding.textView.startAnimation(fadeOut)
        }

        binding.buttonFadeIn.setOnClickListener {
            val fadeIn = AlphaAnimation(0.0f, 1.0f)
            fadeIn.duration = 1000
            binding.textView2.startAnimation(fadeIn)
            binding.textView2.visibility = View.VISIBLE
        }

        binding.buttonRotate.setOnClickListener {
            val rotateAnimation = RotateAnimation(
                0f,
                360f,
                Animation.RELATIVE_TO_SELF,
                0.5f,
                Animation.RELATIVE_TO_SELF,
                0.5f
            )
            rotateAnimation.duration = 10000
            rotateAnimation.repeatCount = 2
            binding.viniloImageView.startAnimation(rotateAnimation)
        }

        binding.buttonScale.setOnClickListener {
            val scaleAnimation = ScaleAnimation(
                1.0f, 1.3f, // Escala en el eje X de 1.0 a 1.3
                1.0f, 1.3f, // Escala en el eje Y de 1.0 a 1.3
                Animation.RELATIVE_TO_SELF, 0.5f, // Pivote X en el centro
                Animation.RELATIVE_TO_SELF, 0.5f  // Pivote Y en el centro
            )
            scaleAnimation.duration = 1000 // Duración de la animación
            scaleAnimation.repeatCount = 3 // Repetir la animación una vez (total de 2 veces)
            binding.heartImageView.startAnimation(scaleAnimation) // Iniciar la animación
        }

        binding.buttonTranslate.setOnClickListener {
            // Inicia la carga de la ProgressBar
           Thread(Runnable {
               binding.progressBar.progress = 100
                /*while (progressStatus < 100) {
                    progressStatus += 1
                    // Actualiza la ProgressBar y muestra el progreso actual
                    handler.post {
                        binding.progressBar.progress = progressStatus
                    }
                    try {
                        // Duerme el hilo durante 20 milisegundos
                        Thread.sleep(20)
                    } catch (e: InterruptedException) {
                        e.printStackTrace()
                    }
                }*/
            }).start()

            // Inicia la animación de traslación

            val translateAnimation = TranslateAnimation(
                0f, // Desplazamiento inicial en X
                binding.progressBar.width.toFloat(), // Desplazamiento final en X
                0f, // Desplazamiento inicial en Y
                0f  // Desplazamiento final en Y
            )
            translateAnimation.duration = 2000 // Duración de la animación
            binding.overlayView.startAnimation(translateAnimation) // Iniciar la animación
        }
    }
}
