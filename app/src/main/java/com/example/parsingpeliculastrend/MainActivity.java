package com.example.parsingpeliculastrend;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        PeliculaController peliculaController = new PeliculaController();
        peliculaController.getPelicula(new ResultListener<Result>() {
            @Override
            public void onFinish(Result result) {
                Pelicula pelicula = result.getPeliculaList().get(0);

                Toast.makeText(MainActivity.this, pelicula.getTitle(), Toast.LENGTH_SHORT).show();
            }
        });



    }
}
