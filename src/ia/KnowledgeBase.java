package ia;

public class KnowledgeBase {
    

    public int gameOver(int[][] board) {
        if ((board[0][0] == board[1][1] && board[0][0] == board[2][2] && board[0][0] == 1) 
        || (board[0][2] == board[1][1] && board[0][2] == board[2][0] && board[0][2] == 1)) {
            return 1;
        }
        if ((board[0][0] == board[1][1] && board[0][0] == board[2][2] && board[0][0] == 2) 
        || (board[0][2] == board[1][1] && board[0][2] == board[2][0] && board[0][2] == 2)) {
            return 2;
        }
        for (int i = 0; i < 3; ++i) {
            if (((board[i][0] == board[i][1] && board[i][0] == board[i][2] && board[i][0] == 1) 
            || (board[0][i] == board[1][i] && board[0][i] == board[2][i] && board[0][i] == 1))) {
                return 1;
            }
        }
        for (int i = 0; i < 3; ++i) {
            if (((board[i][0] == board[i][1] && board[i][0] == board[i][2] && board[i][0] == 2) 
            || (board[0][i] == board[1][i] && board[0][i] == board[2][i] && board[0][i] == 2))) {
                return 2;
            }
        }        
        return -1;
    }

    public int cost(int[][] board, int player) {
        int cost = 0;
        int enemy = player == 1 ? 2:1;
        if (board[1][1]==player) {
            cost+=300;
        }
        if ((board[0][0]==player || board[0][2]==player || board[2][0]==player || board[2][2]==player) && board[1][1]==player ) {
            cost+=200;
        }
        if ((board[0][0] == board[1][1] && board[0][0] == board[2][2] && board[0][0] == player) 
            || (board[0][2] == board[1][1] && board[0][2] == board[2][0] && board[0][2] == player)) {
                cost += 300;
        }
        for (int i = 0; i < 3; ++i) {
            if (((board[i][0] == board[i][1] && board[i][0] == board[i][2] && board[i][0] == player) 
            || (board[0][i] == board[1][i] && board[0][i] == board[2][i] && board[0][i] == player))) {
                cost += 300;
            }
        }        

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board.length; j++) {
                if (j >= 0 && j <= 2 && i == 0) {
                    if ((board[i][j] == enemy && board[i+1][j] == enemy && board[i+2][j] == player)
                    || (board[i][j] == enemy && board[i+1][j] == player && board[i+2][j] == enemy)
                    || (board[i][j] == player && board[i+1][j] == enemy && board[i+2][j] == enemy)) {
                        cost += 100;
                    }
                }
                if (i >= 0 && i <= 2 && j == 0) {
                    if ((board[i][j] == enemy && board[i][j+1] == enemy && board[i][j+2] == player)
                    || (board[i][j] == enemy && board[i][j+1] == player && board[i][j+2] == enemy)
                    || (board[i][j] == enemy && board[i][j+1] == enemy && board[i][j+2] == player)) {
                        cost += 100;
                    }
                }
                if (i  == 0 && j == 0) {
                    if ((board[i][j] == enemy && board[i+1][j+1] == enemy && board[i+2][j+2] == player)
                    || (board[i][j] == enemy && board[i+1][j+1] == player && board[i+2][j+2] == enemy)
                    || (board[i][j] == player && board[i+1][j+1] == enemy && board[i+2][j+2] == enemy)) {
                        cost += 100;
                    }
                }
                if (i  == 2 && j == 2) {
                    if ((board[i][j] == enemy && board[i-1][j-1] == enemy && board[i-2][j-2] == player)
                    || (board[i][j] == enemy && board[i-1][j-1] == player && board[i-2][j-2] == enemy)
                    || (board[i][j] == player && board[i-1][j-1] == enemy && board[i-2][j-2] == enemy)) {
                        cost += 100;
                    }
                }
                if (j >= 0 && j <= 2 && i == 0) {
                    if ( (board[i][j] == player && board[i+1][j] == player && board[i+2][j] == 0) 
                    || (board[i][j] == player && board[i+1][j] == 0 && board[i+2][j] == player)
                    || (board[i][j] == 0 && board[i+1][j] == player && board[i+2][j] == player)){
                        cost += 35;
                    }   
                }
                if (i >= 0 && i <= 2 && j == 0) {
                    if ((board[i][j] == player && board[i][j+1] == player && board[i][j+2] == 0)
                    || (board[i][j] == player && board[i][j+1] == 0 && board[i][j+2] == player)
                    || (board[i][j] == 0 && board[i][j+1] == player && board[i][j+2] == player)) {
                        cost += 35;
                    }
                }
                if (i  == 0 && j == 0) {
                    if ((board[i][j] == player && board[i+1][j+1] == player && board[i+2][j+2] == 0)
                    || (board[i][j] == player && board[i+1][j+1] == 0 && board[i+2][j+2] == player)  
                    || (board[i][j] == 0 && board[i+1][j+1] == player && board[i+2][j+2] == player)) {
                        cost += 35;
                    }
                }
                if (i  == 2 && j == 2) {
                    if ((board[i][j] == player && board[i-1][j-1] == player && board[i-2][j-2] == 0)
                    || (board[i][j] == player && board[i-1][j-1] == 0 && board[i-2][j-2] == player)
                    || (board[i][j] == 0 && board[i-1][j-1] == player && board[i-2][j-2] == player)) {
                        cost += 35;
                    }
                }
                if (j >= 0 && j <= 2 && i == 0) {
                    if ( (board[i][j] == 0 && board[i+1][j] == 0 && board[i+2][j] == player) 
                    || (board[i][j] == 0 && board[i+1][j] == player && board[i+2][j] == 0)
                    || (board[i][j] == player && board[i+1][j] == 0 && board[i+2][j] == 0)){
                        cost += 9;
                    }   
                }
                if (i >= 0 && i <= 2 && j == 0) {
                    if ((board[i][j] == 0 && board[i][j+1] == 0 && board[i][j+2] == player)
                    || (board[i][j] == 0 && board[i][j+1] == player && board[i][j+2] == 0)
                    || (board[i][j] == player && board[i][j+1] == 0 && board[i][j+2] == 0)) {
                        cost += 9;
                    }
                }
                if (i  == 0 && j == 0) {
                    if ((board[i][j] == 0 && board[i+1][j+1] == 0 && board[i+2][j+2] == player)
                    || (board[i][j] == 0 && board[i+1][j+1] == player && board[i+2][j+2] == 0)  
                    || (board[i][j] == player && board[i+1][j+1] == 0 && board[i+2][j+2] == 0)) {
                        cost += 9;
                    }
                }
                if (i  == 2 && j == 2) {
                    if ((board[i][j] == 0 && board[i-1][j-1] == 0 && board[i-2][j-2] == player)
                    || (board[i][j] == 0 && board[i-1][j-1] == player && board[i-2][j-2] == 0)
                    || (board[i][j] == player && board[i-1][j-1] == 0 && board[i-2][j-2] == 0)) {
                        cost += 9;
                    }
                }
            }
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
}