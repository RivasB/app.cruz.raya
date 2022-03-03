package ia;

public class AlphaBethaPrune {

    KnowledgeBase kb = new KnowledgeBase();
    private int primalDepth;

    public int minMaxAlphaBetha(int[][] board, int depth, int player, int alpha, int beta) {
        if ((kb.gameOver(board) != -1) || kb.isFull(board) || primalDepth < depth) {
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
                                return alpha;
                            }   
                        }
                        else {
                            alpha = Math.max(alpha, this.minMaxAlphaBetha(board, depth+1, 1, alpha, beta));;
                            board[i][j] = 0;
                            if (alpha>=beta) {
                                return beta;
                            }
                        }
                    }
                }
            }
            int alphaOrBeta = player==1 ? beta:alpha;
            return alphaOrBeta;   
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