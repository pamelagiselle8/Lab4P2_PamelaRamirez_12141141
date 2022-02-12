
package lab4p2_pamelaramirez_12141141;


public class Pacifista extends Aldeano {
    String discurso;
    
    public Pacifista(String nombre, String apellido, int vida, String discurso) {
        super(nombre, apellido, vida);
        super.ataque = 0;
        this.discurso = discurso;
    }

    @Override
    public int atacar(Aldeano a) {
        System.out.println("\t Discurso del pacifista: " + discurso);
        return 0;
    }
}
