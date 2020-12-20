package com.example.clase7;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText num1, num2;
    Button btnMostrar;
    TextView resultado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        btnMostrar=findViewById(R.id.Calcular);
        num1=findViewById(R.id.num1);
        num2=findViewById(R.id.num2);
        resultado=findViewById(R.id.resultado);


        btnMostrar.setOnClickListener(view -> {

            //Tomo el numero ingresado y lo guardo como cadena
            String num1Text=num1.getText().toString();
            //Guardo el numero de la cadena como numero
            int num1Num=Integer.parseInt(num1Text);

            //Tomo el numero ingresado y lo guardo como cadena
            String num2Text=num2.getText().toString();
            //Guardo el numero de la cadena como numero
            int num2Num=Integer.parseInt(num2Text);

            int calculo = num1Num*num2Num;

            resultado.setText(String.valueOf(calculo));

        });
    }




}