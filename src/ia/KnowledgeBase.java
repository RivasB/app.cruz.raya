package ia;

public class KnowledgeBase {
    

    public int gameOver(int[][] board) {
        //i = filas j = columnas
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board.length; j++) {
                //Ganador por columnas
                if (j >= 0 && j <= 2 && i == 0) {
                    if (board[i][j] == 1 && board[i+1][j] == 1 && board[i+2][j] == 1) {
                        return 1;
                    }
                    else if (board[i][j] == 2 && board[i+1][j] == 2 && board[i+2][j] == 2) {
                        return 2;
                    }
                    else System.out.println("Nadie gana por columnas"); return -1; 
                }
                //Ganador por columnas
                if (i >= 0 && i <= 2 && j == 0) {
                    if (board[i][j] == 1 && board[i][j+1] == 1 && board[i][j+2] == 1) {
                        return 1;
                    }
                    else if (board[i][j] == 2 && board[i][j+1] == 2 && board[i][j+2] == 2) {
                        return 2;
                    }
                    else System.out.println("Nadie gana por filas"); return -1;
                }
                //Ganador diagonal principal izquierda-derecha
                if (i  == 0 && j == 0) {
                    if (board[i][j] == 1 && board[i+1][j+1] == 1 && board[i+2][j+2] == 1) {
                        return 1;
                    }
                    else if (board[i][j] == 2 && board[i+1][j+1] == 2 && board[i+2][j+2] == 2) {
                        return 2;
                    }
                    else System.out.println("Nadie gana por diagonal derecha"); return -1;
                }
                //Ganador diagonal principal derecha-izquierda
                if (i  == 2 && j == 2) {
                    if (board[i][j] == 1 && board[i-1][j-1] == 1 && board[i-2][j-2] == 1) {
                        return 1;
                    }
                    else if (board[i][j] == 2 && board[i-1][j-1] == 2 && board[i-2][j-2] == 2) {
                        return 2;
                    }
                    else System.out.println("Nadie gana por diagonal izquierda"); return -1;
                }
            }
        }        
        return -1;
    }

    public int cost(int[][] board, int player) {
        int cost = 0;
        int enemy = 0;
        if (player == 1) enemy = 2; 
        else enemy=1;
        if ((board[0][0] == enemy
        || board[0][2] == enemy  
        || board[2][0] == enemy
        || board[2][2] == enemy) 
        && board[1][1] == player) {
            cost += 10000;
        }
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board.length; j++) {
                //casos en los que el jugador hace una jugada ganadora
                //llenando cualquier fila
                if (j >= 0 && j <= 2 && i == 0) {
                    if (board[i][j] == player && board[i+1][j] == player && board[i+2][j] == player) {
                        cost += 500;
                    }
                }
                //llenando cualquier columna
                if (i >= 0 && i <= 2 && j == 0) {
                    if (board[i][j] == player && board[i][j+1] == player && board[i][j+2] == player) {
                        cost += 500;
                    }
                }
                //llenando diagonal derecha
                if (i  == 0 && j == 0) {
                    if (board[i][j] == player && board[i+1][j+1] == player && board[i+2][j+2] == player) {
                        cost += 500;
                    }
                }
                //llenando diagonal izquierda
                if (i  == 2 && j == 2) {
                    if (board[i][j] == player && board[i-1][j-1] == player && board[i-2][j-2] == player) {
                        cost += 500;
                    }
                }
                
                
                //casos en los que el jugador tiene 2 jugadas adyacentes
                //Por las columnas 2 llenas una vacía
                if (j >= 0 && j <= 2 && i == 0) {
                    if (board[i][j] == player && board[i+1][j] == player && board[i+2][j] == 0) {
                        cost += 100;
                    }
                    if (board[i][j] == player && board[i+1][j] == 0 && board[i+2][j] == player) {
                        cost += 100;
                    }
                    if (board[i][j] == 0 && board[i+1][j] == player && board[i+2][j] == player) {
                        cost += 100;
                    }
                }
                //Por las filas 2 llenas una vacía
                if (i >= 0 && i <= 2 && j == 0) {
                    if (board[i][j] == player && board[i][j+1] == player && board[i][j+2] == 0) {
                        cost += 100;
                    }
                    if (board[i][j] == player && board[i][j+1] == 0 && board[i][j+2] == player) {
                        cost += 100;
                    }
                    if (board[i][j] == 0 && board[i][j+1] == player && board[i][j+2] == player) {
                        cost += 100;
                    }
                }
                //Por la diagonal derecha 2 llenas una vacía
                if (i  == 0 && j == 0) {
                    if (board[i][j] == player && board[i+1][j+1] == player && board[i+2][j+2] == 0) {
                        cost += 100;
                    }
                    if (board[i][j] == player && board[i+1][j+1] == 0 && board[i+2][j+2] == player) {
                        cost += 100;
                    }
                    if (board[i][j] == 0 && board[i+1][j+1] == player && board[i+2][j+2] == player) {
                        cost += 100;
                    }
                }
                //Por la diagonal izquierda 2 llenas una vacía
                if (i  == 2 && j == 2) {
                    if (board[i][j] == player && board[i-1][j-1] == player && board[i-2][j-2] == 0) {
                        cost += 100;
                    }
                    if (board[i][j] == player && board[i-1][j-1] == 0 && board[i-2][j-2] == player) {
                        cost += 100;
                    }
                    if (board[i][j] == 0 && board[i-1][j-1] == player && board[i-2][j-2] == player) {
                        cost += 100;
                    }
                }

                 //casos en los que el jugador bloquea jugadas ganadoras
                //Por las columnas 2 enemy una player
                if (j >= 0 && j <= 2 && i == 0) {
                    if (board[i][j] == enemy && board[i+1][j] == enemy && board[i+2][j] == player) {
                        cost += 1000;
                    }
                    if (board[i][j] == enemy && board[i+1][j] == player && board[i+2][j] == enemy) {
                        cost += 1000;
                    }
                    if (board[i][j] == player && board[i+1][j] == enemy && board[i+2][j] == enemy) {
                        cost += 1000;
                    }
                }
                //Por las filas 2 enemy una player
                if (i >= 0 && i <= 2 && j == 0) {
                    if (board[i][j] == enemy && board[i][j+1] == enemy && board[i][j+2] == player) {
                        cost += 1000;
                    }
                    if (board[i][j] == enemy && board[i][j+1] == player && board[i][j+2] == enemy) {
                        cost += 1000;
                    }
                    if (board[i][j] == enemy && board[i][j+1] == enemy && board[i][j+2] == player) {
                        cost += 1000;
                    }
                }
                //Por la diagonal derecha 2 enemy una player
                if (i  == 0 && j == 0) {
                    if (board[i][j] == enemy && board[i+1][j+1] == enemy && board[i+2][j+2] == player) {
                        cost += 1000;
                    }
                    if (board[i][j] == enemy && board[i+1][j+1] == player && board[i+2][j+2] == enemy) {
                        cost += 1000;
                    }
                    if (board[i][j] == player && board[i+1][j+1] == enemy && board[i+2][j+2] == enemy) {
                        cost += 1000;
                    }
                }
                //Por la diagonal izquierda 2 enemy una player
                if (i  == 2 && j == 2) {
                    if (board[i][j] == enemy && board[i-1][j-1] == enemy && board[i-2][j-2] == player) {
                        cost += 1000;
                    }
                    if (board[i][j] == enemy && board[i-1][j-1] == player && board[i-2][j-2] == enemy) {
                        cost += 1000;
                    }
                    if (board[i][j] == player && board[i-1][j-1] == enemy && board[i-2][j-2] == enemy) {
                        cost += 1000;
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
