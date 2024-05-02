package com.github.ConversorMoneda.menu;

import com.github.ConversorMoneda.modelos.Distancia;
import com.github.ConversorMoneda.modelos.Moneda;

import javax.swing.*;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Principal {
    static boolean seguirCalculando;
    public static HttpResponse<String> response;
    public static List<String> calculosRealizados = new ArrayList<>();
    public static String nombreArchivo = "DB_Conversor.txt";
    public static Moneda myMoneda;
    public static Distancia myDistancia;

    public static void main(String[] args) throws IOException, InterruptedException {

        String api = System.getenv("API_Conversor");
        String direccion = "https://v6.exchangerate-api.com/v6/" + api + "/latest/CLP";

        try {
            HttpClient client = HttpClient.newHttpClient();
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(direccion))
                    .build();
            response = client.send(request, HttpResponse.BodyHandlers.ofString());
            if (response.statusCode()==403){
                JOptionPane.showMessageDialog(null, "No es posible acceder al servidor.\nVerificar llave API");
                return;
            }
        }
        catch (IOException e){
            JOptionPane.showMessageDialog(null, "No es posible acceder al servidor.\nVerificar conexion a internet");
        }


        File myFile = new File(nombreArchivo);
        Scanner myReader = new Scanner(myFile);

        myMoneda = new Moneda(myReader,response.body());
        myDistancia = new Distancia();

        seguirCalculando = true;

        while(seguirCalculando) {
            preguntaMenu();
        }
        try {
            FileWriter archivoDB = new FileWriter(nombreArchivo);
            String texto = "";
            for (int i = 1; i < myMoneda.getOpcionesMenu().length ; i++) {
                String[] tempArray = myMoneda.getOpcionesMenu()[i].split("\\(");
                texto += myMoneda.getMonedaDeOpcion(myMoneda.getOpcionesMenu()[i])+
                        "/" +
                        tempArray[0]+"\n";
            }
            archivoDB.write(texto);
            archivoDB.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

    public static void preguntaMenu(){
        String[] opcionesMenu = {"Ver calculos realizados","Conversor de Monedas","Conversor de Distancias"};
        JOptionPane menu = new JOptionPane();
        Object respuesta = menu.showInputDialog(
                null,
                "Seleccione una opcion de conversion",
                "Menu",
                JOptionPane.QUESTION_MESSAGE,
                null,
                opcionesMenu,
                null);
        if (respuesta==null) {
            seguirCalculando=false;
            return;
        }
        if (respuesta.equals(opcionesMenu[1])) {
            new MenuConversor(response.body(), myMoneda);
            preguntarSeguir();

        } else if (respuesta.equals(opcionesMenu[2])) {
            new MenuConversor(response.body(), myDistancia);
            preguntarSeguir();
        } else if (respuesta.equals(opcionesMenu[0])) {
            verDatosGuardados();
            preguntarSeguir();
        }
    }

    public static void verDatosGuardados(){
        String tiempo = LocalDateTime.now().format(
                DateTimeFormatter.ofPattern("yyyy-MM-dd HH_mm_ss"));
        String nombreArchivo = "Datos Exportados "+ tiempo +".txt";
        String calculos ="";
        for (int i = 0; i < calculosRealizados.size(); i++) {
            calculos+=calculosRealizados.get(i)+"\n";
        }
        var respuestaExportar = JOptionPane.showConfirmDialog(
                null,
                calculos + "\n\nDesea exportar los datos?",
                "Visualizacion de datos",
                JOptionPane.YES_NO_OPTION,
                JOptionPane.QUESTION_MESSAGE
        );
        if (respuestaExportar==0){
            try {
                FileWriter myFile = new FileWriter(nombreArchivo);
                myFile.write(calculos);
                myFile.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            JOptionPane.showMessageDialog(null, "Achivo creado con exito de nombre:\n" + nombreArchivo);
        }
    }

    public static void preguntarSeguir(){

        var respuesta = JOptionPane.showConfirmDialog(
                null,
                "Deseas seguir calculando?",
                null,
                JOptionPane.YES_NO_OPTION,
                JOptionPane.QUESTION_MESSAGE);
        if (respuesta==1){
            seguirCalculando = false;
        }
    }

}

