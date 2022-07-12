
import java.io.*;
import java.util.Optional;

public class Persona {

    private String nombre;
    private String poblacion;
    private String edad;

    public Persona(){

    }

    public Optional<String> dime_nombre(){
        return Optional.ofNullable(nombre);
    }

    public void establece_nombre(String nombre) {
        this.nombre = nombre;
    }

    public Optional<String> dime_poblacion(){
        return Optional.ofNullable(poblacion);
    }

    public void establece_poblacion(String poblacion){
        this.poblacion = poblacion;
    }

    public Optional <String> dime_edad(){
        return Optional.ofNullable(edad);
    }

    public void establece_edad(String edad){
        this.edad = edad;
    }


}
