package ia;

public class KnowledgeBase {
    

    public int gameOver(int[][] board) {
        //i = filas j = columnas
        if ((board[0][0] == board[1][1] && board[0][0] == board[2][2] && board[0][0] == 1) 
        || (board[0][2] == board[1][1] && board[0][2] == board[2][0] && board[0][2] == 1)) {
            //Humano gana por diagonal
            return 1;
        }
        if ((board[0][0] == board[1][1] && board[0][0] == board[2][2] && board[0][0] == 2) 
        || (board[0][2] == board[1][1] && board[0][2] == board[2][0] && board[0][2] == 2)) {
            //IA gana por diagonal
            return 2;
        }
        for (int i = 0; i < 3; ++i) {
            if (((board[i][0] == board[i][1] && board[i][0] == board[i][2] && board[i][0] == 1) 
            || (board[0][i] == board[1][i] && board[0][i] == board[2][i] && board[0][i] == 1))) {
                //Humano gana por fila o columna;
                return 1;
            }
        }
        for (int i = 0; i < 3; ++i) {
            if (((board[i][0] == board[i][1] && board[i][0] == board[i][2] && board[i][0] == 2) 
            || (board[0][i] == board[1][i] && board[0][i] == board[2][i] && board[0][i] == 2))) {
                //IA gana por fila o columna;
                return 2;
            }
        }        
        return -1;
    }

