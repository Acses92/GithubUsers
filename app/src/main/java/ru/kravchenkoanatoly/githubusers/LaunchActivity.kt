package ru.kravchenkoanatoly.githubusers

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.navigation.fragment.NavHostFragment
import dagger.hilt.android.AndroidEntryPoint
import ru.kravchenkoanatoly.githubusers.databinding.LaunchActivityBinding

@AndroidEntryPoint
class LaunchActivity : AppCompatActivity() {

    private lateinit var binding: LaunchActivityBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = LaunchActivityBinding.inflate(layoutInflater)
        setContentView(R.layout.launch_activity)
        navigationSetup()
    }

    private fun navigationSetup() {
        val navHostFragment = supportFragmentManager.findFragmentById(R.id.nav_host_fragment) as NavHostFragment
        val navController = navHostFragment.navController
    }
}