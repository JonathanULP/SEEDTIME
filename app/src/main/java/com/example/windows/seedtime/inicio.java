package com.example.windows.seedtime;

import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;

public class inicio extends AppCompatActivity {

    private BottomNavigationView bnt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inicio);

        bnt = (BottomNavigationView) findViewById(R.id.bottomnavigatorview);

        bnt.setOnNavigationItemSelectedListener(navlistener);

        //metodo para que siempre empiece con el fragmento de inicio
        getSupportFragmentManager().beginTransaction().replace(R.id.fragmento_contenedor,new FragmentoInicio()).commit();



    }

    //---------inflar el fragment segun el item que se eliga---------------------------------
    private BottomNavigationView.OnNavigationItemSelectedListener navlistener = new BottomNavigationView.OnNavigationItemSelectedListener() {
        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            android.support.v4.app.Fragment selectedFrag = null;

            switch (item.getItemId()) {


                case R.id.inicioItem:
                    selectedFrag = new FragmentoInicio();
                    break;

                case R.id.plantasItem:
                    selectedFrag = new FragmentoPlantas();
                    break;

                case R.id.controlitem:
                    selectedFrag = new FragmentoControlVivero();
                    break;

                case R.id.ConfiguracionItem:
                    selectedFrag = new FragmentoConfiguracion();
                    break;

                case R.id.contactoItem:
                    selectedFrag = new FragmentoContacto();
                    break;
            }

            getSupportFragmentManager().beginTransaction().replace(R.id.fragmento_contenedor, selectedFrag).commit();
            return true;
        }
    };


}
