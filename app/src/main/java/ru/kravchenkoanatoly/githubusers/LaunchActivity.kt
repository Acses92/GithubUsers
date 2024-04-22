package ru.kravchenkoanatoly.githubusers

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.navigation.fragment.NavHostFragment
import dagger.hilt.android.AndroidEntryPoint
import ru.kravchenkoanatoly.githubusers.databinding.LaunchActivityBinding

@AndroidEntryPoint
class LaunchActivity : AppCompatActivity() {
    private val viewModel by viewModels<LaunchViewModel>()

    private lateinit var binding: LaunchActivityBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = LaunchActivityBinding.inflate(layoutInflater)
        setContentView(R.layout.launch_activity)
        navigationSetup()
        getUserInfo()
    }

    private fun getUserInfo(){
        viewModel.getUserInfo()
        viewModel.getUserListSearch()
        //viewModel.getUserFollowers()
    }

    private fun navigationSetup() {
        val navHostFragment = supportFragmentManager.findFragmentById(R.id.nav_host_fragment) as NavHostFragment
        val navController = navHostFragment.navController
    }
}