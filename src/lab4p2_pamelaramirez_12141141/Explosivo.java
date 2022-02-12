
package lab4p2_pamelaramirez_12141141;

import java.util.Random;


public class Explosivo extends Aldeano {
    Random r = new Random();
    
    public Explosivo(String nombre, String apellido, int vida) {
        super(nombre, apellido, vida);
        super.ataque = 250;
    }

    @Override
    public int atacar(Aldeano a) {
        if (a instanceof Herrero) {
            super.ataque += (int) (super.ataque * 0.05);
        }
        else if (a instanceof Agronomo) {
            super.ataque += (int) (super.ataque * 0.10);
        }
        int pos = 1 + r.nextInt(99);
        if (pos < 10) {
            super.ataque = 0;
        }
        return super.ataque;
    }
    
}
