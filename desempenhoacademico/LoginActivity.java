package com.example.aluno.desempenhoacademico;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.EditText;

public class LoginActivity extends AppCompatActivity {

    EditText etUsuario, etSenha;
    Button bEntrar, bCancelar;
    static final int PRINCIPAL_CODIGO = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        etUsuario = findViewById(R.id.etUsuario);
        etSenha = findViewById(R.id.etSenha);
        bEntrar = findViewById(R.id.bEntrar);
        bCancelar = findViewById(R.id.bCancelar);

        bEntrar.setOnClickListener(trataClique);
        bCancelar.setOnClickListener(trataClique);
    }

    View.OnClickListener trataClique = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            if(v.getId() == bCancelar.getId()){
                limpaCampos();
            }else if(v.getId() == bEntrar.getId()){
                if(!etUsuario.getText().equals("")){
                    if(!etSenha.getText().equals("")){
                        if(etUsuario.getText().toString().equals("Marthyna")){
                            if(etSenha.getText().toString().equals("12345")){
                                Intent it = new Intent(LoginActivity.this, PrincipalActivity.class);
                                startActivityForResult(it, PRINCIPAL_CODIGO);
                            }else{
                                etSenha.setError("Senha incorreta!");
                                etSenha.requestFocus();
                            }
                        }else{
                            etUsuario.setError("Usuário incorreto!");
                            etUsuario.requestFocus();
                        }
                    }else{
                        etSenha.setError("Informe a senha!");
                        etSenha.requestFocus();
                    }
                }else{
                    etUsuario.setError("Informe o usuário!");
                    etUsuario.requestFocus();
                }
            }
        }
    };

    public void limpaCampos(){
        etSenha.setText("");
        etUsuario.setText("");
    }

}
