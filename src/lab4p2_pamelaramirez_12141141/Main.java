
package lab4p2_pamelaramirez_12141141;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;


public class Main {
    static Scanner lea = new Scanner(System.in);
    static ArrayList <Familia> familias = new ArrayList();
    
    public static void main(String[] args) {
        familias.add(new Familia("Montesco"));
        familias.get(0).getAldeano().add(new SuperGranjero("Romeo", "Montesco", 1000));
        familias.get(0).getAldeano().add(new Herrero("Pedro", "Montesco", 1000));
        familias.get(0).getAldeano().add(new Agronomo("Juan", "Montesco", 1000));
        familias.add(new Familia("Capuleto"));
        familias.get(1).getAldeano().add(new Normal("Julieta", "Capuleto", 100));
        familias.get(1).getAldeano().add(new Herrero("Fulanito", "Capuleto", 100));
        familias.get(1).getAldeano().add(new Normal("Mengana", "Capuleto", 100));
        familias.add(new Familia("Molina"));
        familias.get(2).getAldeano().add(new Pacifista("James", "Molina", 100, "No pelien"));
        familias.get(2).getAldeano().add(new Normal("Papá de James", "Molina", 100));
        familias.get(2).getAldeano().add(new Normal("Mamá de James", "Molina", 100));
        Collections.shuffle(familias);
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
                for (Familia f : familias) {
                    System.out.println(f);
                }
                ejecutar();
                break;
            }
            case 4: {
                for (Familia f : familias) {
                    Collections.shuffle(f.getAldeano());
                }
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
    
    static boolean validarFamilia(String apellido){
        boolean existe = false;
        for (Familia f : familias) {
            if (f.apellido.equalsIgnoreCase(apellido)) {
                existe = true;
            }
        }
        return existe;
    }
    
    static void agregarFamilia(){
        System.out.print("\n Ingrese el apellido de la familia: ");
        String apellido = lea.next();
        if (validarFamilia(apellido) == false) {
            familias.add(new Familia(apellido));
        }
        else{
            System.out.println("\n No pueden haber dos familias con el mismo apellido. \n");
        }
    }
    
    static void agregarAldeano(){
        System.out.print("\n Ingrese el apellido de la familia: ");
        String apellido = lea.next();
        if (validarFamilia(apellido)) {
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
            pos = familias.indexOf(f);
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
        
    }
    
}
