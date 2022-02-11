
package lab4p2_pamelaramirez_12141141;


public class Agronomo extends Aldeano {

    public Agronomo(String nombre, String apellido, int vida) {
        super(nombre, apellido, vida);
        super.ataque = 100;
    }
    
    public double atacar() {
        return 0.0;
    }
}
