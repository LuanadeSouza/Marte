package br.com.luanadev.marte.database

import android.arch.persistence.room.Database
import android.arch.persistence.room.Room
import android.arch.persistence.room.RoomDatabase
import android.content.Context

@Database(entities = [MarsPropertyEntities::class], version = 1)
abstract class MarsDatabase : RoomDatabase() {

    companion object {
        private var INSTANCE: MarsDatabase? = null

        @Synchronized
        fun getDatabase(context: Context): MarsDatabase {
            synchronized(MarsDatabase::class.java) {
                if (INSTANCE == null) {
                    INSTANCE = Room.databaseBuilder(
                        context,
                        MarsDatabase::class.java,
                        "marsProperties.db"
                    ).build()
                }
            }
            return INSTANCE!!
        }
    }

    abstract val marsDao: MarsDao
}