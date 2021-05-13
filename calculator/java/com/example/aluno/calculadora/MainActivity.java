package com.example.aluno.calculadora;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText etValor1, etValor2;
    Button bSomar, bSubtrair, bMultiplicar, bDividir, bCancelar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etValor1 = findViewById(R.id.etValor1);
        etValor2 = findViewById(R.id.etValor2);
        bSomar = findViewById(R.id.bSomar);
        bSubtrair = findViewById(R.id.bSubtrair);
        bMultiplicar = findViewById(R.id.bMultiplicar);
        bDividir = findViewById(R.id.bDividir);
        bCancelar = findViewById(R.id.bCancelar);



        bSomar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!etValor1.getText().toString().equals("")) {
                    if (!etValor2.getText().toString().equals("")) {
                        double valor1 = Double.parseDouble(etValor1.getText().toString());
                        double valor2 = Double.parseDouble(etValor2.getText().toString());
                        double resultado = 0;
                        resultado = valor1 + valor2;
                        Toast.makeText(MainActivity.this, "Resultado: " + resultado, Toast.LENGTH_SHORT).show();

                    } else {
                        etValor1.setError("Digite o valor 1!");
                        etValor1.requestFocus();
                    }
                } else {
                    etValor2.setError("Digite o valor 2!");
                    etValor2.requestFocus();
                }
            }

        });

        bSubtrair.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!etValor1.getText().toString().equals("")) {
                    if (!etValor2.getText().toString().equals("")) {
                        double valor1 = Double.parseDouble(etValor1.getText().toString());
                        double valor2 = Double.parseDouble(etValor2.getText().toString());
                        double resultado = 0;
                        resultado = valor1 - valor2;
                        Toast.makeText(MainActivity.this, "Resultado: "+resultado, Toast.LENGTH_SHORT).show();

                    } else {
                        etValor1.setError("Digite o valor 1!");
                        etValor1.requestFocus();
                    }
                } else {
                    etValor2.setError("Digite o valor 2!");
                    etValor2.requestFocus();
                }
            }
        });

        bMultiplicar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!etValor1.getText().toString().equals("")) {
                    if (!etValor2.getText().toString().equals("")) {
                        double valor1 = Double.parseDouble(etValor1.getText().toString());
                        double valor2 = Double.parseDouble(etValor2.getText().toString());
                        double resultado = 0;
                        resultado = valor1 * valor2;
                        Toast.makeText(MainActivity.this, "Resultado: "+resultado, Toast.LENGTH_SHORT).show();
                    } else {
                        etValor1.setError("Digite o valor 1!");
                        etValor1.requestFocus();
                    }
                } else {
                    etValor2.setError("Digite o valor 2!");
                    etValor2.requestFocus();
                }
            }
        });

        bDividir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!etValor1.getText().toString().equals("")) {
                    if (!etValor2.getText().toString().equals("")) {
                        double valor1 = Double.parseDouble(etValor1.getText().toString());
                        double valor2 = Double.parseDouble(etValor2.getText().toString());
                        double resultado = 0;
                        if(valor2 != 0){
                            resultado = valor1 / valor2;
                            Toast.makeText(MainActivity.this, "Resultado: "+resultado, Toast.LENGTH_SHORT).show();
                        }else{
                            etValor2.setError("Divisor não pode ser zero!");
                            etValor2.requestFocus();
                        }
                    } else {
                        etValor1.setError("Digite o valor 1!");
                        etValor1.requestFocus();
                    }
                } else {
                    etValor2.setError("Digite o valor 2!");
                    etValor2.requestFocus();
                }
            }
        });



        bCancelar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                limpaCampos();
            }
        });
    }


    public void limpaCampos(){
        etValor2.setText("");
        etValor1.setText("");
    }

}
