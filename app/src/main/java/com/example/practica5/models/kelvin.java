package com.example.practica5.models;

public class kelvin extends grado{

    public kelvin(double valor) {
        this.setValor(valor);
        this.setUnidad("K");
    }
    public kelvin parse(celsius C) {
        double valor = C.getValor() + 273.15;
        return new kelvin(valor);
    }

    public kelvin parse(farentheit F) {
        double valor = (F.getValor() - 32) * 5.0 / 9.0 + 273.15;
        return new kelvin(valor);
    }
}
