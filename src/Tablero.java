
public class Tablero {
    private char[][] tablero;

    public Tablero(){
        tablero = new char[3][3];
        for (int f = 0; f < 3; f++){
            for (int c = 0; c < 3; c++ ){
                tablero[f][c] = '-';

            }
        }
    }



    public void mostrarTablero(){
        for (int f = 0; f < 3; f++){
            for (int c = 0; c < 3; c++ ){
                System.out.print(tablero[f][c] + " ");
            }
            System.out.println();
        }


    }

    public boolean casillaDisponible(int fila, int columna){
        return tablero[fila][columna] == '-';
    }

    public void marcarCasilla(int fila, int columna, Jugador jugador){
        tablero[fila][columna] = jugador.getFicha();

    }

    public boolean hayGanador(){
        // verificar filas
        for (int f = 0; f < 3; f++){
            if (tablero[f][0] != '-' && tablero[f][0] == tablero[f][1] && tablero[f][0] == tablero[f][2]){
                return true;

            }
        }

        // verificar columnas

        for (int c = 0; c < 3; c++){
            if (tablero[0][c] != '-' && tablero[0][c] == tablero[1][c] && tablero[0][c] == tablero[2][c]){
                return true;

            }
        }

        //verificar diagonales
        if (tablero[0][0] != '-' && tablero[0][0] == tablero[1][1] && tablero[0][0] == tablero[2][2]) {
            return true;
        }
        if (tablero[0][2] != '-' && tablero[0][2] == tablero[1][1] && tablero[0][2] == tablero[2][0]) {
            return true;
        }

        return false;


    }



    public boolean hayCasillasDisponibles(){
        for (int f = 0; f < 3; f++){
            for (int c = 0; c < 3; c++){
                if (tablero[f][c] == '-'){
                    return true;
                }
            }
        }
        return false;
    }

    public boolean hayEmpate(){
        return !hayCasillasDisponibles() && !hayGanador();
    }










}
