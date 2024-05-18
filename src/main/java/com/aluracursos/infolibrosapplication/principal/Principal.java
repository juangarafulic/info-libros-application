package com.aluracursos.infolibrosapplication.principal;

import com.aluracursos.infolibrosapplication.service.ConsumoAPI;
import com.aluracursos.infolibrosapplication.service.ConvierteDatos;

public class Principal {
    private static final String URL_BASE = "https://gutendex.com/books/";
    private ConsumoAPI consumoAPI = new ConsumoAPI();
    private ConvierteDatos conversor = new ConvierteDatos();

    public void muestraMenu() {
        var json = consumoAPI.obtenerDatos(URL_BASE);
        System.out.println(json);
    }
}
