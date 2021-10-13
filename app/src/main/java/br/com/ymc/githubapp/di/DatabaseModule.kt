package br.com.ymc.githubapp.di

import android.content.Context
import br.com.ymc.githubapp.database.AppDao
import br.com.ymc.githubapp.database.AppDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class DatabaseModule
{
    @Provides
    @Singleton
    fun getAppDatabase(@ApplicationContext context: Context) : AppDatabase
    {
        return AppDatabase.getDBInstance(context)
    }

    @Provides
    fun getAppDao(appDatabase: AppDatabase) : AppDao
    {
        return appDatabase.appDao()
    }

}