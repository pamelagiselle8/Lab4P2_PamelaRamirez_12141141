
package lab4p2_pamelaramirez_12141141;


public abstract class Aldeano {
    String nombre;
    String apellido;
    int vida;
    int ataque;

    public Aldeano(String nombre, String apellido, int vida) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.vida = vida;
    }
    
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }
    
    public abstract double atacar();

    //@Override
    public String toString() {
        return "\n \t Nombre: " + nombre
                + "\n \t Apellido " + apellido
                + "\n \t Vida: " + vida
                + "\n \t Ataque: " + ataque + "\n";
    }
    
    
}
