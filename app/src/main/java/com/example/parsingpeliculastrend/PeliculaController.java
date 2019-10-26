package com.example.parsingpeliculastrend;

public class PeliculaController {

    private PeliculaDAO peliculaDAO;

    public PeliculaController() {
        this.peliculaDAO = new PeliculaDAO();
    }

    public void getPelicula(final ResultListener<Result> listenerDeLaView) {
        peliculaDAO.getPeliculas(new ResultListener<Result>() {
            @Override
            public void onFinish(Result result) {
                listenerDeLaView.onFinish(result);
            }
        });

    }

}
