package com.estefania.hilos;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.StrictMode;
import android.os.SystemClock;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import static com.estefania.hilos.R.id.salida;

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
        MiTarea tarea = new MiTarea();
        tarea.execute(n);
        //MiThread thread = new MiThread(n);
        //thread.start();
    }

    public int factorial(int n){

        int res = 1;
        for(int i = 1; i <= n; i++){

            res *= i;
            SystemClock.sleep(1000);
        }
        return res;
    }

    class MiThread extends Thread{

        private int n, res;

        public MiThread(int n){

            this.n = n;
        }

        @Override
        public void run(){

            res = factorial(n);

            runOnUiThread(new Runnable() {

                @Override
                public void run() {
                    salida.append(res + "\n");
                }
            });
        }
    }

    class MiTarea extends AsyncTask<Integer, Void, Integer>{

        @Override
        protected Integer doInBackground(Integer... n){

            return factorial(n[0]);
        }

        @Override
        protected void onPostExecute(Integer res){

            salida.append(res + "\n");
        }
    }
}


