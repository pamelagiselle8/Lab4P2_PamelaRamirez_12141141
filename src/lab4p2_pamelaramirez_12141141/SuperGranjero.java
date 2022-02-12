
package lab4p2_pamelaramirez_12141141;


public class SuperGranjero extends Aldeano {
    
    public SuperGranjero(String nombre, String apellido, int vida) {
        super(nombre, apellido, 1000);
        super.ataque = 1000;
    }

    @Override
    public int atacar(Aldeano a) {
        if (a instanceof Herrero) {
            super.ataque += (int) (super.ataque * 0.10);
        }
        else if (a instanceof Explosivo) {
            super.ataque += (int) (super.ataque * 0.15);
        }
        return super.ataque;
    }
}
