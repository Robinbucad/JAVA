package org;
import java.util.*;
import java.io.*;

public class main_persona {

    public static void main(String[] args){

    List<persona> listaPersonas = new ArrayList<>();
    String [] split;
    String linea = "";
    String pathFile = "C:\\Users\\robin.bucad\\Desktop\\EjerciciosBosonit\\refactor\\src\\main\\java\\org\\datos.txt";


    try{
        FileReader archivo = new FileReader(pathFile);
        BufferedReader brArchivo = new BufferedReader(archivo);

        while ((linea = brArchivo.readLine()) != null){
            split = linea.split(":");
            persona persona = new persona();

            if (split.length<=3){
                persona.setName(split[0]);

                if (split[1].isEmpty()){
                    persona.setPoblacion("Desconocida");
                }else {
                    persona.setPoblacion(split[1]);
                }

            }else {
                persona.setName("Desconocida");
            }

            if (split.length > 2){
                persona.setEdad(split[2]);
            }else {
                persona.setEdad("Desconocida");
            }

            listaPersonas.add(persona);

        }

        brArchivo.close();

    }catch (IOException e){
        System.out.println("Error al leer el archivo");
    }

    listaPersonas.stream()
            .filter(p-> p.getName()!=null && p.getPoblacion() != null && p.getEdad().get() !=
                    "Desconocida"  && Integer.parseInt(p.getEdad().get()) < 25)

            .forEach(p-> System.out.println("Nombre:" + p.getName() + " Población:" + p.getPoblacion()+ " Edad:" + p.getEdad()));

    }

}
