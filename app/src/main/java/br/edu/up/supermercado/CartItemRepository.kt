package br.edu.up.supermercado.repository

import androidx.lifecycle.LiveData
import br.edu.up.supermercado.data.CartItemDao
import br.edu.up.supermercado.model.CartItem

class CartItemRepository(private val cartItemDao: CartItemDao) {

    val allCartItems: LiveData<List<CartItem>> = cartItemDao.getAllCartItems()

    suspend fun insert(cartItem: CartItem) {
        cartItemDao.insert(cartItem)
    }

    suspend fun update(cartItem: CartItem) {
        cartItemDao.update(cartItem)
    }

    suspend fun delete(cartItem: CartItem) {
        cartItemDao.delete(cartItem)
    }

    suspend fun clearCart() {
        cartItemDao.clearCart()
    }
}
