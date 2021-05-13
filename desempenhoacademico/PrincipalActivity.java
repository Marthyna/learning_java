package com.example.aluno.desempenhoacademico;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class PrincipalActivity extends AppCompatActivity {

    TextView tvMensagem;
    Button bCadastro, bRelatorios;
    static final int CADASTRO_CODIGO = 1;
    static final int RELATORIO_CODIGO = 2;
    String nomeMaiorMain = "";
    float maiorNotaMain = 0;
    int qtAprovadosInfoMain=0, qtAprovadosRefriMain=0, qtReprovadosInfoMain=0, qtReprovadosRefriMain = 0, cursoMaiorMain=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_principal);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        tvMensagem = findViewById(R.id.tvMensagem);
        bCadastro = findViewById(R.id.bCadastro);
        bRelatorios = findViewById(R.id.bRelatorios);

        bCadastro.setOnClickListener(trataClique);
        bRelatorios.setOnClickListener(trataClique);

        Toast.makeText(this, "Marthyna, seja bem vinda.", Toast.LENGTH_SHORT).show();
    }
    View.OnClickListener trataClique = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
         if(v.getId() == bCadastro.getId()){
            Intent it = new Intent(PrincipalActivity.this, CadastroActivity.class);
            startActivityForResult(it,CADASTRO_CODIGO);
         }else if(v.getId() == bRelatorios.getId()){
             Intent it = new Intent(PrincipalActivity.this, RelatorioActivity.class);

             Bundle parametros = new Bundle();
             parametros.putInt("qtAprovadosInfo",qtAprovadosInfoMain);
             parametros.putInt("qtAprovadosRefri",qtAprovadosRefriMain);
             parametros.putInt("qtReprovadosInfo",qtReprovadosInfoMain);
             parametros.putInt("qtReprovadosRefri",qtReprovadosRefriMain);

             it.putExtras(parametros);

             startActivityForResult(it,RELATORIO_CODIGO);
         }
        }
    };

    protected void onActivityResult(int codigo, int resultado, Intent it){
        if(codigo == CADASTRO_CODIGO){
            if(it != null){
                nomeMaiorMain = it.getStringExtra("nomeMaior");
                maiorNotaMain = it.getFloatExtra("maiorNota",0);
                qtAprovadosInfoMain = it.getIntExtra("qtAprovadosInfo",0);
                qtAprovadosRefriMain = it.getIntExtra("qtAprovadosRefri",0);
                qtReprovadosInfoMain = it.getIntExtra("qtReprovadosInfo",0);
                qtReprovadosRefriMain = it.getIntExtra("qtReprovadosRefri",0);
                cursoMaiorMain = it.getIntExtra("cursoMaior",0);
            }
        }
    }

}
