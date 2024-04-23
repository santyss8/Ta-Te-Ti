import java.util.Scanner;
import java.util.InputMismatchException;


public class TaTeTi {
    // Atributos
    private Jugador jugadorX;
    private Jugador jugadorO;
    private Jugador turno;
    private Tablero tablero;
    private Scanner scanner;

    // constructor

    public TaTeTi(){
        jugadorX = new Jugador('X');
        jugadorO = new Jugador('O');
        turno = jugadorX;
        tablero = new Tablero();
        scanner = new Scanner(System.in);
    }

    // metodos

    public void jugar(){
        boolean juegoTerminado = false;

        while (!juegoTerminado){
            tablero.mostrarTablero();
            System.out.println("Turno del jugador: " + turno.getFicha());

            int fila,columna;
            try {
                do {
                    System.out.println("Ingrese la fila (1-3): ");
                    fila = scanner.nextInt() -1;
                    System.out.println("Ingrese la columna (1-3): ");
                    columna = scanner.nextInt() -1;
                }while (!esCasillaValida(fila, columna));{
                    tablero.marcarCasilla(fila, columna, turno);
                    if (tablero.hayGanador()){
                        tablero.mostrarTablero();
                        System.out.println("¡¡¡El jugador " + turno.getFicha() + " Ha Ganado!!!");
                        juegoTerminado = true;
                    } else if (tablero.hayEmpate()) {
                        tablero.mostrarTablero();
                        System.out.println("Hay un empate");
                        juegoTerminado = true;

                    }else {
                        cambiarTurno();
                    }
                }

            }catch (InputMismatchException e){
                System.out.println("Error: Tienes que ingresar numeros");
                scanner.nextLine();

            }catch (Exception e){
                System.out.println("Ha ocurrido un error");
            }

        }



    }

    private boolean esCasillaValida(int fila, int columna) {
        if (fila < 0 || fila >= 3 || columna < 0 || columna >= 3) {
            System.out.println("¡Posición fuera del tablero!");
            return false;
        } else if (!tablero.casillaDisponible(fila, columna)) {
            System.out.println("¡La casilla ya está ocupada!");
            return false;
        }
        return true;
    }

    private void cambiarTurno() {
        turno = (turno == jugadorX) ? jugadorO : jugadorX;
    }

















}
