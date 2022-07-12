import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class main_persona {
    public static void main (String[] args){
        List <Persona> listaPersonas = new ArrayList<>(); // Creo clase ArrayList, para almacenar datos como si fuera un Array.
        String [] split; // Separo los datos segun la posicion del ":"
        String linea = "";

        try{
            FileReader archivo = new FileReader("C:\\Users\\robin.bucad\\Desktop\\EjerciciosBosonit\\Ej1Streams\\src\\datos.txt");
            BufferedReader bufferArchivo = new BufferedReader(archivo); // Leo el fichero


            while ((linea = bufferArchivo.readLine()) != null){

                split = linea.split(":"); // Separo los datos

                Persona persona = new Persona();

                if (split.length <= 3){ //Si detecta 3 separaciones o menos, guardo el nombre de la persona en la primera posicion del array.
                    persona.establece_nombre(split[0]);

                    if (split[1].isEmpty()){
                        persona.establece_poblacion("Desconocida");
                    }else { // Guardo el dato en la segunda posición del array
                        persona.establece_poblacion(split[1]);
                    }

                }else {
                    persona.establece_nombre("Desconocida");
                }


                if (split.length > 2){
                    persona.establece_edad(split[2]);
                }else {
                    persona.establece_edad("Desconocida");
                }

                listaPersonas.add(persona); //Meto los datos guardados en el array.

            }

            bufferArchivo.close();

        }catch (IOException e){
            System.out.println("Error al leer el archivo");
        }

        listaPersonas.stream()
                .filter(persona -> persona.dime_nombre() != null && persona.dime_poblacion() != null
                && persona.dime_edad().get() != "Desconocida" && Integer.parseInt(persona.dime_edad().get()) < 25) // Busco los datos según el ejercicio
                .forEach(persona -> System.out.println("Nombre: " + persona.dime_nombre() + ". Población:" + persona.dime_poblacion() + ".Edad:" + persona.dime_edad()));

    }
}
