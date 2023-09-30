package com.example.appnomina;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private Button btnEntrar;
    private Button btnSalir;

    private EditText txtTrabajador;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnEntrar = (Button) findViewById(R.id.btnEntrar);
        btnSalir = (Button) findViewById(R.id.btnSalir);
        txtTrabajador = (EditText) findViewById(R.id.txtTrabajador);

        btnEntrar.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                if (txtTrabajador.getText().toString().matches("")){
                    Toast.makeText(MainActivity.this, "Favor de introducir el Nombre",
                            Toast.LENGTH_SHORT).show();
                }else {
                    Intent intent = new Intent (MainActivity.this,NominaActivity.class);
                    intent.putExtra("Trabajador",txtTrabajador.getText().toString());
                    startActivity(intent);
                }
            }
        });

        btnSalir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Finalizamos la aplicación cuando se hace clic en el botón
                finish();
            }
        });
    }
}