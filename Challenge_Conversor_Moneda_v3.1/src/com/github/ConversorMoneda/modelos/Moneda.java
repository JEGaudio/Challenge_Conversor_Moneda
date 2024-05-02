package com.github.ConversorMoneda.modelos;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import java.util.Scanner;


public class Moneda extends Conversiones {
    public static JsonObject conversionRates;

    public Moneda(Scanner reader, String response){
        JsonParser parser = new JsonParser();
        JsonObject jsonObject = parser.parse(response).getAsJsonObject();
        conversionRates = jsonObject.getAsJsonObject("conversion_rates");

        agregarOpcionesMenu("Nueva Moneda");

        while (reader.hasNextLine()){
            String[] linea = String.valueOf(reader.nextLine()).split("/");
            agregarOpcionesMenu(linea[1] + " ("+linea[0]+")");
            agregarDicc(linea[0],1/conversionRates.get(linea[0]).getAsDouble());
        }

    }

    public Moneda(){
//        System.out.println(conversionRates.keySet());
//        File myFile = new File(Principal2.nombreArchivo);
//        //myFile.createNewFile();
//        //System.out.println(myFile.getPath());
//        Scanner myReader = new Scanner(myFile);
//
//        while (myReader.hasNextLine()){
//            String[] linea = String.valueOf(myReader.nextLine()).split("/");
//            agregarOpcionesMenu(linea[1] + " ("+linea[0]+")");
//        }

//        agregarDicc("Dólar",1/conversionRates.get("USD").getAsDouble());
//        agregarDicc("Euro",1/conversionRates.get("EUR").getAsDouble());
//        agregarDicc("Libras",1/conversionRates.get("GBP").getAsDouble());
//        agregarDicc("Yen",1/conversionRates.get("JPY").getAsDouble());
//        agregarDicc("KRW",1/conversionRates.get("USD").getAsDouble());

//        setOpcionesMenu(new String[]{
//                "de Peso Chileno a Dólar",
//                "de Peso Chileno a Euros",
//                "de Peso Chileno a Libras Esterlinas",
//                "de Peso Chileno a Yen Japonés",
//                "de Peso Chileno a Won sul-coreano",
//                "de Dólar a Peso Chileno",
//                "de Euros a Peso Chileno",
//                "de Libras Esterlinas a Peso Chileno",
//                "de Yen Japonés a Peso Chileno",
//                "de Won sul-coreano a Peso Chileno"
//        });

//        setOpcionesDiccionario(new String[] {
//                "Dólar",
//                "Euro",
//                "Libras",
//                "Yen",
//                "Won"
//        });
    }

}
