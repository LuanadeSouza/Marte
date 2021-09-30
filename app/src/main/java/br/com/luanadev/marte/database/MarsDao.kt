package br.com.luanadev.marte.database

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface MarsDao {
    @Query("select * from marsentities")
    fun getProperties(): LiveData<List<MarsEntities>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAll(marsEntities: List<MarsEntities>)
}


