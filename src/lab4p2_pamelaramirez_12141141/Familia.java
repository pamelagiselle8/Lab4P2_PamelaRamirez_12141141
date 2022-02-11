
package lab4p2_pamelaramirez_12141141;

import java.util.ArrayList;


public class Familia {
    String apellido;
    ArrayList <Aldeano> aldeano = new ArrayList();

    public Familia(String apellido) {
        this.apellido = apellido;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public ArrayList<Aldeano> getAldeano() {
        return aldeano;
    }

    public void setAldeano(ArrayList<Aldeano> aldeano) {
        this.aldeano = aldeano;
    }

    @Override
    public String toString() {
        return "\n Familia " + apellido + ":"
                + "\n Integrantes: " + aldeano;
    }
    
    
}
