package com.example.windows.seedtime;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Html;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button botoningresar,olvidocontraseña;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        botoningresar = (Button) findViewById(R.id.ingresar);
        olvidocontraseña = (Button) findViewById(R.id.olvidocontraseña);

        //-------agregar subrayado al boton---------
        olvidocontraseña.setText(Html.fromHtml("<u>Olvidaste tu contraseña?</u>"));



        //------inflar un nuevo activity------------------
        botoningresar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                startActivity(new Intent(MainActivity.this,inicio.class));
            }
        });

    }
}
