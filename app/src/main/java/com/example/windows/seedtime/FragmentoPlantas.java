package com.example.windows.seedtime;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

public class FragmentoPlantas extends Fragment {


    ArrayList<datosplanta> listDatos;
    RecyclerView recyclerView;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.plantas_fragmento,container,false);

        //---------------inflar el recyclerview---------------------
        listDatos = new ArrayList<>();
        recyclerView = (RecyclerView) view.findViewById(R.id.recyclerid2);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

        Llenardatos();

        AdapterPlantas adapter = new AdapterPlantas(listDatos);
        recyclerView.setAdapter(adapter);



        return view;
    }

    private void Llenardatos() {


        listDatos.add(new datosplanta("Lechuga","La lechuga es un tipo de hortaliza herbácea conformada por flores amarillentas,que contiene Tiamina,Ácido fólico,Vitaminas A, B1, B2, B3, C, E y K" ,R.drawable.lechuga_romana, "Adquirir"));
        listDatos.add(new datosplanta("Tomate","Es rico en vitaminas y minerales: esta hortaliza aporta vitamina C, un potente antioxidante natural, además de vitamina A, K, hierro y potasio",R.drawable.tomates,"Adquirir"));
        listDatos.add(new datosplanta("Brocoli","Vitaminas: es una buena fuente vitamina C, ácido ascórbico, niacina y vitamina A. Minerales: potasio y menores cantidades de calcio, sodio y magnesio",R.drawable.brocoli,"Adquirir"));
        listDatos.add(new datosplanta("Acelga","Es una planta que se caracteriza por su intenso color verde, sus grandes hojas comestibles y por su nervio central muy desarrollado. Mayormente se la cultiva con la misión de usarla como alimento en las comidas, aunque también se le reconocen beneficios para la salud" ,R.drawable.acelga,"Adquirir"));
        listDatos.add(new datosplanta("Lechuga Repollada","es una variedad de lechuga que crece con una larga cabeza y que posee una hojas robustas, alargadas y con un robusto nervio central" ,R.drawable.repollada2,"Adquirir"));

    }
}
