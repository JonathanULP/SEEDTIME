package com.example.windows.seedtime;

import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class AdapterEstados extends RecyclerView.Adapter<AdapterEstados.ViewHolderEstados> implements View.OnClickListener{

    ArrayList<datosestados> listDatos;
    private View.OnClickListener listener;

    public AdapterEstados(ArrayList<datosestados> listDatos) {
        this.listDatos = listDatos;
    }

    @Override
    public ViewHolderEstados onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.itemestado,null,false);
        view.setOnClickListener(this);
        return new ViewHolderEstados(view);
    }

    @Override
    public void onBindViewHolder(ViewHolderEstados holder, int position) {

        // set valores

        holder.tipoes.setText(listDatos.get(position).getTitulo());
        holder.tvalores.setText(listDatos.get(position).getValoresperado());
        holder.valores.setText(listDatos.get(position).getValoresp());
        holder.tvalorr.setText(listDatos.get(position).getValorreal());
        holder.valorr.setText(listDatos.get(position).getValorrealahora());
        holder.m.setText(listDatos.get(position).getSum());
        holder.men.setText(listDatos.get(position).getRes());

        //set eventos


        holder.m.setOnClickListener(this);
        holder.men.setOnClickListener(this);


    }

    @Override
    public int getItemCount() {
        return listDatos.size();
    }



    public void setOnClickListener(View.OnClickListener listener)
    {
        this.listener=listener;
    }
    @Override
    public void onClick(View view) {

        switch (view.getId())
        {
            case R.id.sumar:
                listener.onClick(view);
                break;

            case R.id.restar:
                listener.onClick(view);
                break;

        }

    }


    public class ViewHolderEstados extends RecyclerView.ViewHolder {

        TextView tipoes;
        TextView tvalores;
        EditText valores;
        TextView tvalorr;
        EditText valorr;
        Button m;
        Button men;
        public ViewHolderEstados(View itemView) {
            super(itemView);
           tipoes = (TextView)itemView.findViewById(R.id.tipodeestado);
           tvalores = (TextView)itemView.findViewById(R.id.titulovaloresperado);
           valores = (EditText)itemView.findViewById(R.id.valordeestado);
           tvalorr = (TextView)itemView.findViewById(R.id.titulovalorreal);
           valorr = (EditText) itemView.findViewById(R.id.valorentimereal);

            m = (Button)itemView.findViewById(R.id.sumar);
           men = (Button)itemView.findViewById(R.id.restar);
        }
    }


}
