package com.aluracursos.infolibrosapplication.principal;

import com.aluracursos.infolibrosapplication.model.Datos;
import com.aluracursos.infolibrosapplication.model.DatosLibros;
import com.aluracursos.infolibrosapplication.service.ConsumoAPI;
import com.aluracursos.infolibrosapplication.service.ConvierteDatos;

import java.util.Comparator;
import java.util.stream.Collectors;

public class Principal {
    private static final String URL_BASE = "https://gutendex.com/books/";
    private ConsumoAPI consumoAPI = new ConsumoAPI();
    private ConvierteDatos conversor = new ConvierteDatos();

    public void muestraMenu() {
        var json = consumoAPI.obtenerDatos(URL_BASE);
        System.out.println(json);

        //Conviertiendo datos json a datos Java
        var datos = conversor.obtenerDatos(json, Datos.class);
        System.out.println(datos);

        //Top 10 libros más descargados
        System.out.println("Top 10 libros más descargados");
        datos.resultados().stream()
                .sorted(Comparator.comparing(DatosLibros::numeroDescargas).reversed())
                .limit(10)
                .map(libro -> libro.titulo().toUpperCase())
                .forEach(System.out::println);

    }
}
