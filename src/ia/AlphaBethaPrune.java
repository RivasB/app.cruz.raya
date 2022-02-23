package ia;

public class AlphaBethaPrune {

    KnowledgeBase kb = new KnowledgeBase();
    private int primalDepth;
    
    public int maxValue(int[][] board, int depth, int alpha, int beta) {
        if (kb.gameOver(board) != -1) {
            return this.heuristics(board, 1);
        } 
        else if(kb.isFull(board)) {
            return this.heuristics(board, 1);
        }
        else if(primalDepth < depth) {
            return this.heuristics(board, 1);
        }
        else {
            for (int i = 0; i < board.length; i++) {
                for (int j = 0; j < board.length; j++) {
                    if (board[i][j] == 0) {
                        board[i][j] = 2;
                        alpha = Math.max(alpha, this.minValue(board, depth+1, alpha, beta));
                        board[i][j] = 0;
                        // if (alpha>=beta) {
                        //     System.out.println("Podando a la profundidad de " + depth + " Nodos Max con alpha: " + alpha +" y beta en: " + beta);
                        //     return beta;
                        // }
                    }
                }
            }
            System.out.println("Maximizando a una Profundidad de " + depth + " Puntado " + alpha);
            return alpha;
        }
    }

    public int minValue(int[][] board, int depth, int alpha, int beta) {
        if (kb.gameOver(board) != -1) {
            return this.heuristics(board, 2);
        } 
        else if(kb.isFull(board)) {
            return this.heuristics(board, 2);
        }
        else if(primalDepth < depth) {
            return this.heuristics(board, 2);
        }
        else {
            for (int i = 0; i < board.length; i++) {
                for (int j = 0; j < board.length; j++) {
                    if (board[i][j] == 0) {
                        board[i][j] = 1;
                        beta = Math.min(beta, this.maxValue(board, depth+1, alpha, beta));
                        board[i][j] = 0;
                        // if (alpha>=beta) {
                        //     System.out.println("Podando a la profundidad de " + depth + " Nodos Min con alpha: " + alpha +" y beta en: " + beta);
                        //     return alpha;
                        // }
                    }
                }
            }
            System.out.println("Minimizando a una Profundidad de " + depth + " Puntado " + beta);
            return beta;
        }
    }

    public int heuristics(int[][] board, int player) {
        int score = 0;
        score = kb.cost(board, player);
        System.out.println("Puntuación de jugada: " + score);
        return score;
    }

    public void setPrimalDepth(int primalDepth) {
        this.primalDepth = primalDepth;
    }
}
