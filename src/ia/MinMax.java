package ia;
import interfaces.Board;
public class MinMax {
    
    int board [][];
    int depth;
    boolean isIAturn = true;
    KnowledgeBase kb = new KnowledgeBase();
    AlphaBethaPrune abp = new AlphaBethaPrune();
    Board boardView;

    public MinMax(int depth, Board boardView) {
        this.depth = depth;
        this.boardView = boardView;
        abp.setPrimalDepth(depth);
    }

    public void ia(int[][] board) {
        this.board = board;
        if (isIAturn && !kb.isFull(board) && kb.gameOver(board) == -1) {
                minMax(board);
        }
        boardView.boardRepaint(board);
    }

    private void minMax(int[][] board) {
        int bestRow = -1;
        int bestColumn = -1;
        int currentMax;
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board.length; j++) {
                if (board[i][j] == 0) {
                    board[i][j] = 2;
                    int tempRow = i;
                    int tempColumn = j;
                    currentMax = abp.minValue(board, 0, Integer.MIN_VALUE, Integer.MAX_VALUE);
                    board[i][j] = 0;
                    if (max<currentMax) {
                        max = currentMax;
                        bestRow = tempRow;
                        bestColumn = tempColumn;
                    }
                }
            }
        }
        board[bestRow][bestColumn] = 2;
        System.out.println("Puntuación para Fila: "+ bestRow + "Columna: " + bestColumn );
        isIAturn = false;
    }

    public void setIaTurn(boolean option) {
        this.isIAturn = option;
    }
 

}
