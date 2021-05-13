package com.example.aluno.desempenhoacademico;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.Toast;

public class RelatorioActivity extends AppCompatActivity {

    InfosApp infosApp;
    CheckBox cbQtAprovadosCurso, cbQtReprovadosCurso, cbMaiorNota;
    Button bVerificar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_relatorio);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        cbMaiorNota = findViewById(R.id.cbMaiorNota);
        cbQtAprovadosCurso = findViewById(R.id.cbQtAprovadosCurso);
        cbQtReprovadosCurso = findViewById(R.id.cbQtReprovadosCurso);
        bVerificar = findViewById(R.id.bVerificar);

        bVerificar.setOnClickListener(trataClique);

        infosApp = (InfosApp)getApplicationContext();
    }

    View.OnClickListener trataClique = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            if(view.getId() == bVerificar.getId()){
                int qtAprovadosInfo=0, qtAprovadosRefri=0, qtReprovadosRefri = 0, qtReprovadosInfo = 0;
                float maiorNota = Float.MIN_VALUE;
                String nomeMaior = "", cursoMaiorLiteral = "";
                int cursoMaior = 0;

                Intent it = getIntent();
                if(it != null){
                    Bundle parametrosRecebidos = it.getExtras();
                    qtAprovadosInfo = parametrosRecebidos.getInt("qtAprovadosInfo");
                    qtAprovadosRefri = parametrosRecebidos.getInt("qtAprovadosRefri");
                    qtReprovadosRefri =  parametrosRecebidos.getInt("qtReprovadosRefri");
                    qtReprovadosInfo =  parametrosRecebidos.getInt("qtReprovadosInfo");

                    setResult(1,it);

                    finish();
                }

                for(int x=0; x<infosApp.getListaAlunos().size(); x++){
                    Aluno meuAluno = infosApp.getListaAlunos().get(x);
                    if(meuAluno.getMedia() > maiorNota){
                        maiorNota = meuAluno.getMedia();
                        nomeMaior = meuAluno.getNome();
                        cursoMaior = meuAluno.getCurso();
                    }
                    if(meuAluno.getMedia() >= 6 && meuAluno.getFrequencia() >= 75){
                        if(meuAluno.getCurso() == 1){
                            qtAprovadosInfo++;
                        }else if(meuAluno.getCurso() == 2){
                            qtAprovadosRefri++;
                        }
                    }else{
                        if(meuAluno.getCurso() == 1){
                            qtReprovadosInfo++;
                        }else if(meuAluno.getCurso() == 2){
                            qtReprovadosRefri++;
                        }
                    }
                }

                if(cursoMaior==1){
                    cursoMaiorLiteral = "Informática";
                }else if(cursoMaior==2){
                    cursoMaiorLiteral = "Refrigeração";
                }
                if(cbQtAprovadosCurso.isChecked()){
                    Toast.makeText(RelatorioActivity.this, "Total de aprovados em informática: "+qtAprovadosInfo+" alunos \n Total de aprovados em regrigeração: "+qtAprovadosRefri+" alunos", Toast.LENGTH_SHORT).show();
                }
                if(cbQtReprovadosCurso.isChecked()){
                    Toast.makeText(RelatorioActivity.this, "Total de reprovados em informática: "+qtReprovadosInfo+" alunos \n Total de reprovados em regrigeração: "+qtReprovadosRefri+" alunos", Toast.LENGTH_SHORT).show();
                }
                if(cbMaiorNota.isChecked()){
                    Toast.makeText(RelatorioActivity.this, "ALUNO DE MAIOR NOTA: "+nomeMaior+", do curso de "+cursoMaiorLiteral, Toast.LENGTH_SHORT).show();
                }
            }
        }
    };
}
