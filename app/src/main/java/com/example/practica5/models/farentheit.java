package com.example.practica5.models;

public class farentheit extends grado{

    public farentheit(double valor) {
        this.setValor(valor);
        this.setUnidad("F");
    }
    public farentheit parse(celsius C) {
        double valor = (C.getValor() * 9.0 / 5.0) + 32;
        return new farentheit(valor);
    }

    public farentheit parse(kelvin K) {
        double valor = (K.getValor() - 273.15) * 9.0 / 5.0 + 32;
        return new farentheit(valor);
    }
}
