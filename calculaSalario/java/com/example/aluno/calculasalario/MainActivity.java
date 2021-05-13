package com.example.aluno.calculasalario;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText etHorasTrab, etValorHora, etDesconto;
    RadioButton rbSim, rbNao;
    CheckBox cbBruto, cbLiquido;
    Button bCalcular, bRelatorio, bLimpar;
    double mediaLiquido, somaLiquido, mediaBruto, somaBruto;
    int contLiquido, contBruto;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etHorasTrab.findViewById(R.id.etHorasTrab);
        etValorHora.findViewById(R.id.etValorHora);
        etDesconto.findViewById(R.id.etDesconto);
        rbSim.findViewById(R.id.rbSim);
        rbNao.findViewById(R.id.rbNao);
        cbBruto.findViewById(R.id.cbBruto);
        cbLiquido.findViewById(R.id.cbLiquido);
        bCalcular.findViewById(R.id.bCalcular);
        bRelatorio.findViewById(R.id.bRelatorio);
        bLimpar.findViewById(R.id.bLimpar);

        bCalcular.setOnClickListener(trataClique);
        bRelatorio.setOnClickListener(trataClique);
        bLimpar.setOnClickListener(trataClique);

        mediaBruto = 0;
        mediaLiquido = 0;
        somaBruto = 0;
        somaLiquido = 0;
        contBruto = 0;
        contLiquido = 0;
    }

    View.OnClickListener trataClique = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            if (v.getId() == bLimpar.getId()) {
                limpaCampos();
            } else {
                if (!etHorasTrab.getText().equals("")) {
                    if (!etValorHora.getText().equals("")) {
                        if(rbSim.isChecked() || rbNao.isChecked()){
                            if(cbLiquido.isChecked() || cbBruto.isChecked()){
                                if (v.getId() == bCalcular.getId()) {
                                    double horasTrab = Float.parseFloat(etHorasTrab.getText().toString());
                                    double valorHora = Float.parseFloat(etValorHora.getText().toString());
                                    if (cbBruto.isChecked()) {
                                        double salarioBruto = horasTrab * valorHora;
                                        if(rbSim.isChecked()){
                                            salarioBruto += (salarioBruto*0.1);
                                        }
                                        Toast.makeText(MainActivity.this, "Salário Bruto: " + salarioBruto, Toast.LENGTH_SHORT).show();
                                        somaBruto += salarioBruto;
                                        contBruto++;
                                    }
                                    if (cbLiquido.isChecked()) {
                                        if (!etDesconto.getText().equals("")) {
                                            double desconto = Float.parseFloat(etDesconto.getText().toString());
                                            double salarioBruto = horasTrab * valorHora;
                                            double salarioLiquido = salarioBruto - (salarioBruto * (desconto / 100));
                                            if(rbSim.isChecked()){
                                                salarioLiquido += (salarioLiquido*0.1);
                                            }
                                            Toast.makeText(MainActivity.this, "Salário Líquido: " + salarioLiquido, Toast.LENGTH_SHORT).show();
                                            somaLiquido += salarioLiquido;
                                            contLiquido++;
                                        } else {
                                            etDesconto.setError("Informe o percentual do desconto de impostos!");
                                            etDesconto.requestFocus();
                                        }
                                    }
                                }
                                if(v.getId() == bRelatorio.getId()){
                                    mediaBruto = somaBruto/contBruto;
                                    mediaLiquido = somaLiquido/contLiquido;
                                    Toast.makeText(MainActivity.this, "Média de salários brutos calculados: "+mediaBruto+" Média de salários líquidos calculados: "+mediaLiquido, Toast.LENGTH_SHORT).show();
                                }
                            }else{
                                cbBruto.setError("Marque uma das opções!");
                                cbBruto.requestFocus();
                                cbLiquido.requestFocus();
                            }
                        }else{
                            rbSim.setError("Marque uma das opções!");
                            rbSim.requestFocus();
                            rbNao.requestFocus();
                        }
                    } else {
                        etValorHora.setError("Informe o valor cobrado por hora!");
                        etValorHora.requestFocus();
                    }
                } else {
                    etHorasTrab.setError("Informe o número de horas trabalhadas!");
                    etHorasTrab.requestFocus();
                }
            }
        }
    };

    public void limpaCampos (){
        etHorasTrab.setText("");
        etValorHora.setText("");
        etDesconto.setText("");
        rbSim.setChecked(false);
        rbNao.setChecked(false);
        cbBruto.setChecked(false);
        cbLiquido.setChecked(false);
    }
}
