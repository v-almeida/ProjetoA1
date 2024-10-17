package br.edu.up.supermercado.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import br.edu.up.supermercado.data.SupermarketDatabase
import br.edu.up.supermercado.model.CartItem
import br.edu.up.supermercado.repository.CartItemRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class CartViewModel(application: Application) : AndroidViewModel(application) {

    private val repository: CartItemRepository
    val allCartItems: LiveData<List<CartItem>>

    init {
        val cartItemDao = SupermarketDatabase.getDatabase(application).cartItemDao()
        repository = CartItemRepository(cartItemDao)
        allCartItems = repository.allCartItems
    }

    fun insert(cartItem: CartItem) = viewModelScope.launch(Dispatchers.IO) {
        repository.insert(cartItem)
    }

    fun clearCart() = viewModelScope.launch(Dispatchers.IO) {
        repository.clearCart()
    }
}
