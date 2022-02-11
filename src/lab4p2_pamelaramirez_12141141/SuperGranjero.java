
package lab4p2_pamelaramirez_12141141;


public class SuperGranjero extends Aldeano {
    
    public SuperGranjero(String nombre, String apellido, int vida) {
        super(nombre, apellido, 1000);
        super.ataque = 1000;
    }
    
    public double atacar() {
        return 0.0;
    }
}
