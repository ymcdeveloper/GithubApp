package br.com.ymc.githubapp.database

import android.content.Context
import androidx.room.*
import br.com.ymc.githubapp.model.DataItem
import br.com.ymc.githubapp.model.TypeConverterOwner

@Database(entities = [DataItem::class], version = 2, exportSchema = false)
@TypeConverters(TypeConverterOwner::class)
abstract class AppDatabase : RoomDatabase()
{
    abstract fun appDao() : AppDao

    companion object
    {
        @Volatile
        private var INSTANCE : AppDatabase? = null

        fun getDBInstance(context: Context) : AppDatabase
        {
            if(INSTANCE == null)
            {
                INSTANCE = Room.databaseBuilder(context.applicationContext, AppDatabase::class.java, "githubdb.sqlite")
                    .allowMainThreadQueries()
                    .fallbackToDestructiveMigration()
                    .build()
            }

            return INSTANCE!!
        }
    }
}