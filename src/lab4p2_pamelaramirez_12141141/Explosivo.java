
package lab4p2_pamelaramirez_12141141;


public class Explosivo extends Aldeano {

    public Explosivo(String nombre, String apellido, int vida) {
        super(nombre, apellido, vida);
        super.ataque = 250;
    }
    
    public double atacar() {
        return 0.0;
    }
}
