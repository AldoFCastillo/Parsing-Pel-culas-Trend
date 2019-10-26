package com.example.parsingpeliculastrend;


import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class PeliculaDAO {

    private static final String BASE_URL = "https://api.myjson.com/bins/";
    private Retrofit retrofit;
    private PeliculaService peliculaService;

    public PeliculaDAO() {
        this.retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        peliculaService = retrofit.create(PeliculaService.class);
    }

    public void getPeliculas(final ResultListener<Result> resultListener) {

        Call<Result> call = this.peliculaService.getPeliculas();

        call.enqueue(new Callback<Result>() {
            @Override
            public void onResponse(Call<Result> call, Response<Result> response) {
                Result peliculas = response.body();

                resultListener.onFinish(peliculas);

            }

            @Override
            public void onFailure(Call<Result> call, Throwable t) {
                String message = t.getMessage();
                System.out.println("ha ocurrido un error" + message);
                t.printStackTrace();

            }
        });
        {

        }
    }
}
