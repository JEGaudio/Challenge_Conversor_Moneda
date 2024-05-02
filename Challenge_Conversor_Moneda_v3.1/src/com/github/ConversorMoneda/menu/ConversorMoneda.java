package com.github.ConversorMoneda.menu;

import com.github.ConversorMoneda.modelos.Conversiones;
import com.github.ConversorMoneda.modelos.Moneda;

import javax.swing.*;
import java.security.Principal;


public class ConversorMoneda extends MenuConversor{
    public ConversorMoneda(String datosEntregadosApi, Conversiones conversionEscogida) {
        super(datosEntregadosApi, conversionEscogida);
    }

    //public static Moneda myMoneda = new Moneda(Principal.response);

}
