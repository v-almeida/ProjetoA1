package com.example.supermercado.data

import androidx.room.*
import com.example.supermercado.model.Produto
import kotlinx.coroutines.flow.Flow

@Dao
interface ProdutoDao {

    @Query("SELECT * FROM produtos ORDER BY nome ASC")
    fun getAllProdutos(): Flow<List<Produto>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertProduto(produto: Produto)

    @Update
    suspend fun updateProduto(produto: Produto)

    @Delete
    suspend fun deleteProduto(produto: Produto)
}
