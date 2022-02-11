
package lab4p2_pamelaramirez_12141141;


public class Pacifista extends Aldeano {
    String discurso;
    
    public Pacifista(String nombre, String apellido, int vida, String discurso) {
        super(nombre, apellido, vida);
        super.ataque = 0;
        this.discurso = discurso;
    }

    public String getDiscurso() {
        return discurso;
    }

    public void setDiscurso(String discurso) {
        this.discurso = discurso;
    }
    
    public double atacar() {
        return 0.0;
    }
}
