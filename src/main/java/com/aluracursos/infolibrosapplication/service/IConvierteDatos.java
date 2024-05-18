package com.aluracursos.infolibrosapplication.service;
// recibe un json y lo convierte a la clase que deseemos
public interface IConvierteDatos {
    <T> T obtenerDatos(String json, Class<T> clase);
}
