package ia;

public class AlphaBethaPrune {

    KnowledgeBase kb = new KnowledgeBase();
    private int primalDepth;

    public int minMaxAlphaBetha(int[][] board, int depth, int player, int alpha, int beta) {
        if (kb.gameOver(board) != -1) {
            return this.heuristics(board);
        } 
        else if(kb.isFull(board)) {
            return this.heuristics(board);
        }
        else if(primalDepth < depth) {
            return this.heuristics(board);
        }
        else {
            for (int i = 0; i < board.length; i++) {
                for (int j = 0; j < board.length; j++) {
                    if (board[i][j] == 0) {
                        board[i][j] = player;
                        if (player == 1) {
                            beta = Math.min(beta, this.minMaxAlphaBetha(board, depth+1, 2, alpha, beta));
                            board[i][j] = 0;
                             if (alpha>=beta) {
                                System.out.println("Podando a la profundidad de " + depth + " Nodos Min con alpha: " + alpha +" y beta en: " + beta);
                                return alpha;
                            }   
                        }
                        else {
                            board[i][j] = 2;
                            alpha = Math.max(alpha, this.minMaxAlphaBetha(board, depth+1, 1, alpha, beta));
                            board[i][j] = 0;
                            if (alpha>=beta) {
                                System.out.println("Podando a la profundidad de " + depth + " Nodos Max con alpha: " + alpha +" y beta en: " + beta);
                                return beta;
                            }
                        }
                    }
                }
            }
            if (player == 1) {
                return beta;
            }
            else {
                return alpha;
            }   
        }
    }

    public int heuristics(int[][] board) {
        int score = 0;
        score = kb.cost(board, 2) - kb.cost(board, 1);
        return score;
    }

    public void setPrimalDepth(int primalDepth) {
        this.primalDepth = primalDepth;
    }
}
