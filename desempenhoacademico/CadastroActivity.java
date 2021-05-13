package com.example.aluno.desempenhoacademico;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

public class CadastroActivity extends AppCompatActivity {

    InfosApp infosApp = new InfosApp();
    EditText etNome, etMedia, etFrequencia;
    RadioButton rbInformatica, rbRefrigeracao;
    Button bSalvar, bLimpar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        infosApp = (InfosApp) getApplicationContext();
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        etNome = findViewById(R.id.etNome);
        etMedia = findViewById(R.id.etMedia);
        etFrequencia = findViewById(R.id.etFrequencia);
        rbInformatica = findViewById(R.id.rbInformatica);
        rbRefrigeracao = findViewById(R.id.rbRefrigeracao);
        bSalvar = findViewById(R.id.bSalvar);
        bLimpar = findViewById(R.id.bLimpar);

        bSalvar.setOnClickListener(trataClique);
        bLimpar.setOnClickListener(trataClique);


    }

    View.OnClickListener trataClique = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            if(v.getId() == bLimpar.getId()){
                limpaCampos();
            }else if(v.getId() == bSalvar.getId()){
                if(!etNome.getText().toString().equals("")){
                    if(rbInformatica.isChecked() || rbRefrigeracao.isChecked()){
                        if(!etMedia.getText().toString().equals("")){
                            if(!etFrequencia.getText().toString().equals("")){
                                String nome = etNome.getText().toString();
                                int curso = 0;
                                if(rbInformatica.isChecked()){
                                    curso = 1;
                                }else if(rbRefrigeracao.isChecked()){
                                    curso = 2;
                                }
                                float media = Float.parseFloat(etMedia.getText().toString());
                                float frequencia = Float.parseFloat(etFrequencia.getText().toString());
                                int qtAprovadosInfo=0, qtAprovadosRefri=0, qtReprovadosInfo = 0, qtReprovadosRefri = 0;

                                Aluno meuAluno = new Aluno(nome,curso,media,frequencia);
                                if(media >= 6 && frequencia >= 75){
                                    Toast.makeText(CadastroActivity.this, nome+" foi aprovado(a)", Toast.LENGTH_SHORT).show();
                                }else{
                                    Toast.makeText(CadastroActivity.this, nome+" foi reprovado(a)", Toast.LENGTH_SHORT).show();
                                }

                                infosApp.getListaAlunos().add(meuAluno);

                                Intent it = new Intent();

                                it.putExtra("qtAprovadosInfo",qtAprovadosInfo);
                                it.putExtra("qtAprovadosRefri",qtAprovadosRefri);
                                it.putExtra("qtReprovadosRefri", qtReprovadosRefri);
                                it.putExtra("qtReprovadosInfo", qtReprovadosInfo);

                                setResult(1,it);

                                finish();

                            }else{
                                etFrequencia.setError("Informe a frequência!");
                                etFrequencia.requestFocus();
                            }
                        }else{
                            etMedia.setError("Informe a média!");
                            etMedia.requestFocus();
                        }
                    }else{
                        Toast.makeText(CadastroActivity.this, "Informe o curso!", Toast.LENGTH_SHORT).show();
                    }
                }else{
                    etNome.setError("Informe o nome!");
                    etNome.requestFocus();
                }
            }
        }
    };

    public void limpaCampos(){
        etNome.setText("");
        rbInformatica.setChecked(false);
        rbRefrigeracao.setChecked(false);
        etMedia.setText("");
        etFrequencia.setText("");
    }
}
