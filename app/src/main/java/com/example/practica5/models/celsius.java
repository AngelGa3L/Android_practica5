package com.example.practica5.models;
public class celsius extends grado {

    public celsius(double valor) {
        this.setValor(valor);
        this.setUnidad("C");
    }
    public celsius parse(farentheit F){
        double valor = (F.getValor() - 32) * 5/9;
        return new celsius(valor);
    }
    public celsius parse(kelvin K){
        double valor = (K.getValor() - 273.15) ;
        return new celsius(valor);
    }
}
