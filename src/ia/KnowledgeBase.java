package ia;

public class KnowledgeBase {
    

    public int gameOver(int[][] board) {
        //i = filas j = columnas
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board.length; j++) {
                //Humano gana si completa cualquier fila
                if (j >= 0 && j <= 2 && i == 0) {
                    if (board[i][j] == 1 && board[i+1][j] == 1 && board[i+2][j] == 1) {
                        return 1;
                    }
                }
                //Humano gana si completa cualquier columna
                if (i >= 0 && i <= 2 && j == 0) {
                    if (board[i][j] == 1 && board[i][j+1] == 1 && board[i][j+1] == 1) {
                        return 1;
                    }
                }
                //Humano gana si completa diagonal principal izquierda-derecha
                if (i  == 0 && j == 0) {
                    if (board[i][j] == 1 && board[i+1][j+1] == 1 && board[i+2][j+2] == 1) {
                        return 1;
                    }
                }
                //Humano gana si completa diagonal principal derecha-izquierda
                if (i  == 2 && j == 2) {
                    if (board[i][j] == 1 && board[i-1][j-1] == 1 && board[i-2][j-2] == 1) {
                        return 1;
                    }
                }
                //IA gana si completa cualquier fila
                if (j >= 0 && j <= 2 && i == 0) {
                    if (board[i][j] == 2 && board[i+1][j] == 2 && board[i+2][j] == 2) {
                        return 2;
                    }
                }
                //IA gana si completa cualquier columna
                if (i >= 0 && i <= 2 && j == 0) {
                    if (board[i][j] == 2 && board[i][j+1] == 2 && board[i][j+1] == 2) {
                        return 2;
                    }
                }
                //IA gana si completa diagonal principal izquierda-derecha
                if (i  == 0 && j == 0) {
                    if (board[i][j] == 2 && board[i+1][j+1] == 2 && board[i+2][j+2] == 2) {
                        return 2;
                    }
                }
                //IA gana si completa diagonal principal derecha-izquierda
                if (i  == 2 && j == 2) {
                    if (board[i][j] == 2 && board[i-1][j-1] == 2 && board[i-2][j-2] == 2) {
                        return 2;
                    }
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
        if ((board[0][0]==enemy || board[0][2]==enemy || board[2][0]==enemy || board[2][2]==enemy) && board[1][1]==player) {
            cost = 100;
        }
        else if ((board[0][0]==enemy || board[0][2]==enemy || board[2][0]==enemy || board[2][2]==enemy) && board[1][1]!=player) {
            cost = -100;
        }
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board.length; j++) {
                //casos en los que el jugador hace una jugada ganadora
                //llenando cualquier fila
                if (j >= 0 && j <= 2 && i == 0) {
                    if (board[i][j] == player && board[i+1][j] == player && board[i+2][j] == player) {
                        cost = 100;
                    }
                    if (board[i][j] == enemy && board[i+1][j] == enemy && board[i+2][j] == enemy) {
                        cost = -100;
                    }
                }
                //llenando cualquier columna
                if (i >= 0 && i <= 2 && j == 0) {
                    if (board[i][j] == player && board[i][j+1] == player && board[i][j+2] == player) {
                        cost = 100;
                    }
                    if (board[i][j] == enemy && board[i][j+1] == enemy && board[i][j+2] == enemy) {
                        cost = -100;
                    }
                }
                //llenando diagonal derecha
                if (i  == 0 && j == 0) {
                    if (board[i][j] == player && board[i+1][j+1] == player && board[i+2][j+2] == player) {
                        cost = 100;
                    }
                    if (board[i][j] == enemy && board[i+1][j+1] == enemy && board[i+2][j+2] == enemy) {
                        cost = -100;
                    }
                }
                //llenando diagonal izquierda
                if (i  == 2 && j == 2) {
                    if (board[i][j] == player && board[i-1][j-1] == player && board[i-2][j-2] == player) {
                        cost = 100;
                    }
                    if (board[i][j] == enemy && board[i-1][j-1] == enemy && board[i-2][j-2] == enemy) {
                        cost = -100;
                    }
                }
                
                
                //casos en los que el jugador tiene 2 jugadas adyacentes
                //Por las columnas 2 llenas una vacía
                if (j >= 0 && j <= 2 && i == 0) {
                    if (board[i][j] == player && board[i+1][j] == player && board[i+2][j] == 0) {
                        cost = 50;
                    }
                    if (board[i][j] == enemy && board[i+1][j] == enemy && board[i+2][j] == 0) {
                        cost = -50;
                    }
                }
                //Por las filas 2 llenas una vacía
                if (i >= 0 && i <= 2 && j == 0) {
                    if (board[i][j] == player && board[i][j+1] == player && board[i][j+1] == 0) {
                        cost = 50;
                    }
                    if (board[i][j] == enemy && board[i][j+1] == enemy && board[i][j+1] == 0) {
                        cost = -50;
                    }
                }
                //Por la diagonal derecha 2 llenas una vacía
                if (i  == 0 && j == 0) {
                    if (board[i][j] == player && board[i+1][j+1] == player && board[i+2][j+2] == 0) {
                        cost = 50;
                    }
                    if (board[i][j] == enemy && board[i+1][j+1] == enemy && board[i+2][j+2] == 0) {
                        cost = -50;
                    }
                }
                //Por la diagonal izquierda 2 llenas una vacía
                if (i  == 2 && j == 2) {
                    if (board[i][j] == player && board[i-1][j-1] == player && board[i-2][j-2] == 0) {
                        cost = -50;
                    }
                    if (board[i][j] == enemy && board[i-1][j-1] == enemy && board[i-2][j-2] == 0) {
                        cost = -50;
                    }
                }
                //Mismos casos, una vacía dos llenas.
                if (j >= 0 && j <= 2 && i == 0) {
                    if (board[i][j] == 0 && board[i+1][j] == player && board[i+2][j] == player) {
                        cost = 25;
                    }
                }
                if (i >= 0 && i <= 2 && j == 0) {
                    if (board[i][j] == 0 && board[i][j+1] == player && board[i][j+1] == player) {
                        cost = 25;
                    }
                }
                if (i  == 0 && j == 0) {
                    if (board[i][j] == 0 && board[i+1][j+1] == player && board[i+2][j+2] == player) {
                        cost = 25;
                    }
                }
                if (i  == 2 && j == 2) {
                    if (board[i][j] == 0 && board[i-1][j-1] == player && board[i-2][j-2] == player) {
                        cost = 25;
                    }
                }

                 //casos en los que el jugador bloquea jugadas ganadoras
                //Por las columnas 2 llenas una vacía
                if (j >= 0 && j <= 2 && i == 0) {
                    if (board[i][j] == enemy && board[i+1][j] == enemy && board[i+2][j] == player) {
                        cost = 90;
                    }
                }
                //Por las filas 2 llenas una vacía
                if (i >= 0 && i <= 2 && j == 0) {
                    if (board[i][j] == enemy && board[i][j+1] == enemy && board[i][j+1] == player) {
                        cost = 90;
                    }
                }
                //Por la diagonal derecha 2 llenas una vacía
                if (i  == 0 && j == 0) {
                    if (board[i][j] == enemy && board[i+1][j+1] == enemy && board[i+2][j+2] == player) {
                        cost = 90;
                    }
                }
                //Por la diagonal izquierda 2 llenas una vacía
                if (i  == 2 && j == 2) {
                    if (board[i][j] == enemy && board[i-1][j-1] == enemy && board[i-2][j-2] == player) {
                        cost = 90;
                    }
                }
                //Mismos casos, una vacía dos llenas.
                if (j >= 0 && j <= 2 && i == 0) {
                    if (board[i][j] == player && board[i+1][j] == enemy && board[i+2][j] == enemy) {
                        cost = 90;
                    }
                }
                if (i >= 0 && i <= 2 && j == 0) {
                    if (board[i][j] == player && board[i][j+1] == enemy && board[i][j+1] == enemy) {
                        cost = 90;
                    }
                }
                if (i  == 0 && j == 0) {
                    if (board[i][j] == player && board[i+1][j+1] == enemy && board[i+2][j+2] == enemy) {
                        cost = 90;
                    }
                }
                if (i  == 2 && j == 2) {
                    if (board[i][j] == player && board[i-1][j-1] == enemy && board[i-2][j-2] == enemy) {
                        cost = 90;
                    }
                }
            }
        }
        System.out.println("Jugada puntuada en " + cost);
        if (player==1) {
            cost = cost * -1;
        }
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
    
