package com.example.calculadoraimc;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    double numeroPeso, numeroAltura, resultado;
    Math math;
    EditText peso;
    EditText altura;
    TextView textoResultado;
    TextView textoDiagnostico;
    Button btnCalcular;
    Button btnLimpar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        peso = findViewById(R.id.inputPeso);
        altura  = findViewById(R.id.inputAltura);
        textoResultado = findViewById(R.id.textoResultado);
        textoDiagnostico = findViewById(R.id.resultadoDiagnostico);
        btnCalcular = findViewById(R.id.botaoCalcular);
        btnLimpar = findViewById(R.id.botaoLimpar);
    }

    public void calcular(View view){
        numeroPeso = Double.parseDouble(peso.getText().toString());
        numeroAltura  = Double.parseDouble(altura.getText().toString());
        resultado = numeroPeso / math.pow(numeroAltura, 2);
        textoResultado.setText(String.format("%.2f",resultado));

        if (resultado <= 18.5){
            textoDiagnostico.setText("A baixo do peso");
        } else if (resultado >= 18.6 && resultado <= 24.9) {
            textoDiagnostico.setText("Peso normal");
        } else if (resultado >= 25.0 && resultado <= 29.9) {
            textoDiagnostico.setText("Sobrepeso");
        }else{
            textoDiagnostico.setText("Obesidade");
        }
    }

    public void limpar(View view){
        peso.setText("");
        altura.setText("");
        textoResultado.setText("");
        textoDiagnostico.setText("");
    }
}