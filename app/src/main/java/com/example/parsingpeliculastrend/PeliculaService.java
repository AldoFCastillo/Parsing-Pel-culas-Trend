package com.example.parsingpeliculastrend;

import java.util.List;

import retrofit2.http.GET;
import retrofit2.http.Path;

public interface PeliculaService {

    @GET("4sblo")
    Call<Result> getPhotos();

    //TODO confirmar metodo para buscar una pelicula

    /*@GET("4sblo/{trakt}")
    Call<Pelicula> getPhoto(@Path("trakt") String trakt);*/
}