    public int cost(int[][] board, int player) {
        int cost = 0;
        int enemy = 0;
        if (player == 1) enemy = 2; 
        else enemy=1;
        if ((board[0][0] == board[1][1] && board[0][0] == board[2][2] && board[0][0] == player) 
            || (board[0][2] == board[1][1] && board[0][2] == board[2][0] && board[0][2] == player)) {
                //Jugada ganadora por diagonal
                cost += 100;
        }
        for (int i = 0; i < 3; ++i) {
            if (((board[i][0] == board[i][1] && board[i][0] == board[i][2] && board[i][0] == player) 
            || (board[0][i] == board[1][i] && board[0][i] == board[2][i] && board[0][i] == player))) {
                //Jugada ganadora por fila o columna;
                cost += 100;
            }
        }
        if ((board[0][0] == board[1][1] && board[0][0] == board[2][2] && board[0][0] == enemy) 
            || (board[0][2] == board[1][1] && board[0][2] == board[2][0] && board[0][2] == enemy)) {
                //Jugada ganadora por diagonal
                cost += -500;
        }
        for (int i = 0; i < 3; ++i) {
            if (((board[i][0] == board[i][1] && board[i][0] == board[i][2] && board[i][0] == enemy) 
            || (board[0][i] == board[1][i] && board[0][i] == board[2][i] && board[0][i] == enemy))) {
                //Jugada ganadora por fila o columna;
                cost += -500;
            }
        }
        

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board.length; j++) {
                 //casos en los que el jugador bloquea jugadas ganadoras
                //Por las columnas 2 enemy una player
                if (j >= 0 && j <= 2 && i == 0) {
                    if ((board[i][j] == enemy && board[i+1][j] == enemy && board[i+2][j] == player)
                    || (board[i][j] == enemy && board[i+1][j] == player && board[i+2][j] == enemy)
                    || (board[i][j] == player && board[i+1][j] == enemy && board[i+2][j] == enemy)) {
                        cost += 110;
                    }
                }
                //Por las filas 2 enemy una player
                if (i >= 0 && i <= 2 && j == 0) {
                    if ((board[i][j] == enemy && board[i][j+1] == enemy && board[i][j+2] == player)
                    || (board[i][j] == enemy && board[i][j+1] == player && board[i][j+2] == enemy)
                    || (board[i][j] == enemy && board[i][j+1] == enemy && board[i][j+2] == player)) {
                        cost += 110;
                    }
                }
                //Por la diagonal derecha 2 enemy una player
                if (i  == 0 && j == 0) {
                    if ((board[i][j] == enemy && board[i+1][j+1] == enemy && board[i+2][j+2] == player)
                    || (board[i][j] == enemy && board[i+1][j+1] == player && board[i+2][j+2] == enemy)
                    || (board[i][j] == player && board[i+1][j+1] == enemy && board[i+2][j+2] == enemy)) {
                        cost += 110;
                    }
                }
                //Por la diagonal izquierda 2 enemy una player
                if (i  == 2 && j == 2) {
                    if ((board[i][j] == enemy && board[i-1][j-1] == enemy && board[i-2][j-2] == player)
                    || (board[i][j] == enemy && board[i-1][j-1] == player && board[i-2][j-2] == enemy)
                    || (board[i][j] == player && board[i-1][j-1] == enemy && board[i-2][j-2] == enemy)) {
                        cost += 110;
                    }
                }
                //casos en los que el jugador es bloqueado
                //Por las columnas 2 llenas una vacía
                if (j >= 0 && j <= 2 && i == 0) {
                    if ( (board[i][j] == player && board[i+1][j] == player && board[i+2][j] == enemy) 
                    || (board[i][j] == player && board[i+1][j] == enemy && board[i+2][j] == player)
                    || (board[i][j] == enemy && board[i+1][j] == player && board[i+2][j] == player)){
                        cost += -510;
                    }   
                }
                //Por las filas 2 llenas una vacía
                if (i >= 0 && i <= 2 && j == 0) {
                    if ((board[i][j] == player && board[i][j+1] == player && board[i][j+2] == enemy)
                    || (board[i][j] == player && board[i][j+1] == enemy && board[i][j+2] == player)
                    || (board[i][j] == enemy && board[i][j+1] == player && board[i][j+2] == player)) {
                        cost += -510;
                    }
                }
                //Por la diagonal derecha 2 llenas una vacía
                if (i  == 0 && j == 0) {
                    if ((board[i][j] == player && board[i+1][j+1] == player && board[i+2][j+2] == enemy)
                    || (board[i][j] == player && board[i+1][j+1] == enemy && board[i+2][j+2] == player)  
                    || (board[i][j] == 0 && board[i+1][j+1] == player && board[i+2][j+2] == player)) {
                        cost += -510;
                    }
                }
                //Por la diagonal izquierda 2 llenas una vacía
                if (i  == 2 && j == 2) {
                    if ((board[i][j] == player && board[i-1][j-1] == player && board[i-2][j-2] == enemy)
                    || (board[i][j] == player && board[i-1][j-1] == enemy && board[i-2][j-2] == player)
                    || (board[i][j] == enemy && board[i-1][j-1] == player && board[i-2][j-2] == player)) {
                        cost += -510;
                    }
                }

                //casos en los que el jugador tiene 2 jugadas adyacentes
                //Por las columnas 2 llenas una vacía
                if (j >= 0 && j <= 2 && i == 0) {
                    if ( (board[i][j] == player && board[i+1][j] == player && board[i+2][j] == 0) 
                    || (board[i][j] == player && board[i+1][j] == 0 && board[i+2][j] == player)
                    || (board[i][j] == 0 && board[i+1][j] == player && board[i+2][j] == player)){
                        cost += 10;
                    }   
                }
                //Por las filas 2 llenas una vacía
                if (i >= 0 && i <= 2 && j == 0) {
                    if ((board[i][j] == player && board[i][j+1] == player && board[i][j+2] == 0)
                    || (board[i][j] == player && board[i][j+1] == 0 && board[i][j+2] == player)
                    || (board[i][j] == 0 && board[i][j+1] == player && board[i][j+2] == player)) {
                        cost += 10;
                    }
                }
                //Por la diagonal derecha 2 llenas una vacía
                if (i  == 0 && j == 0) {
                    if ((board[i][j] == player && board[i+1][j+1] == player && board[i+2][j+2] == 0)
                    || (board[i][j] == player && board[i+1][j+1] == 0 && board[i+2][j+2] == player)  
                    || (board[i][j] == 0 && board[i+1][j+1] == player && board[i+2][j+2] == player)) {
                        cost += 10;
                    }
                }
                //Por la diagonal izquierda 2 llenas una vacía
                if (i  == 2 && j == 2) {
                    if ((board[i][j] == player && board[i-1][j-1] == player && board[i-2][j-2] == 0)
                    || (board[i][j] == player && board[i-1][j-1] == 0 && board[i-2][j-2] == player)
                    || (board[i][j] == 0 && board[i-1][j-1] == player && board[i-2][j-2] == player)) {
                        cost += 10;
                    }
                }

                //casos en los que el jugador tiene 1 jugada
                //Por las columnas
                if (j >= 0 && j <= 2 && i == 0) {
                    if ( (board[i][j] == 0 && board[i+1][j] == 0 && board[i+2][j] == player) 
                    || (board[i][j] == 0 && board[i+1][j] == player && board[i+2][j] == 0)
                    || (board[i][j] == player && board[i+1][j] == 0 && board[i+2][j] == 0)){
                        cost += 5;
                    }   
                }
                //Por las filas
                if (i >= 0 && i <= 2 && j == 0) {
                    if ((board[i][j] == 0 && board[i][j+1] == 0 && board[i][j+2] == player)
                    || (board[i][j] == 0 && board[i][j+1] == player && board[i][j+2] == 0)
                    || (board[i][j] == player && board[i][j+1] == 0 && board[i][j+2] == 0)) {
                        cost += 5;
                    }
                }
                //Por la diagonal derecha
                if (i  == 0 && j == 0) {
                    if ((board[i][j] == 0 && board[i+1][j+1] == 0 && board[i+2][j+2] == player)
                    || (board[i][j] == 0 && board[i+1][j+1] == player && board[i+2][j+2] == 0)  
                    || (board[i][j] == player && board[i+1][j+1] == 0 && board[i+2][j+2] == 0)) {
                        cost += 5;
                    }
                }
                //Por la diagonal izquierda
                if (i  == 2 && j == 2) {
                    if ((board[i][j] == 0 && board[i-1][j-1] == 0 && board[i-2][j-2] == player)
                    || (board[i][j] == 0 && board[i-1][j-1] == player && board[i-2][j-2] == 0)
                    || (board[i][j] == player && board[i-1][j-1] == 0 && board[i-2][j-2] == 0)) {
                        cost += 5;
                    }
                }
            }
        }
        String jugador = player == 1 ? "Humano":"IA";
        System.out.println("Jugada de: "+ jugador +" puntuada en: " + cost);
        return cost;
    }

    public boolean isFull(int[][] board) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board.length; j++) {
                if (board[i][j] == 0) {
                    return false;
                }
            }
        }
        return true;
    }
}
