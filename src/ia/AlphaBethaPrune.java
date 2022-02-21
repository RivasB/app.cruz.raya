package ia;

public class AlphaBethaPrune {

    KnowledgeBase kb = new KnowledgeBase();
    private int primalDepth;
    
    public int maxValue(int[][] board, int depth, int alpha, int beta) {
        if (kb.gameOver(board) != -1) {
            System.out.println("Gameover Max: " + kb.gameOver(board));
            return this.heuristics(board);
        } 
        else if(kb.isFull(board)) {
            System.out.println("Tablero lleno en Max");
            return this.heuristics(board);
        }
        else if(primalDepth < depth) {
            System.out.println("Profundidad alcanzada en Max");
            return this.heuristics(board);
        }
        else {
            for (int i = 0; i < board.length; i++) {
                for (int j = 0; j < board.length; j++) {
                    if (board[i][j] == 0) {
                        board[i][j] = 1;
                        alpha = Math.max(alpha, this.minValue(board, depth+1, alpha, beta));
                        board[i][j] = 0;
                        if (alpha>=beta) {
                            System.out.println("Podando a la profundidad de " + depth + " Nodos Max con alpha: " + alpha +" y beta en: " + beta);
                            return beta;
                        }
                    }
                }
            }
            return alpha;
        }
    }

    public int minValue(int[][] board, int depth, int alpha, int beta) {
        if (kb.gameOver(board) != -1) {
            System.out.println("Gameover Min: " + kb.gameOver(board));
            return this.heuristics(board);
        } 
        else if(kb.isFull(board)) {
            System.out.println("Tablero lleno en Min");
            return this.heuristics(board);
        }
        else if(primalDepth < depth) {
            System.out.println("Profundidad alcanzada en Min");
            return this.heuristics(board);
        }
        else {
            for (int i = 0; i < board.length; i++) {
                for (int j = 0; j < board.length; j++) {
                    if (board[i][j] == 0) {
                        board[i][j] = 2;
                        beta = Math.min(beta, this.maxValue(board, depth+1, alpha, beta));
                        board[i][j] = 0;
                        if (alpha>=beta) {
                            System.out.println("Podando a la profundidad de " + depth + " Nodos Min con alpha: " + alpha +" y beta en: " + beta);
                            return alpha;
                        }
                    }
                }
            }
            return beta;
        }
    }

    public int heuristics(int[][] board) {
        int score = 0;
        score = kb.cost(board, 2) - kb.cost(board, 1);
        System.out.println("Puntuación de jugada: " + score);
        return score;
        
    }

    public void setPrimalDepth(int primalDepth) {
        this.primalDepth = primalDepth;
    }
}