    @SuppressWarnings("all")
    public int evaluateBoard(int[][] board) {
        int score = 0;
        //Puntuando el estado de cada fila.
        for (int i = 0; i < 3; ++i) {
            int blank = 0;
            int X = 0;
            int O = 0;
            for (int j = 0; j < 3; ++j) {
                if (board[i][j] == 0) {
                    blank++;
                } else if (board[i][j] == 1) {
                    X++;
                } else {
                    O++;
                }
            } 
            score+=changeInScore(X, O); 
        }
         //Puntuando el estado de cada columna.
        for (int j = 0; j < 3; ++j) {
            int blank = 0;
            int X = 0;
            int O = 0;
            for (int i = 0; i < 3; ++i) {
                if (board[i][j] == 0) {
                    blank++;
                } else if (board[i][j] == 1) {
                    X++;
                } else {
                    O++;
                } 
            }
            score+=changeInScore(X, O);
        }
        //Puntuando el estado diagonal izquierda
        int blank = 0;
        int X = 0;
        int O = 0;
        for (int i = 0, j = 0; i < 3; ++i, ++j) {
            if (board[i][j] == 1) {
                X++;
            } else if (board[i][j] == 2) {
                O++;
            } else {
                blank++;
            }
        }
        score+=changeInScore(X, O);
        //Puntuando el estado diagonal derecha
        blank = 0;
        X = 0;
        O = 0;
        for (int i = 2, j = 0; i > -1; --i, ++j) {
            if (board[i][j] == 1) {
                X++;
            } else if (board[i][j] == 2) {
                O++;
            } else {
                blank++;
            }
        }
        score+=changeInScore(X, O);
        return score;
    }

    private int changeInScore(int X, int O){
        int change;
        if (X == 3) {
            change = 100;
        } else if (X == 2 && O == 0) {
            change = 10;
        } else if (X == 1 && O == 0) {
            change = 1;
        } else if (O == 3) {
            change = -100;
        } else if (O == 2 && X == 0) {
            change = -10;
        } else if (O == 1 && X == 0) {
            change = -1;
        } else {
            change = 0;
        } 
        return change;
    }
}
