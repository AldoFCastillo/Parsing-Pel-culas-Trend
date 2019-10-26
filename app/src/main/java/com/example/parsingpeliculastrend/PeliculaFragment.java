package com.example.parsingpeliculastrend;


import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;


/**
 * A simple {@link Fragment} subclass.
 */
public class PeliculaFragment extends Fragment implements PeliculaAdapter.PeliculaAdapterListener {

    @BindView(R.id.recyclerFragmentPelicula)
    RecyclerView recyclerView;

    List<Pelicula> peliculaList;

    private PeliculaFragmentListener peliculaFragmentListener;

    public PeliculaFragment() {
        // Required empty public constructor
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        peliculaFragmentListener = (PeliculaFragmentListener) context;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_pelicula, container, false);
        ButterKnife.bind(this, view);
        peliculaList = new ArrayList<>();
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getContext(), RecyclerView.VERTICAL, false);
        recyclerView.setLayoutManager(layoutManager);
        PeliculaController peliculaController = new PeliculaController();
        peliculaController.getPelicula(new ResultListener<Result>() {
            @Override
            public void onFinish(Result result) {
                peliculaList = result.getPeliculaList();
                //PeliculaAdapter peliculaAdapter = new PeliculaAdapter(peliculaList, );
            }
        });
        PeliculaAdapter peliculaAdapter = new PeliculaAdapter(peliculaList, this);
        recyclerView.setAdapter(peliculaAdapter);
        recyclerView.setHasFixedSize(true);


        return view;
    }

    @Override
    public void informarSeleccion(Pelicula pelicula) {
        peliculaFragmentListener.informarSeleccionDePeliculaFragment(pelicula);
    }

    public interface PeliculaFragmentListener {
        public void informarSeleccionDePeliculaFragment(Pelicula pelicula);
    }

}
