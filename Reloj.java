package Runnable.Reloj;

public class Reloj implements Runnable {
    private int segundosTranscurridos;

    public void run() {
        while (true) {
            try {
                Thread.sleep(1000); // Espera 1 segundo
                segundosTranscurridos++;
            } catch (InterruptedException ex) {
                // Manejar la excepción
            }
        }
    }

    public void mostrarTiempo() {
        int horas = segundosTranscurridos / 3600;
        int minutos = (segundosTranscurridos % 3600) / 60;
        int segundos = segundosTranscurridos % 60;

        System.out.printf("%02d:%02d:%02d\n", horas, minutos, segundos);
    }

    public static void main(String[] args) {
        Reloj reloj = new Reloj();
        Thread hiloReloj = new Thread(reloj);
        hiloReloj.start();

        while (true) {
            reloj.mostrarTiempo();

            try {
                Thread.sleep(1000); // Espera 1 segundo antes de mostrar el tiempo de nuevo
            } catch (InterruptedException ex) {
                // Manejar la excepción
            }
        }
    }
}
