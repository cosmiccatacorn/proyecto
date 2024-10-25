import java.util.Scanner;
import java.util.Random;
public class BatallaNaval {
    static char [][] tablero = new char[6][6];
        static int barcosRestantes = 5;
        static Scanner scanner = new Scanner(System.in);
        
    public static void main(String[] args) {
        inicializarTablero();
        colocarBarcos();
        jugar();
    }    
    public static void inicializarTablero(){
        for(int i = 0; i < 6; i++) {
            for(int j = 0; j < 6; j++) {
                tablero[i][j] = '~';                
            }                
        }
    }
    
    public static void colocarBarcos() {
        Random random = new Random();
        int barcosColocados = 0;
               
        while(barcosColocados < 5) {
            int fila = random.nextInt(6);
            int columna = random.nextInt(6);
            
        if(tablero[fila][columna] == '~') {
            tablero[fila][columna] = 'B';
            barcosColocados++;
            
        }        
    }
}
    public static void jugar(){
        while (barcosRestantes > 0) {
            mostrarTablero(false); 

            System.out.println("Introduce las coordenadas para atacar (fila y columna de 0 a 6):");
            System.out.print("Fila: ");
            int fila = scanner.nextInt();
            System.out.print("Columna: ");
            int columna = scanner.nextInt();

            if (fila < 0 || fila > 5 || columna < 0 || columna > 5) {
                System.out.println("Coordenadas fuera de rango. Inténtalo de nuevo.");
                continue;
            }

            if (tablero[fila][columna] == 'B') {
                System.out.println("¡Has hundido un barco!");
                tablero[fila][columna] = 'X'; 
                barcosRestantes--;
            } else if (tablero[fila][columna] == 'X' || tablero[fila][columna] == 'O') {
                System.out.println("Ya has atacado esta posición. Intenta en otra parte.");
            } else {
                System.out.println("Has fallado.");
                tablero[fila][columna] = 'O'; 
            }

            System.out.println("Barcos restantes: " + barcosRestantes);
        }
        System.out.println("¡Felicidades! Has hundido todos los barcos.");
        mostrarTablero(true); 
    }

    public static void mostrarTablero(boolean mostrarBarcos) {
        System.out.println("Tablero actual:");

        for (int i = 0; i < 6; i++) {
            for (int j = 0; j < 6; j++) {
                if (tablero[i][j] == 'B' && !mostrarBarcos) {
                    System.out.print("~ "); 
                } else {
                    System.out.print(tablero[i][j] + " ");
                }
            }
            System.out.println();
        }
    }
}
