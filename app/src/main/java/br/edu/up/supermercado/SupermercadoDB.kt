package com.example.supermercado.data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.supermercado.model.Produto

@Database(entities = [Produto::class], version = 1, exportSchema = false)
abstract class SupermercadoDB : RoomDatabase() {

    abstract fun produtoDao(): ProdutoDao

    companion object {
        @Volatile
        private var INSTANCE: SupermercadoDB? = null

        fun getDatabase(context: Context): SupermercadoDB {
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    SupermercadoDB::class.java,
                    "supermercado_database"
                ).build()
                INSTANCE = instance
                instance
            }
        }
    }
}
