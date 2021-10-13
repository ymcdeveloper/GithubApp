package br.com.ymc.githubapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import br.com.ymc.githubapp.adapter.MainAdapter
import br.com.ymc.githubapp.databinding.ActivityMainBinding
import br.com.ymc.githubapp.viewmodel.MainViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity()
{
    private lateinit var binding: ActivityMainBinding

    private val viewModel : MainViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        viewModel.getAllRepositoryList().observe(this, { arrData ->
            binding.rcvData.apply{
                layoutManager = LinearLayoutManager(this@MainActivity)
                adapter = MainAdapter(arrData)
            }
        })

        viewModel.makeApiCall()


    }
}