
package lab4p2_pamelaramirez_12141141;


public class Normal extends Aldeano {

    public Normal(String nombre, String apellido, int vida) {
        super(nombre, apellido, vida);
        super.ataque = 50;
    }

    @Override
    public int atacar(Aldeano a) {
        if (a instanceof Pacifista) {
            super.ataque += (int) (super.ataque * 0.05);
        }
        return super.ataque;
    }
}
