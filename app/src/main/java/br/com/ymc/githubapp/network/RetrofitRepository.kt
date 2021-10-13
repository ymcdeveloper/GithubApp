package br.com.ymc.githubapp.network

import br.com.ymc.githubapp.database.AppDao
import br.com.ymc.githubapp.model.DataItem
import br.com.ymc.githubapp.model.RepositorieResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import javax.inject.Inject

class RetrofitRepository @Inject constructor(private val retrofitServiceInteface : IRetrofitService, private val appDao: AppDao)
{
    fun getAllData() = appDao.getRepositories()

    fun insertRecord(dataItem: List<DataItem>)
    {
        appDao.insertRepositories(dataItem)
    }

    fun makeApiCall(query: String?)
    {
        val call: Call<RepositorieResponse> = retrofitServiceInteface.getData(query!!)
        call?.enqueue(object : Callback<RepositorieResponse>
        {
            override fun onResponse(call: Call<RepositorieResponse>, response: Response<RepositorieResponse>)
            {
                if(response.isSuccessful)
                {
                    appDao.deleteAllRecord()
                    insertRecord(response.body()?.items!!)
                }
            }

            override fun onFailure(call: Call<RepositorieResponse>, t: Throwable)
            {

            }
        })

    }
}
