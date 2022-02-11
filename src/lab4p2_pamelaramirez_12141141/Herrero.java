
package lab4p2_pamelaramirez_12141141;

import java.util.Random;


public class Herrero extends Aldeano {
    Random r = new Random();

    public Herrero(String nombre, String apellido, int vida) {
        super(nombre, apellido, vida);
        super.ataque = 200 + r.nextInt(500);
        super.vida = vida + (vida/2);
    }

    public double atacar() {
        return 0.0;
    }
}
