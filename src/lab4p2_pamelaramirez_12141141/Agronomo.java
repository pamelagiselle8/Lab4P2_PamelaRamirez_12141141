
package lab4p2_pamelaramirez_12141141;

import java.util.Random;


public class Agronomo extends Aldeano {
    Random r = new Random();

    public Agronomo(String nombre, String apellido, int vida) {
        super(nombre, apellido, vida);
        super.ataque = 100;
    }

    @Override
    public int atacar(Aldeano a) {
        if (a instanceof Pacifista) {
            super.ataque += (int) (super.ataque * 0.05);
        }
        else if (a instanceof Normal) {
            super.ataque += (int) (super.ataque * 0.10);
        }
        int pos = 1 + r.nextInt(99);
        if (pos < 5) {
            super.ataque = 0;
        }
        return super.ataque;
    }
}
