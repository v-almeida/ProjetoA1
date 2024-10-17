package br.edu.up.supermercado.data

import androidx.room.Database
import androidx.room.RoomDatabase
import br.edu.up.supermercado.model.CartItem
import br.edu.up.supermercado.model.Product

@Database(entities = [Product::class, CartItem::class], version = 1)
abstract class SupermarketDatabase : RoomDatabase() {
    abstract fun productDao(): ProductDao
    abstract fun cartItemDao(): CartItemDao
}
