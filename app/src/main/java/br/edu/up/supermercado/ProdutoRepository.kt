package com.example.supermercado.repository

import com.example.supermercado.data.ProdutoDao
import com.example.supermercado.model.Produto
import kotlinx.coroutines.flow.Flow

class ProdutoRepository(private val produtoDao: ProdutoDao) {

    val allProdutos: Flow<List<Produto>> = produtoDao.getAllProdutos()

    suspend fun insert(produto: Produto) {
        produtoDao.insertProduto(produto)
    }

    suspend fun update(produto: Produto) {
        produtoDao.updateProduto(produto)
    }

    suspend fun delete(produto: Produto) {
        produtoDao.deleteProduto(produto)
    }
}
