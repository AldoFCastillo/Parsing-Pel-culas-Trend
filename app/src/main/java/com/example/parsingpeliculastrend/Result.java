package com.example.parsingpeliculastrend;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

public class Result {

    @SerializedName("results")
    private List<Pelicula> peliculaList;

    public Result() {
        this.peliculaList = new ArrayList<>();
    }

    public List<Pelicula> getPeliculaList() {
        return peliculaList;
    }

    public void setPeliculaList(List<Pelicula> peliculaList) {
        this.peliculaList = peliculaList;
    }
}
