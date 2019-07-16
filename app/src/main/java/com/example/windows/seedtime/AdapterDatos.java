package com.example.windows.seedtime;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class AdapterDatos extends RecyclerView.Adapter<AdapterDatos.ViewHolderDatos> implements View.OnClickListener{

    ArrayList<datosinicio> listDatos;
    private View.OnClickListener listener;

    public AdapterDatos(ArrayList<datosinicio> listDatos) {
        this.listDatos = listDatos;
    }

    @Override
    public ViewHolderDatos onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item,null,false);
        view.setOnClickListener(this);
        return new ViewHolderDatos(view);
    }

    @Override
    public void onBindViewHolder(ViewHolderDatos holder, int position) {

        holder.mens.setText(listDatos.get(position).getVivero());
        holder.info.setText(listDatos.get(position).getBotoninfo());

        //set evento

        holder.info.setOnClickListener(this);
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
    public void onClick(View view)
    {
        if(view.getId()==R.id.informacion)
        {
            listener.onClick(view);

        }
    }

    public class ViewHolderDatos extends RecyclerView.ViewHolder {

        TextView mens;
        Button info;

        public ViewHolderDatos(View itemView) {
            super(itemView);

            mens=(TextView)itemView.findViewById(R.id.mensaje);
            info=(Button)itemView.findViewById(R.id.informacion);
        }

    }
}
