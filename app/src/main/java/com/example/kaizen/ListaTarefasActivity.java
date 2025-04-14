package com.example.kaizen;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class ListaTarefasActivity extends AppCompatActivity {

    private EditText editTextNomeTarefa;
    private ListView listViewTarefas;
    private ArrayList<String> tarefas;
    private ArrayAdapter<String> tarefasAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_tarefas);

        // Inicializando os elementos do layout
        editTextNomeTarefa = findViewById(R.id.editTextNomeTarefa);
        listViewTarefas = findViewById(R.id.listViewTarefas);

        // Inicializando a lista de tarefas
        tarefas = new ArrayList<>();

        // Criando o adapter para a lista de tarefas
        tarefasAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, tarefas);
        listViewTarefas.setAdapter(tarefasAdapter);
    }

    // Método chamado quando o botão "Adicionar Tarefa" é pressionado
    public void adicionarTarefa(View view) {
        String nomeTarefa = editTextNomeTarefa.getText().toString().trim();

        if (nomeTarefa.isEmpty()) {
            Toast.makeText(this, "Por favor, insira o nome da tarefa.", Toast.LENGTH_SHORT).show();
        } else {
            // Adicionando a nova tarefa à lista
            tarefas.add(nomeTarefa);

            // Atualizando o adapter para refletir a nova tarefa na lista
            tarefasAdapter.notifyDataSetChanged();

            // Exibindo uma mensagem de sucesso
            Toast.makeText(this, "Tarefa '" + nomeTarefa + "' adicionada com sucesso!", Toast.LENGTH_SHORT).show();

            // Limpar o campo de entrada
            editTextNomeTarefa.setText("");
        }
    }
}
