package com.estefania.hilos;

import android.os.SystemClock;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private EditText entrada;
    private TextView salida;
    private Button boton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        entrada = (EditText) findViewById(R.id.entrada);
        salida = (TextView) findViewById(R.id.salida);

        boton = (Button)findViewById(R.id.boton);
        boton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {

                calcularOperacion(view);
            }
        });
    }

    public void calcularOperacion(View view){

        int n = Integer.parseInt(entrada.getText().toString());
        salida.append(n + "! = ");
        int res = factorial(n);
        salida.append(res + "\n");
    }

    public int factorial(int n){

        int res = 1;
        for(int i = 1; i <= n; i++){

            res *= i;
            SystemClock.sleep(1000);
        }
        return res;
    }
}
