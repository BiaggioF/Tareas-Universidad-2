import java.util.List;
import java.util.Random;

public class Galgos extends Thread {
    private String nombre;
    private int tiempoCarrera;
    private List<String> ordenLlegada;

    public Galgos(String nombre, int tiempoCarrera, List<String> ordenLlegada) {
        Random random = new Random();
        this.nombre = nombre;
        this.tiempoCarrera = tiempoCarrera;
        this.ordenLlegada = ordenLlegada;
    }

    @Override
    public void run() {
        try {
          
            Thread.sleep(tiempoCarrera);
            System.out.println(nombre + " ha terminado la carrera.");
            
            // Asegurar acceso seguro a la lista compartida
            synchronized (ordenLlegada) {
                ordenLlegada.add(nombre);  
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
