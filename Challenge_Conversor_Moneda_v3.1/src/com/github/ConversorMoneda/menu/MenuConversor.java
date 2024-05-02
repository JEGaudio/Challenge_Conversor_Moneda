package com.github.ConversorMoneda.menu;

import com.github.ConversorMoneda.modelos.Conversiones;
import com.github.ConversorMoneda.modelos.Moneda;

import javax.swing.*;

public class MenuConversor {

    public static Conversiones myConversiones = new Conversiones();
    public static String datosEntregadosApi;
    public static Conversiones conversionEscogida;

    public MenuConversor(String datosEntregadosApi, Conversiones conversionEscogida){
        this.datosEntregadosApi = datosEntregadosApi;
        this.conversionEscogida = conversionEscogida;
        menuConversorOpciones();
    }

    public static void menuConversorOpciones() {
        cargarDatos();
        elegirUnidadActual();
    }

    private static void cargarDatos() {
        myConversiones.setDiccionario(conversionEscogida.getDiccionario());
        myConversiones.setOpcionesMenu(conversionEscogida.getOpcionesMenu());
    }

    public static void elegirUnidadActual(){

        JOptionPane menu = new JOptionPane();

        Object respuesta = menu.showInputDialog(
                null,
                "Indicar la unidad para convertir" ,
                "Tipo de cambio",
                JOptionPane.QUESTION_MESSAGE,
                null,
                myConversiones.getOpcionesMenu(),
                null);
        if (respuesta==null){
            Principal.preguntaMenu();
            return;
        } else if (respuesta.equals("Nueva Moneda")) {
            MenuCreacion.creacionUnidad(conversionEscogida,datosEntregadosApi);
            return;
        }
        if (conversionEscogida instanceof Moneda) {
            myConversiones.setUnidadActual(myConversiones.getMonedaDeOpcion(respuesta.toString()));
        }
        else {
            myConversiones.setUnidadActual(respuesta.toString());
        }
        menuConversor();
    }

    public static void menuConversor(){
        JOptionPane menu = new JOptionPane();
        double temp;
        Object respuesta = menu.showInputDialog(
                null,
                "Indique la cantidad a convertir para la unidad: " + myConversiones.getUnidadActual(),
                "Monto a convertir",
                JOptionPane.QUESTION_MESSAGE,
                null,
                null,
                null);
        if (respuesta==null){
            elegirUnidadActual();
            return;
        }
        try {
            temp = Double.parseDouble(respuesta.toString());
        }
        catch (Exception e){
            JOptionPane.showMessageDialog(null,"Parametro ingresado no corresponde a un número.\nFavor volver a ingresar");
            menuConversor();
            return;
        }
        myConversiones.setValorActual(temp);
        elegirUnidadConvertir();
    }

    public static void elegirUnidadConvertir(){
        JOptionPane menu = new JOptionPane();

        Object respuesta = menu.showInputDialog(
                null,
                "Indicar la unidad para convertir:\n" +
                        myConversiones.getValorActual() + " " + myConversiones.getUnidadActual() ,
                "Tipo de cambio",
                JOptionPane.QUESTION_MESSAGE,
                null,
                myConversiones.getOpcionesMenu(),
                null);
        if (respuesta==null){
            menuConversor();
            return;
        } else if (respuesta.equals("Nueva Moneda")){
            MenuCreacion.creacionUnidad(conversionEscogida, datosEntregadosApi);
            return;
        }
        if (conversionEscogida instanceof Moneda) {
            myConversiones.setUnidadConvertida(myConversiones.getMonedaDeOpcion(respuesta.toString()));
        } else {
            myConversiones.setUnidadConvertida(respuesta.toString());
        }
        mostrarResultado(myConversiones.calcularConversion(
                myConversiones.getValorActual(),
                myConversiones.getDiccionario().get(myConversiones.getUnidadConvertida()),
                myConversiones.getDiccionario().get(myConversiones.getUnidadActual())
        ));
    }

    public static void mostrarResultado (double valor){
        valor = (double)((int)(valor*100))/100;  //redondear el valor obtenido a dos decimales
        myConversiones.setValorConvertido(valor);

        JOptionPane.showMessageDialog(
                null,
                "El resultado de la conversión para:\n"+
                        myConversiones.getValorActual()+ " " + myConversiones.getUnidadActual() +
                        "\nes:\n" + valor + " " + myConversiones.getUnidadConvertida(),
                "Resultado de la conversion",
                JOptionPane.PLAIN_MESSAGE,
                null);
        Principal.calculosRealizados.add(
                myConversiones.getValorActual()+ " " + myConversiones.getUnidadActual() +
                " => " + valor + " " + myConversiones.getUnidadConvertida()
        );
    }
}
