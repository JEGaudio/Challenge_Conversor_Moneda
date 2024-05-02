package com.github.ConversorMoneda.menu;

import com.github.ConversorMoneda.modelos.Conversiones;
import com.github.ConversorMoneda.modelos.Distancia;
import com.github.ConversorMoneda.modelos.Moneda;

import javax.swing.*;

public class ConversorDistancia extends MenuConversor {
    static Distancia myDistancia = new Distancia();

    public ConversorDistancia(String datosEntregadosApi, Conversiones conversionEscogida) {
        super(datosEntregadosApi, conversionEscogida);
    }
}
