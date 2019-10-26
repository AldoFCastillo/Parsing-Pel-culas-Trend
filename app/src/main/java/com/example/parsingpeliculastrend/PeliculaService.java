package com.example.parsingpeliculastrend;

import com.example.parsingpeliculastrend.Result;

import retrofit2.Call;
import retrofit2.http.GET;

public interface PeliculaService {

    @GET("4sblo")
    Call<Result> getPeliculas();

    //TODO confirmar metodo para buscar una pelicula

    /*@GET("4sblo/{trakt}")
    Call<Pelicula> getPhoto(@Path("trakt") String trakt);*/
}
