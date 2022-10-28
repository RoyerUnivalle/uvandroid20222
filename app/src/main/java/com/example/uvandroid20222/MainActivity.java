package com.example.uvandroid20222;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    Button btnLogin, btnDelegado, btnInterfaz;
    EditText edCantidad, edValor;
    public  double precioLeche = 137750;
    public  double valorPagar;
    public Integer cantidad;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //enlazamiento
        cantidad = 0;
        //btnLogin = findViewById(R.id.btnLogin);
        btnInterfaz = findViewById(R.id.btnInterfaz);
        btnDelegado = findViewById(R.id.btnDelegado);
        edCantidad = findViewById(R.id.edCantidad);
        edValor = findViewById(R.id.edValor);
        // Anado un evento por medio de interfaz
        btnInterfaz.setOnClickListener(this);
        // Delegado
        btnDelegado.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent navegar = new Intent(getApplicationContext(),Home.class);
                Bundle data = new Bundle();
                data.putInt("cantidad",cantidad);
                data.putDouble("valorPagar", valorPagar);
                navegar.putExtras(data);
                navegar.putExtra("precioLeche",precioLeche);
                navegar.addFlags(navegar.FLAG_ACTIVITY_CLEAR_TASK | navegar.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(navegar);
                //Toast.makeText(getApplicationContext(), "Hola boton 2", Toast.LENGTH_LONG).show();
            }
        });
    }
    @Override
    protected void onPostResume() {
        super.onPostResume();
        //Toast.makeText(this, "Hola soy el metodo onPostResume", Toast.LENGTH_LONG).show();
    }
    @Override
    protected void onPause() {
        super.onPause();
        //Toast.makeText(this, "Hola soy el metodo onPause", Toast.LENGTH_LONG).show();
    }

    public void saludar(View h){
        //enlazamiento
        btnLogin = (Button) h;
        btnLogin.setText("Ya me tocaste");
        cantidad = cantidad + 1;
        edCantidad.setText("Cantidad: "+cantidad);
        valorPagar = cantidad*precioLeche;
        edValor.setText("El valor de tu cuenta es: "+ valorPagar);
        Toast.makeText(this, "Hola boton 3: "+btnLogin.getText(), Toast.LENGTH_LONG).show();
    }

    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putDouble("valorPagar", valorPagar);
        outState.putInt("cantidad", cantidad);
    }

    @Override
    protected void onRestoreInstanceState(@NonNull Bundle paquete) {
        super.onRestoreInstanceState(paquete);
        cantidad = paquete.getInt("cantidad");
        valorPagar = paquete.getInt("valorPagar");
    }

    @Override
    public void onClick(View v) {
        Toast.makeText(this, "Hola boton", Toast.LENGTH_LONG).show();

    }
}