package com.example.windows.seedtime;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class FragmentoControlVivero extends Fragment {

    TextView textView;
    Spinner spinner;
    ArrayList<datosestados> listDatos;
    RecyclerView recyclerView;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.control_vivero_fragmento,container,false);

        //-------------inflar el recyclerview----------------------------

        listDatos = new ArrayList<>();
        recyclerView = (RecyclerView)view.findViewById(R.id.recycleridestado);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

        llenarDatos();

        AdapterEstados adapterEstados = new AdapterEstados(listDatos);
        recyclerView.setAdapter(adapterEstados);


        //-------------Agregar items a spinner--------------------------------
        textView = (TextView)view.findViewById(R.id.estadosextension);
        spinner = (Spinner) view.findViewById(R.id.opcionesext);

        ArrayAdapter<CharSequence> arrayAdapter =ArrayAdapter.createFromResource(getContext(),R.array.extensiones,R.layout.support_simple_spinner_dropdown_item);

        spinner.setAdapter(arrayAdapter);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {

                textView.setText(adapterView.getItemAtPosition(i).toString());
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });


        //---------------escuchar evento de click-----------------

        adapterEstados.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                switch (view.getId()) {
                    case R.id.sumar:
                        Toast.makeText(getContext(), "Sumar", Toast.LENGTH_LONG).show();

                        break;

                    case R.id.restar:

                        Toast.makeText(getContext(), "Restar", Toast.LENGTH_LONG).show();
                        break;
                }
            }
        });
                return view;
    }

    //metodo que llena el recyclerview instanciando objetos que contienen sus atributos------------
    private void llenarDatos() {


        listDatos.add(new datosestados("Nivel de PH","Valor esperado","3","Valor en tiempo real","8","+","-"));
        listDatos.add(new datosestados("Conductividad del agua","Valor esperado","710","Valor en tiempo real","710","+","-"));
        listDatos.add(new datosestados("Temperatura","Valor esperado","20","Valor en tiempo real","10","+","-"));
        listDatos.add(new datosestados("Nutrientes","Valor esperado","100","Valor en tiempo real","110","+","-"));


    }



}
