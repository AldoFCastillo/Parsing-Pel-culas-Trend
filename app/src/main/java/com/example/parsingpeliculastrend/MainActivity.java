package com.example.parsingpeliculastrend;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

public class MainActivity extends AppCompatActivity implements PeliculaFragment.PeliculaFragmentListener{
    PeliculaFragment peliculaFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        peliculaFragment = new PeliculaFragment();
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.activityMainContenedorDeFragment, peliculaFragment).commit();

        /*PeliculaController peliculaController = new PeliculaController();
        peliculaController.getPelicula(new ResultListener<Result>() {
            @Override
            public void onFinish(Result result) {
                Pelicula pelicula = result.getPeliculaList().get(1);

                Toast.makeText(MainActivity.this, pelicula.getTitle(), Toast.LENGTH_SHORT).show();

                FragmentManager fragmentManager = getSupportFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.activityMainContenedorDeFragment, peliculaFragment).commit();


            }
        });*/



    }

    @Override
    public void informarSeleccionDePeliculaFragment(Pelicula pelicula) {

    }
}
