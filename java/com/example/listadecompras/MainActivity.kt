package com.example.listadecompras

import android.os.Bundle
import android.widget.*
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    // Declarações das views
    private lateinit var listViewProdutos: ListView
    private lateinit var btnInserir: Button
    private lateinit var txtProduto: EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Inicialização das views usando findViewById
        listViewProdutos = findViewById(R.id.list_view_produtos)
        btnInserir = findViewById(R.id.btn_inserir)
        txtProduto = findViewById(R.id.txt_produto)

        // Criando o adaptador
        val produtosAdapter = ArrayAdapter<String>(
            this,
            android.R.layout.simple_list_item_1,
            mutableListOf()
        )

        // Definindo o adaptador na ListView
        listViewProdutos.adapter = produtosAdapter

        // Ação do botão de inserção
        btnInserir.setOnClickListener {
            val produto = txtProduto.text.toString()
            if (produto.isNotEmpty()) {
                produtosAdapter.add(produto)
                txtProduto.text.clear()
            } else {
                txtProduto.error = "Preencha um valor"
            }
        }

        // Remover item ao pressionar longamente
        listViewProdutos.setOnItemLongClickListener { _, _, position, _ ->
            val item = produtosAdapter.getItem(position)
            produtosAdapter.remove(item)
            true
        }
    }
}
