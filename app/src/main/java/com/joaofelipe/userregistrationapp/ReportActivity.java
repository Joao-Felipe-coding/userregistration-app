package com.joaofelipe.userregistrationapp;

// Importações de componentes de UI, inteções e a biblioteca ROOM
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class ReportActivity extends AppCompatActivity {
    private TextView textViewReport;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // Define o layout XML dessa tela de relatório
        setContentView(R.layout.activity_report);
        // Mapeamento do TextView do XML para o java
        textViewReport = findViewById((R.id.textViewReport);
        // Encontra o botão e define o clique para voltar
        Button btnVoltar = findViewById(R.id.btnVoltar);
        // O botão de retorno utilizando expressão lamdda
        btnVoltar.setOnClickListener(v -> voltarParaCadastro());
    }


}
