package br.com.luanadev.marte.database




import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface MarsDao {
    @Query("select * from marspropertyentities")
    fun getProperties(): LiveData<List<MarsPropertyEntities>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAll(marsPropertyEntities: List<MarsPropertyEntities>)
}


