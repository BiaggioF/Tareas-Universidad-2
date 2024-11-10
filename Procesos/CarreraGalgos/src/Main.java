import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);
        int numeroGalgos = 0;
        
        //solicitamos el numero de galgos al usuario del 1 al 5
        boolean entradaValida = false;
        while (!entradaValida) {
            System.out.println("Ingresa el número de galgos (del 1 al 5): ");
            if (entrada.hasNextInt()) {  
                numeroGalgos = entrada.nextInt();
                if (numeroGalgos >= 1 && numeroGalgos <= 5) {
                    entradaValida = true; 
                } else {
                    System.out.println("Por favor, ingresa un número entre 1 y 5.");
                }
            } else {
                System.out.println("Entrada no válida. Debes ingresar un número entre 1 y 5.");
                entrada.next();
            }
        }
        
     //agregamos los galgos a una Lista, a medida de que se crean se le asigna un numero
        List<String> ordenLlegada = new ArrayList<>();
        
       
        List<Galgos> galgos = new ArrayList<>();
        for (int i = 1; i <= numeroGalgos; i++) {
            System.out.println("Ingresa el tiempo de carrera para el galgo " + i + " en milisegundos: ");
            int tiempoCarrera = entrada.nextInt();
            
         
            Galgos galgo = new Galgos("Galgos " + i, tiempoCarrera, ordenLlegada);
            galgos.add(galgo);
        }
        
      //iniciamos todos los galgos al mismo tiempo con un bucle for
        for (Galgos galgo : galgos) {
            galgo.start();
        }
        
      
        for (Galgos galgo : galgos) {
            try {
                galgo.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        
     //imprimimos el orden en el que han acabado
        System.out.println("\nOrden de llegada:");
        for (int i = 0; i < ordenLlegada.size(); i++) {
            System.out.println((i + 1) + ". " + ordenLlegada.get(i));
        }
    }
}