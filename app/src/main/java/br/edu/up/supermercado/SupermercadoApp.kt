package com.example.supermercado.ui

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.supermercado.model.Produto
import com.example.supermercado.viewmodel.ProdutoViewModel

@Composable
fun SupermercadoApp(viewModel: ProdutoViewModel) {
    val produtos = viewModel.produtos.collectAsState().value

    Scaffold(
        topBar = {
            TopAppBar(title = { Text("Supermercado") })
        },
        content = { innerPadding ->
            Column(
                modifier = Modifier
                    .padding(innerPadding)
                    .padding(16.dp)
            ) {
                Button(onClick = {  }) {
                    Text("Adicionar Produto")
                }
                Spacer(modifier = Modifier.height(16.dp))
                ProdutoList(produtos)
            }
        }
    )
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TopAppBar(title: @Composable () -> Unit) {
    TopAppBar(
        title = title,
        modifier = Modifier.fillMaxWidth()
    )
}

@Composable
fun ProdutoList(produtos: List<Produto>) {
    Column {
        produtos.forEach { produto ->
            ProdutoItem(produto)
        }
    }
}

@Composable
fun ProdutoItem(produto: Produto) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 4.dp),
        elevation = CardDefaults.cardElevation(4.dp)
    ) {
        Column(Modifier.padding(16.dp)) {
            Text(text = "Nome: ${produto.nome}")
            Text(text = "Preço: R$${produto.preco}")
            Text(text = "Quantidade: ${produto.quantidade}")
        }
    }
}
