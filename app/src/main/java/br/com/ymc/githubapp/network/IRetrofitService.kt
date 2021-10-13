package br.com.ymc.githubapp.network

import br.com.ymc.githubapp.model.DataItem
import br.com.ymc.githubapp.model.RepositorieResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface IRetrofitService
{
    @GET("repositories")
    fun getData(@Query("q") query : String) : Call<RepositorieResponse>
}