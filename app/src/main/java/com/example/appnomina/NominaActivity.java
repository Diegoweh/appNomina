package com.example.appnomina;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import org.w3c.dom.Text;

public class NominaActivity extends AppCompatActivity {
private Nomina con;
private TextView lblNombre, lblFolio, lblSubtotal, lblImpuesto, lblTotal;

private EditText txtHrs, txtHrsExtras;
private RadioButton rdb1,rdb2,rdb3;

private Button btnCalcular, btnLimpiar, btnRegresar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nomina);
        iniciarComponentes();

        con = new Nomina();
        lblFolio.setText(String.valueOf(con.genrarFolio()));
        Bundle bundle = getIntent().getExtras();
        String nom = bundle.getString("Trabajador");
        lblNombre.setText(nom);
        rdb1.setSelected(true);

        btnCalcular.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String horasText = txtHrs.getText().toString();
                String horasExtrasText = txtHrsExtras.getText().toString();

                if (horasText.isEmpty() || horasExtrasText.isEmpty()){
                    Toast.makeText(NominaActivity.this, "Favor de ingresar valores faltantes",
                            Toast.LENGTH_SHORT).show();
                } else {

                    int puesto = 0;

                    if (rdb1.isChecked()) {
                        puesto = 1;
                    } else if (rdb2.isChecked()) {
                        puesto = 2;
                    } else if (rdb3.isChecked()) {
                        puesto = 3;

                    }

                    Nomina nomina = new Nomina();
                    nomina.setHrs(Integer.parseInt(horasText));
                    nomina.setHrsExtras(Integer.parseInt(horasExtrasText));
                    nomina.setPuesto(puesto);


                    lblSubtotal.setText("Subtotal: " + nomina.calcularSubTotal());
                    lblImpuesto.setText("Impuesto:" + nomina.calcularImpuesto());
                    lblTotal.setText("Total: " + nomina.calcularTotal());

                }
            }
        });

        btnLimpiar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Limpia todos los campos o restablece los valores iniciales
                txtHrs.getText().clear();
                txtHrsExtras.getText().clear();
                rdb1.setChecked(true); // Establece la opción predeterminada

                // También puedes restablecer cualquier otro campo que desees aquí
            }
        });

        btnRegresar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Crea un intent para volver a la actividad MainActivity
                Intent intent = new Intent(NominaActivity.this, MainActivity.class);
                startActivity(intent);
                finish(); // Cierra la actividad actual (CotizacionActivity)
            }
        });

    }

    public void iniciarComponentes(){
        lblNombre = (TextView) findViewById(R.id.lblNombre);
        lblFolio = (TextView) findViewById(R.id.lblFolio);
        lblSubtotal = (TextView) findViewById(R.id.lblSubTotal);
        lblImpuesto = (TextView) findViewById(R.id.lblImpuesto);
        lblTotal = (TextView) findViewById(R.id.lblTotal);
        txtHrs = (EditText) findViewById(R.id.txtHrs);
        txtHrsExtras = (EditText) findViewById(R.id.txtHrsExtras);
        rdb1 = (RadioButton)  findViewById(R.id.rdb1);
        rdb2 = (RadioButton) findViewById(R.id.rdb2);
        rdb3 = (RadioButton) findViewById(R.id.rdb3);
        btnCalcular = (Button) findViewById(R.id.btnCalcular);
        btnLimpiar = (Button) findViewById(R.id.btnLimpiar);
        btnRegresar = (Button) findViewById(R.id.btnRegresar);
    }

}


