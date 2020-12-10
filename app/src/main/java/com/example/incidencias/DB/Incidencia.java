package com.example.incidencias.DB;

public class Incidencia {
    private String titulo;
    private String prioridad;
    private String id;

    public Incidencia(String titulo, String prioridad){
        this.titulo = titulo;
        this.prioridad = prioridad;
    }


    public String getTitulo(){
        return titulo;
    }

    public String getPrioridad(){
        return prioridad;
    }

    public String getID(){
        return id;
    }
    public void setID(String id){
        this.id = "JDA-" + id;
    }

}

