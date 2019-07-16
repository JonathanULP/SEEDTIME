package com.example.windows.seedtime;

public class datosestados {

    private String titulo;
    private String valoresperado;
    private String valoresp;
    private String valorreal;
    private String valorrealahora;
    private String sum;
    private String res;

    public datosestados(String titulo, String valoresperado, String valoresp, String valorreal, String valorrealahora, String sum, String res) {
        this.titulo = titulo;
        this.valoresperado = valoresperado;
        this.valoresp = valoresp;
        this.valorreal = valorreal;
        this.valorrealahora = valorrealahora;
        this.sum = sum;
        this.res = res;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getValoresperado() {
        return valoresperado;
    }

    public void setValoresperado(String valoresperado) {
        this.valoresperado = valoresperado;
    }

    public String getValoresp() {
        return valoresp;
    }

    public void setValoresp(String valoresp) {
        this.valoresp = valoresp;
    }

    public String getValorreal() {
        return valorreal;
    }

    public void setValorreal(String valorreal) {
        this.valorreal = valorreal;
    }

    public String getValorrealahora() {
        return valorrealahora;
    }

    public void setValorrealahora(String valorrealahora) {
        this.valorrealahora = valorrealahora;
    }



    public String getSum() {
        return sum;
    }

    public void setSum(String sum) {
        this.sum = sum;
    }

    public String getRes() {
        return res;
    }

    public void setRes(String res) {
        this.res = res;
    }
}
