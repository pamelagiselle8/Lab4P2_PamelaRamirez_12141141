/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab4p2_pamelaramirez_12141141;

/**
 *
 * @author pame
 */
public class Aldeano {
    String nombre;
    String apellido;

    public Aldeano() {
    }

    public Aldeano(String nombre, String apellido) {
        this.nombre = nombre;
        this.apellido = apellido;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    @Override
    public String toString() {
        return "Aldeano{" + "nombre=" + nombre + ", apellido=" + apellido + '}';
    }
    
    
}
