package br.com.ymc.githubapp.database

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import br.com.ymc.githubapp.model.DataItem
import java.util.concurrent.Flow

@Dao
interface AppDao
{
    @Query("Select * from repositories")
    fun getRepositories(): LiveData<List<DataItem>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertRepositories(dataItem : List<DataItem>)

    @Query("DELETE FROM repositories")
    fun deleteAllRecord()
}