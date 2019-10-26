package com.example.parsingpeliculastrend;


import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;


public class PeliculaAdapter extends RecyclerView.Adapter {

    List<Pelicula> peliculaList;
    PeliculaAdapterListener peliculaAdapterListener;

    public PeliculaAdapter(List<Pelicula> peliculaList, PeliculaAdapterListener peliculaAdapterListener) {
        this.peliculaList = peliculaList;
        this.peliculaAdapterListener = peliculaAdapterListener;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.celda_pelicula, parent, false);
        PeliculaViewHolder peliculaViewHolder = new PeliculaViewHolder(view);

        return peliculaViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {

        PeliculaViewHolder peliculaViewHolder = (PeliculaViewHolder) holder;
        Pelicula pelicula = peliculaList.get(position);
        peliculaViewHolder.bind(pelicula);

    }

    @Override
    public int getItemCount() {
        return peliculaList.size();
    }

    public class PeliculaViewHolder extends RecyclerView.ViewHolder{

        @BindView(R.id.textViewTituloCelda)
        TextView textViewTituloCelda;
        @BindView(R.id.textViewAnioCelda)
        TextView textViewAnioCelda;

        public PeliculaViewHolder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);


        }
        public void bind(Pelicula pelicula){
            this.textViewTituloCelda.setText(pelicula.getTitle());
            this.textViewAnioCelda.setText(pelicula.getYear());

        }
    }

    public interface PeliculaAdapterListener{
        public void informarSeleccion(Pelicula pelicula);

    }
}
