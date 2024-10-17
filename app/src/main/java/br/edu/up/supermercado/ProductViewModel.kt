package br.edu.up.supermercado.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import br.edu.up.supermercado.data.SupermarketDatabase
import br.edu.up.supermercado.model.Product
import br.edu.up.supermercado.repository.ProductRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class ProductViewModel(application: Application) : AndroidViewModel(application) {
    private val repository: ProductRepository
    val allProducts: LiveData<List<Product>>

    init {
        val productDao = SupermarketDatabase.getDatabase(application).productDao()
        repository = ProductRepository(productDao)
        allProducts = repository.allProducts
    }

    fun insert(product: Product) = viewModelScope.launch(Dispatchers.IO) {
        repository.insert(product)
    }

    fun update(product: Product) = viewModelScope.launch(Dispatchers.IO) {
        repository.update(product)
    }

    fun delete(product: Product) = viewModelScope.launch(Dispatchers.IO) {
        repository.delete(product)
    }
}
