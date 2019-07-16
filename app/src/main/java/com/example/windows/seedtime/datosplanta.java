package com.example.windows.seedtime;

public class datosplanta {

    private String titulo;
    private String descripcion;
    private int imagen;
    private String adquirir;

    public datosplanta(String titulo, String descripcion, int imagen, String adquirir) {
        this.titulo = titulo;
        this.descripcion = descripcion;
        this.imagen = imagen;
        this.adquirir = adquirir;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public int getImagen() {
        return imagen;
    }

    public void setImagen(int imagen) {
        this.imagen = imagen;
    }

    public String getAdquirir() {
        return adquirir;
    }

    public void setAdquirir(String adquirir) {
        this.adquirir = adquirir;
    }
}
