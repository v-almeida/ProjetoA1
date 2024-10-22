package br.edu.up.supermercado

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import com.example.supermercado.data.SupermercadoDB
import com.example.supermercado.repository.ProdutoRepository
import com.example.supermercado.ui.SupermercadoApp
import com.example.supermercado.viewmodel.ProdutoViewModel

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val database = SupermercadoDB.getDatabase(this)
        val repository = ProdutoRepository(database.produtoDao())

        val viewModel: ProdutoViewModel by viewModels {
            ProdutoViewModel(repository)
        }

        setContent {
            SupermercadoApp(viewModel)
        }
    }
}
