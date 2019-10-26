package com.example.parsingpeliculastrend;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class ResultDAO {

    @SerializedName("results")
    private List<Pelicula> peliculaList;
}
