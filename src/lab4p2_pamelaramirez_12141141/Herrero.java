
package lab4p2_pamelaramirez_12141141;

import java.util.Random;


public class Herrero extends Aldeano {
    Random r = new Random();

    public Herrero(String nombre, String apellido, int vida) {
        super(nombre, apellido, vida);
        super.ataque = 200 + r.nextInt(300);
        super.vida = vida + (vida/2);
    }

    @Override
    public int atacar(Aldeano a) {
        if (a instanceof Pacifista) {
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
