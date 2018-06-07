package com.example.pff.segundoentregable;

import java.io.Serializable;

public class Receta implements Serializable{

    private String titulo;
    private Integer foto;
    private String ingredientes;
    private String preparación;

    public Receta(String titulo, Integer foto, String ingredientes, String preparación) {
        this.titulo = titulo;
        this.foto = foto;
        this.ingredientes = ingredientes;
        this.preparación = preparación;
    }

    public String getTitulo() {
        return titulo;
    }

    public Integer getFoto() {
        return foto;
    }

    public String getIngredientes() {
        return ingredientes;
    }

    public String getPreparación() {
        return preparación;
    }
}
