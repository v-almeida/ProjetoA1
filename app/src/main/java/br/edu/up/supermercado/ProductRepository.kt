package br.edu.up.supermercado.repository

import androidx.lifecycle.LiveData
import br.edu.up.supermercado.data.ProductDao
import br.edu.up.supermercado.model.Product

class ProductRepository(private val productDao: ProductDao) {

    val allProducts: LiveData<List<Product>> = productDao.getAllProducts()

    suspend fun insert(product: Product) {
        productDao.insert(product)
    }

    suspend fun update(product: Product) {
        productDao.update(product)
    }

    suspend fun delete(product: Product) {
        productDao.delete(product)
    }
}
