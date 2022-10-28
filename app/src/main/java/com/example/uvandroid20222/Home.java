package com.example.uvandroid20222;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class Home extends AppCompatActivity {

    public  double valorPagar;
    EditText mostrar1, mostrar2, mostrar3;
    public Integer cantidad;
    public double precioLeche;
    Button btnPintar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        mostrar1 = findViewById(R.id.edCampoMostrar);
        mostrar2 = findViewById(R.id.edCampoMostrar2);
        mostrar3 = findViewById(R.id.edCampoMostrar3);
        btnPintar = findViewById(R.id.btnPintar);
        Bundle bundle = getIntent().getExtras();
        valorPagar=bundle.getDouble("valorPagar");
        cantidad=bundle.getInt("cantidad");
        precioLeche=bundle.getDouble("precioLeche");
        mostrar1.setText("precio unitario: " + precioLeche);
        mostrar2.setText("cantidad: " + cantidad);
        mostrar3.setText("Total a pagar: " + valorPagar);
    }

    public  void volver(View cosa){
        Intent navegar = new Intent(this,MainActivity.class);
        navegar.addFlags(navegar.FLAG_ACTIVITY_CLEAR_TASK | navegar.FLAG_ACTIVITY_CLEAR_TOP);
        startActivity(navegar);
    }

    public  void pintar (View f) throws InterruptedException {
        for (int i = 0; i < 10; i++) {
            btnPintar.setBackgroundColor(Color.rgb(aleatorio(),aleatorio(),aleatorio()));
            btnPintar.setText("I: "+i);
            Thread.sleep(1000);
        }
    }

    public int aleatorio(){
        return (int)(Math.random()*255+1);
    }


}