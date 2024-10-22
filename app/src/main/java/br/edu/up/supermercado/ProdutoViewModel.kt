package com.example.supermercado.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.supermercado.model.Produto
import com.example.supermercado.repository.ProdutoRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class ProdutoViewModel(private val repository: ProdutoRepository) : ViewModel() {

    private val _produtos = MutableStateFlow<List<Produto>>(emptyList())
    val produtos: StateFlow<List<Produto>> = _produtos

    init {
        getAllProdutos()
    }

    private fun getAllProdutos() {
        viewModelScope.launch {
            repository.allProdutos.collect {
                _produtos.value = it
            }
        }
    }

    fun addProduto(produto: Produto) {
        viewModelScope.launch {
            repository.insert(produto)
        }
    }

    fun updateProduto(produto: Produto) {
        viewModelScope.launch {
            repository.update(produto)
        }
    }

    fun deleteProduto(produto: Produto) {
        viewModelScope.launch {
            repository.delete(produto)
        }
    }
}
