package com.example.windows.seedtime;

public class datosinicio {

    private String vivero;
    private String botoninfo;

    public datosinicio(String vivero, String botoninfo) {
        this.vivero = vivero;
        this.botoninfo = botoninfo;
    }

    public String getVivero() {
        return vivero;
    }

    public void setVivero(String vivero) {
        this.vivero = vivero;
    }

    public String getBotoninfo() {
        return botoninfo;
    }

    public void setBotoninfo(String botoninfo) {
        this.botoninfo = botoninfo;
    }
}
