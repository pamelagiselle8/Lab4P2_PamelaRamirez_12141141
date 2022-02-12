
package lab4p2_pamelaramirez_12141141;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Main {
    static Scanner lea = new Scanner(System.in);
    static ArrayList <Familia> familias = new ArrayList();
    static Familia capuleto = new Familia("Capuleto");
    static Aldeano julieta = new Normal("Julieta", "Capuleto", 100);
    static Familia montesco = new Familia("Montesco");
    
    public static void main(String[] args) {
        capuleto.getAldeano().add(new Normal("Fulanito", "Capuleto", 100));
        capuleto.getAldeano().add(new Normal("Mengana", "Capuleto", 100));
        montesco.getAldeano().add(new SuperGranjero("Romeo", "Montesco", 1000));
        montesco.getAldeano().add(new Herrero("Pedro", "Montesco", 100));
        montesco.getAldeano().add(new Agronomo("Juan", "Montesco", 100));
        familias.add(new Familia("Molina"));
        familias.get(0).getAldeano().add(new Pacifista("James", "Molina", 100, "No pelien"));
        familias.get(0).getAldeano().add(new Normal("Papá de James", "Molina", 100));
        familias.get(0).getAldeano().add(new Herrero("Mamá de James", "Molina", 100));
        ejecutar();
    }
    
    static int menú(){
        System.out.print("\n Menú:"
                + "\n 1. Agregar familia."
                + "\n 2. Agregar aldeano."
                + "\n 3. Mostrar familias."
                + "\n 4. Comenzar."
                + "\n 5. Salir."
                + "\n Ingrese una opción: ");
        int op = lea.nextInt();
        System.out.println();
        return op;
    }
    
    static void ejecutar(){
        switch(menú()){
            case 1: {
                agregarFamilia();
                ejecutar();
                break;
            }
            case 2: {
                agregarAldeano();
                ejecutar();
                break;
            }
            case 3: {
                System.out.print(capuleto);
                System.out.println(julieta);
                System.out.println(montesco);
                for (Familia f : familias) {
                    System.out.println(f);
                }
                ejecutar();
                break;
            }
            case 4: {
                comenzar();
                ejecutar();
                break;
            }
            case 5: {
                System.exit(0);
                break;
            }
            default: {
                System.out.println("\n Ingrese una opción válida. \n");
                ejecutar();
                break;
            }
        }
    }
    
    static boolean validarApellido(String apellido){
        boolean existe = false;
        for (Familia f : familias) {
            if (f.apellido.equalsIgnoreCase(apellido)
                    || apellido.equalsIgnoreCase("Capuleto")
                    ||  apellido.equalsIgnoreCase("Montesco")) {
                existe = true;
            }
        }
        return existe;
    }
    
    static void agregarFamilia(){
        System.out.print("\n Ingrese el apellido de la familia: ");
        String apellido = lea.next();
        if (validarApellido(apellido)) {
            System.out.println("\n No pueden haber dos familias con el mismo apellido. \n");
        }
        else{
            familias.add(new Familia(apellido));
            System.out.println("\n Familia agregada. \n");
        }
    }
    
    static void agregarAldeano(){
        System.out.print("\n Ingrese el apellido de la familia: ");
        String apellido = lea.next();
        if (validarApellido(apellido)) {
            int pos = buscarFamilia(apellido);
            System.out.print("Ingrese el nombre del aldeano: ");
            String nombre = lea.next();
            System.out.print("Ingrese la vida del aldeano: ");
            int vida = lea.nextInt();
            for (Familia f : familias) {
                if (f.apellido.equalsIgnoreCase(apellido)) {
                    menuAldeano(nombre, apellido, vida, pos);
                }
            }
        }
        else{
            System.out.println("\n No existe una familia con el apellido ingresado. \n");
        }
    }
    
    static int buscarFamilia(String apellido){
        int pos = 0;
        for (Familia f : familias) {
            if (f.apellido.equalsIgnoreCase(apellido)) {
                pos = familias.indexOf(f);
            }
        }
        return pos;
    }
    
    static void menuAldeano(String nombre, String apellido, int vida, int pos){
        System.out.print("\n Tipos de aldeanos:"
                + "\n 1. Normal."
                + "\n 2. Pacifista."
                + "\n 3. Herrero."
                + "\n 4. Agrónomo."
                + "\n 5. Explosivo."
                + "\n Ingrese una opción: ");
        int op = lea.nextInt();
        switch(op){
            case 1: {
                familias.get(pos).getAldeano().add(new Normal(nombre, apellido, vida));
                break;
            }
            case 2: {
                System.out.print("Ingrese el discurso: ");
                String dis = lea.nextLine();
                dis = lea.nextLine();
                familias.get(pos).getAldeano().add(new Pacifista(nombre, apellido, vida, dis));
                break;
            }
            case 3: {
                familias.get(pos).getAldeano().add(new Herrero(nombre, apellido, vida));
                break;
            }
            case 4: {
                familias.get(pos).getAldeano().add(new Agronomo(nombre, apellido, vida));
                break;
            }
            case 5: {
                familias.get(pos).getAldeano().add(new Explosivo(nombre, apellido, vida));
                break;
            }
            default: {
                System.out.println("\n Ingrese una opción válida. \n");
                menuAldeano(nombre, apellido, vida, pos);
                break;
            }
        }
    }
   
    static void comenzar(){
        System.out.print("\n Ingrese el apellido de la familia que peleará primero: ");
        String apellido = lea.next();
        System.out.println();
        if (validarApellido(apellido)) {
            if (apellido.equalsIgnoreCase("Montesco") || apellido.equalsIgnoreCase("Capuleto")) {
                System.out.println(" Debe ingresar una familia que no sea Montesco o Capuleto. \n");
                comenzar();
            }
            else{
                pelea(familias.get(buscarFamilia(apellido)));
                while (familias.isEmpty() == false) {
                    System.out.println("\n" + montesco.apellido + " vs. " + familias.get(0).apellido + "\n");
                    Collections.shuffle(familias);
                    pelea(familias.get(0));
                    if (validarFamiliares(familias.get(0)) == false) {
                        familias.remove(0);
                    }
                    else{
                        break;
                    }
                }
                if (montesco.aldeano.isEmpty()) {
                    System.out.println("\n ¡aGana la familia Capuleto! \n");
                }
                else{
                    pelea(capuleto);
                    if (montesco.aldeano.isEmpty()) {
                        System.out.println("\n ¡Gana la familia Capuleto! \n");
                    }
                    else{
                        System.out.println("\n ¡Gana la familia Montesco! \n");
                    }
                }
            }
        }
        else{
            System.out.println("\n No hay ninguna familia registrada con el apellido ingresado. \n");
            comenzar();
        }
    }
    
    static void pelea(Familia fam){
        while (validarFamiliares(fam) && validarFamiliares(montesco)){
            if (fam.aldeano.get(0).nombre != "Julieta") {
                Collections.shuffle(montesco.aldeano);
                Collections.shuffle(fam.aldeano);
                Aldeano b = montesco.getAldeano().get(0);
                Aldeano a = fam.getAldeano().get(0);
                Aldeano c;
                int vida1 = b.vida;
                int vida2 = a.vida;
                while (montesco.aldeano.get(0).vida > 0 && fam.aldeano.get(0).vida > 0){
                    c = a;
                    a = b;
                    b = c;
                    pvp(a, b);
                }
                if (montesco.aldeano.get(0).vida < 0) {
                    System.out.println("\n" + "\t + " + fam.aldeano.get(0).nombre
                            + " ha derrotado a " + montesco.aldeano.get(0).nombre + "\n");
                    montesco.aldeano.remove(0);
                    fam.aldeano.get(0).setVida(vida2);
                }
                else{
                    System.out.println("\n" + "\t + " + montesco.aldeano.get(0).nombre
                            + " ha derrotado a " + fam.aldeano.get(0).nombre + "\n");
                    fam.aldeano.remove(0);
                    montesco.aldeano.get(0).setVida(vida1);
                }
            }
        }
    }
    
    static void pvp(Aldeano a, Aldeano b){
        int dano = a.atacar(b);
        if (dano > 0) {
            if (a instanceof Explosivo) {
                for (Aldeano x : montesco.aldeano) {
                    x.setVida(x.vida - dano);
                }
                int x = buscarFamilia(b.apellido);
                for (Aldeano y : familias.get(x).aldeano) {
                    y.setVida(y.vida - dano);
                }
                System.out.println("¡" + a.nombre + " ataca a " + b.nombre
                    + ", la familia de él y la propia haciéndoles a todos "
                    + dano + " de daño! Dejándolo(a) " + b.nombre + " con " + b.vida + " de vida.");
            }
            else{
                b.setVida(b.vida - dano);
                System.out.println("¡" + a.nombre + " ataca a " + b.nombre + " haciéndole "
                                    + dano + " de daño! Dejándolo(a) con " + b.vida + " de vida.");
            }
        }
        else{
            if (a instanceof Pacifista) {
                System.out.println("¡" + a.nombre + " no ataca a " + b.nombre
                        + "! En vez de eso, dice el siguiente discurso: " + ((Pacifista) a).discurso);
            }
            else{
                System.out.println("\n \t - ¡" + a.nombre + " falla el ataque! \n");
            }
        }
    }
    
    static boolean validarFamiliares(Familia f){
        boolean sepuede = true;
        if (f.aldeano.isEmpty()) {
            sepuede = false;
        }
        return sepuede;
    }
    
}
