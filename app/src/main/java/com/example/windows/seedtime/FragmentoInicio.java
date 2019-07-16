package com.example.windows.seedtime;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Paint;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.graphics.drawable.RoundedBitmapDrawable;
import android.support.v4.graphics.drawable.RoundedBitmapDrawableFactory;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import java.util.ArrayList;

public class FragmentoInicio extends Fragment {

    ImageView iv;
    ArrayList<datosinicio> listDatos;
    RecyclerView recyclerView;
    Button button;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.inicio_fragmento, container, false);

        //------------------Generar imagen redonda-----------------------------
        iv = (ImageView) view.findViewById(R.id.imagenredonda);
        Bitmap bit = BitmapFactory.decodeResource(getResources(), R.drawable.users);
        RoundedBitmapDrawable roude = RoundedBitmapDrawableFactory.create(getResources(), bit);
        roude.setCircular(true);
        iv.setImageDrawable(roude);


        //-------------------------listar los datos en recycler--------------------------------------------------


        listDatos = new ArrayList<>();
        recyclerView = (RecyclerView) view.findViewById(R.id.recyclerid);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

        Llenardatos();

        AdapterDatos adapter = new AdapterDatos(listDatos);
        recyclerView.setAdapter(adapter);

//--------------------Escuchar el evento onclick------------------------------------------------
        adapter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                android.support.v4.app.Fragment selectedFrag = new FragmentoControlVivero();
                FragmentManager fm = getActivity().getSupportFragmentManager();
                fm.beginTransaction().replace(R.id.fragmento_contenedor,selectedFrag).commit();


            }
        });


        //----------------------------------------------



        return view;
    }

    private void Llenardatos() {
        listDatos.add(new datosinicio("Extension lechuga","INFO"));
        listDatos.add(new datosinicio("Extension tomate","INFO"));
        listDatos.add(new datosinicio("Extension brocoli","INFO"));
        listDatos.add(new datosinicio("Extension acelga","INFO"));
        listDatos.add(new datosinicio("Extension remolacha","INFO"));
    }
}
