package com.example.windows.seedtime;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class AdapterPlantas extends RecyclerView.Adapter<AdapterPlantas.ViewHolderPlantas> implements View.OnClickListener{

    ArrayList<datosplanta> listDatos;
    private View.OnClickListener listener;

    public AdapterPlantas(ArrayList<datosplanta> listDatos) {
        this.listDatos = listDatos;
    }

    @Override
    public ViewHolderPlantas onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.itemplanta,null,false);
        view.setOnClickListener(this);
        return new ViewHolderPlantas(view);
    }

    @Override
    public void onBindViewHolder(ViewHolderPlantas holder, int position) {

        holder.titulo.setText(listDatos.get(position).getTitulo());
        holder.desc.setText(listDatos.get(position).getDescripcion());
        holder.imagen.setImageResource(listDatos.get(position).getImagen());
        holder.adqui.setText(listDatos.get(position).getAdquirir());
    }

    @Override
    public int getItemCount() {
        return listDatos.size();
    }

    @Override
    public void onClick(View view) {

    }


    public class ViewHolderPlantas extends RecyclerView.ViewHolder {
        TextView titulo;
        TextView desc;
        ImageView imagen;
        TextView adqui;
        public ViewHolderPlantas(View itemView) {
            super(itemView);
            titulo=(TextView)itemView.findViewById(R.id.tipodeplanta);
            desc=(TextView) itemView.findViewById(R.id.descripciondeplanta);
            imagen = (ImageView)itemView.findViewById(R.id.fotoparaplanta);
            adqui = (TextView)itemView.findViewById(R.id.adquirir);
        }
    }
}
