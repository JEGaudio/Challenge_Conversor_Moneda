package com.github.ConversorMoneda.modelos;

public class Distancia extends Conversiones {
    public Distancia(){
        //valores de conversion 1 unidad = x metros
        agregarDicc("Metro",1);
        agregarDicc("Centimetro",0.01);
        agregarDicc("Milimetro",0.001);
        agregarDicc("Kilometro",1000);
        agregarDicc("Pulgada",0.0254);
        agregarDicc("Pie",0.3048 );
        agregarDicc("Yarda",0.9144 );
        agregarDicc("Milla",1609.344);
        agregarDicc("Legua",4828.032);


        setOpcionesMenu(new String[]{
            "Metro",
            "Centimetro",
            "Milimetro",
            "Kilometro",
            "Pulgada",
            "Pie",
            "Yarda",
            "Milla",
            "Legua"
        });

        setOpcionesDiccionario(new String[] {
                "Pulg",
                "Pie",
                "Yarda",
                "Milla",
                "Legua"
        });
    }
}
