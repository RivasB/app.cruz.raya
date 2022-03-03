package ia;
import javax.swing.JOptionPane;

import interfaces.Board;
public class MinMax {
    
    int board [][];
    int depth;
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
                boardView.endGame();
                return; 
            }
        }
        else if (kb.gameOver(board) != -1) {
            String msg = kb.gameOver(board) == 1 ? "Felicidades, has vencido":"Lo siento, has sido derrotado.";
            boardView.boardRepaint(board);
            JOptionPane.showMessageDialog(null, msg);
            boardView.endGame();
            return;
        }
        else { 
            minMax(board);
            boardView.boardRepaint(board);
        }
    }

    public void minMax(int[][] board) {
        int bestRow = -1;
        int bestColumn = -1;
        int currentMax;
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board.length; j++) {
                if (board[i][j] == 0) {
                    board[i][j] = 2;
                    System.out.print("Busqueda en profundidad para: Fila: "+ i + " Columna: " + j);
                    int tempRow = i;
                    int tempColumn = j;
                    currentMax = abp.minMaxAlphaBetha(board, 0, 1, Integer.MIN_VALUE, Integer.MAX_VALUE);
                    System.out.println(" Valor: " + currentMax);
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
        boardView.boardRepaint(board);
        if (kb.gameOver(board) != -1) {
            String msg = kb.gameOver(board) == 1 ? "Felicidades, has vencido":"Lo siento, has sido derrotado.";
            boardView.boardRepaint(board);
            JOptionPane.showMessageDialog(null, msg);
            return;
        }
        System.out.println("Jugada óptima en: Fila: "+ bestRow + " Columna: " + bestColumn + " Puntuada en: " + max + "\n");
    }
}
