
package lab4p2_pamelaramirez_12141141;


public class Normal extends Aldeano {

    public Normal(String nombre, String apellido, int vida) {
        super(nombre, apellido, vida);
        super.ataque = 50;
    }
    
    public double atacar() {
        return 0.0;
    }
}
