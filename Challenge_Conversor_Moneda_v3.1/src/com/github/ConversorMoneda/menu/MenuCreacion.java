package com.github.ConversorMoneda.menu;

import com.github.ConversorMoneda.modelos.Conversiones;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import javax.swing.*;

public class MenuCreacion {
    private static String unidad;
    private static Conversiones conversionIngresada;
    private static String datosEntregadosApi;
    private static JsonParser parser = new JsonParser();
    private static JsonObject jsonObject;
    private static JsonObject conversionRates;


    public static void creacionUnidad(Conversiones conversion , String datosApi){
        conversionIngresada = conversion;
        datosEntregadosApi = datosApi;
        jsonObject = parser.parse(datosApi).getAsJsonObject();
        conversionRates = jsonObject.getAsJsonObject("conversion_rates");
        boolean encontro = false;
        JOptionPane menu = new JOptionPane();

        Object respuesta = menu.showInputDialog(
                null,
                "Indique la unidad a agregar",
                "Unidad",
                JOptionPane.QUESTION_MESSAGE,
                null,
                null,
                null);
        if (respuesta==null) {
            MenuConversor.elegirUnidadActual();
            return;
        }
        respuesta = respuesta.toString().toUpperCase();
        String[] unidades = conversionRates.keySet().toArray(new String[0]);
        for (int i = 0; i < unidades.length; i++) {
            if (respuesta.equals(unidades[i])){
                unidad = unidades[i];
                encontro=true;
                break;
            }
        }
        if (encontro){
            creacionNombre();
        } else{
            JOptionPane.showMessageDialog(null,"Parametro ingresado no corresponde a una unidad.\nFavor volver a ingresar");
            creacionUnidad(conversion,datosApi);
        }

    }


    public static void creacionNombre(){
        JOptionPane menu = new JOptionPane();
        Double temp;

        Object respuesta = menu.showInputDialog(
                null,
                "Indique el nombre a agregar para la unidad: "+ unidad,
                "Nombre",
                JOptionPane.QUESTION_MESSAGE,
                null,
                null,
                null);

        if (respuesta==null) {
            creacionUnidad(conversionIngresada,datosEntregadosApi);
            return;
        }
        conversionIngresada.agregarOpcionesMenu(respuesta.toString() + " ("+unidad+")");
        conversionIngresada.agregarDicc(unidad,1/conversionRates.get(unidad).getAsDouble());
        JOptionPane.showMessageDialog(null, "Unidad de conversion agregada con exito\n\nVolviendo al menu principal");

    }
}
