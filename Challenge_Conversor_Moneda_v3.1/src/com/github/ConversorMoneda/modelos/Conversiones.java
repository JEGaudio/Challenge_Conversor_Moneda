package com.github.ConversorMoneda.modelos;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class Conversiones {
    private double valorActual;
    private double valorConvertido;
    private String unidadActual;
    private String unidadConvertida;
    private HashMap<String,Double> diccionario = new HashMap<String,Double>();
    private ArrayList<String> opcionesMenu = new ArrayList<>();
    private ArrayList<String> opcionesDiccionario = new ArrayList<>();

    public double calcularConversion(Double valor,Double conversionInicial,Double conversionFinal){
        return valor*conversionFinal/conversionInicial;
    }

    public String getMonedaDeOpcion(String opcion){
        return opcion.substring(opcion.length()-4,opcion.length()-1);
    }

    public void agregarDicc(String Moneda, double valor){
        diccionario.put(Moneda,valor);
    }

    //Getters y setters

    public double getValorConvertido() {return valorConvertido;}

    public void setValorConvertido(double valorConvertido) {
        this.valorConvertido = valorConvertido;
    }

    public String getUnidadActual() {return unidadActual;}

    public void setUnidadActual(String unidadActual) {
        this.unidadActual = unidadActual;
    }

    public String getUnidadConvertida() {return unidadConvertida;}

    public void setUnidadConvertida(String unidadConvertida) {
        this.unidadConvertida = unidadConvertida;
    }

    public HashMap<String, Double> getDiccionario() {
        return diccionario;
    }

    public void setDiccionario(HashMap<String, Double> diccionario) {
        this.diccionario = diccionario;
    }

    public double getValorActual() {
        return valorActual;
    }

    public void setValorActual(double valorActual) {
        this.valorActual = valorActual;
    }

    public void agregarOpcionesMenu(String opcion){
        this.opcionesMenu.add(opcion);
    }

    public String[] getOpcionesMenu() {
        return opcionesMenu.toArray(new String[0]);
    }

    public void setOpcionesMenu(String[] opcionesMenu) {
        this.opcionesMenu.clear();
        this.opcionesMenu.addAll(Arrays.asList(opcionesMenu));
    }

    public String[] getOpcionesDiccionario() {
        return opcionesDiccionario.toArray(new String[0]);
    }

    public void setOpcionesDiccionario(String[] opcionesDiccionario) {
        this.opcionesDiccionario.clear();
        this.opcionesDiccionario.addAll(Arrays.asList(opcionesDiccionario));
    }
}
