package ia;
import javax.swing.JOptionPane;

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
        if (kb.isFull(board)) {
            if (kb.gameOver(board) == -1) {
                boardView.boardRepaint(board);
                JOptionPane.showMessageDialog(null, "El Juego queda tablas"); 
            }
        
        }
        else { 
            minMax(board);
            boardView.boardRepaint(board);
        }
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
                    currentMax = abp.maxValue(board, 0, Integer.MIN_VALUE, Integer.MAX_VALUE);
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
        System.out.println("Jugada de IA en: Fila: "+ bestRow + " Columna: " + bestColumn + " Puntuada en: " + max + "\n\n\n\n");
    }

    public void setIaTurn(boolean option) {
        this.isIAturn = option;
    }
 

}
