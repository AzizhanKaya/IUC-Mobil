package com.iuc_mobil.app

import android.os.Bundle
import androidx.core.view.WindowCompat

class MainActivity : TauriActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Bu modern ve doğru yöntemdir.
        // Uygulamanın sistem çubuklarının arkasına çizilmesini sağlar.
        WindowCompat.setDecorFitsSystemWindows(window, false)
    }
}
