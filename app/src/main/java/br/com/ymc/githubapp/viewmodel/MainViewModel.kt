package br.com.ymc.githubapp.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import br.com.ymc.githubapp.model.DataItem
import br.com.ymc.githubapp.model.RepositorieResponse
import br.com.ymc.githubapp.network.RetrofitRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(private val repository : RetrofitRepository) : ViewModel()
{
    fun getAllRepositoryList() : LiveData<List<DataItem>>
    {
        return repository.getAllData()
    }

    fun makeApiCall()
    {
        repository.makeApiCall("br")
    }
}