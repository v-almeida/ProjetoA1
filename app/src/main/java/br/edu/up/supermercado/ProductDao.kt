package br.edu.up.supermercado.data

import androidx.lifecycle.LiveData
import androidx.room.*

import br.edu.up.supermercado.model.Product

@Dao
interface ProductDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(product: Product)

    @Query("SELECT * FROM products")
    fun getAllProducts(): LiveData<List<Product>>

    @Update
    suspend fun update(product: Product)

    @Delete
    suspend fun delete(product: Product)
}
