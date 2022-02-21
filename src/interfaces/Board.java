package interfaces;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
/*
 * Created by JFormDesigner on Thu Feb 17 20:29:58 GMT-05:00 2022
 */

import ia.MinMax;



/**
 * @author David Alejadro
 */
public class Board extends JFrame {

	int board[][] = new int[3][3];
	int depth = 2;
	MinMax ia = new MinMax(depth, this);

	public Board() {
		initComponents();
		setVisible(true);
		setLocationRelativeTo(null);
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board.length; j++) {
				board[j][i] = 0;
			}
		}
	}

	private void playMove(JLabel lbl, int i, int j) {
		if (lbl.getText().equals("0") || lbl.getText().equals("")) {
			b0X0.setText("X");
			board[i][j] = 1;
			ia.ia(board);
			ia.setIaTurn(true);
		}
		else {
			System.out.println("pepe");
		}
	}

	private void charReplace (JLabel lbl) {
		if (lbl.getText().equals("1")) {
			lbl.setText("X");
		} else if (lbl.getText().equals("2")) {
			lbl.setText("O");
		}
		else {
			lbl.setText("");
		}
	}

	public void boardRepaint(int[][] board) {
		this.board = board;
		b0X0.setText(Integer.toString(board[0][0]));
		charReplace(b0X0);
		b1X0.setText(Integer.toString(board[1][0]));
		charReplace(b1X0);
		b2X0.setText(Integer.toString(board[2][0]));
		charReplace(b2X0);
		b0X1.setText(Integer.toString(board[0][1]));
		charReplace(b0X1);
		b1X1.setText(Integer.toString(board[1][1]));
		charReplace(b1X1);
		b2X1.setText(Integer.toString(board[2][1]));
		charReplace(b2X1);
		b0X2.setText(Integer.toString(board[0][2]));
		charReplace(b0X2);
		b1X2.setText(Integer.toString(board[1][2]));
		charReplace(b1X2);
		b2X2.setText(Integer.toString(board[2][2]));
		charReplace(b2X2);
    }

	private void b0X0MouseClicked() {
		playMove(b0X0, 0, 0);
	}

	private void b1X0MouseClicked() {
		playMove(b1X0, 1, 0);
	}

	private void b2X0MouseClicked() {
		playMove(b2X0, 2, 0);
	}

	private void b0X1MouseClicked() {
		playMove(b0X1, 0, 1);
	}

	private void b1X1MouseClicked() {
		playMove(b1X1, 1, 1);
	}

	private void b2X1MouseClicked() {
		playMove(b2X1, 2, 1);
	}

	private void b0X2MouseClicked() {
		playMove(b0X2, 0, 2);
	}

	private void b1X2MouseClicked() {
		playMove(b1X2, 1, 2);
	}

	private void b2X2MouseClicked() {
		playMove(b2X2, 2, 2);
	}

	private void initComponents() {
		// JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
		menuBar1 = new JMenuBar();
		menu1 = new JMenu();
		menuItem1 = new JMenuItem();
		menuItem2 = new JMenuItem();
		panel1 = new JPanel();
		b0X0 = new JLabel();
		b1X0 = new JLabel();
		b2X0 = new JLabel();
		b0X1 = new JLabel();
		b1X1 = new JLabel();
		b2X1 = new JLabel();
		b0X2 = new JLabel();
		b1X2 = new JLabel();
		b2X2 = new JLabel();

		//======== this ========
		setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
		setResizable(false);
		Container contentPane = getContentPane();
		contentPane.setLayout(new CardLayout());

		//======== menuBar1 ========
		{

			//======== menu1 ========
			{
				menu1.setText("Juego");

				//---- menuItem1 ----
				menuItem1.setText("Nuevo");
				menu1.add(menuItem1);

				//---- menuItem2 ----
				menuItem2.setText("Salir");
				menu1.add(menuItem2);
			}
			menuBar1.add(menu1);
		}
		setJMenuBar(menuBar1);

		//======== panel1 ========
		{
			panel1.setBackground(Color.white);
			panel1.setLayout(new GridLayout(3, 3, 5, 5));

			//---- b0X0 ----
			b0X0.setHorizontalTextPosition(SwingConstants.CENTER);
			b0X0.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			b0X0.setHorizontalAlignment(SwingConstants.CENTER);
			b0X0.setFont(new Font("Segoe UI", Font.BOLD, 170));
			b0X0.setBackground(UIManager.getColor("Button.background"));
			b0X0.setOpaque(true);
			b0X0.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					b0X0MouseClicked();
				}
			});
			panel1.add(b0X0);

			//---- b1X0 ----
			b1X0.setHorizontalTextPosition(SwingConstants.CENTER);
			b1X0.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			b1X0.setHorizontalAlignment(SwingConstants.CENTER);
			b1X0.setFont(new Font("Segoe UI", Font.BOLD, 170));
			b1X0.setBackground(UIManager.getColor("Button.background"));
			b1X0.setOpaque(true);
			b1X0.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					b1X0MouseClicked();
				}
			});
			panel1.add(b1X0);

			//---- b2X0 ----
			b2X0.setHorizontalTextPosition(SwingConstants.CENTER);
			b2X0.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			b2X0.setHorizontalAlignment(SwingConstants.CENTER);
			b2X0.setFont(new Font("Segoe UI", Font.BOLD, 170));
			b2X0.setBackground(UIManager.getColor("Button.background"));
			b2X0.setOpaque(true);
			b2X0.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					b2X0MouseClicked();
				}
			});
			panel1.add(b2X0);

			//---- b0X1 ----
			b0X1.setHorizontalTextPosition(SwingConstants.CENTER);
			b0X1.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			b0X1.setHorizontalAlignment(SwingConstants.CENTER);
			b0X1.setFont(new Font("Segoe UI", Font.BOLD, 170));
			b0X1.setBackground(UIManager.getColor("Button.background"));
			b0X1.setOpaque(true);
			b0X1.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					b0X1MouseClicked();
				}
			});
			panel1.add(b0X1);

			//---- b1X1 ----
			b1X1.setHorizontalTextPosition(SwingConstants.CENTER);
			b1X1.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			b1X1.setHorizontalAlignment(SwingConstants.CENTER);
			b1X1.setFont(new Font("Segoe UI", Font.BOLD, 170));
			b1X1.setBackground(UIManager.getColor("Button.background"));
			b1X1.setOpaque(true);
			b1X1.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					b1X1MouseClicked();
				}
			});
			panel1.add(b1X1);

			//---- b2X1 ----
			b2X1.setHorizontalTextPosition(SwingConstants.CENTER);
			b2X1.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			b2X1.setHorizontalAlignment(SwingConstants.CENTER);
			b2X1.setFont(new Font("Segoe UI", Font.BOLD, 170));
			b2X1.setBackground(UIManager.getColor("Button.background"));
			b2X1.setOpaque(true);
			b2X1.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					b2X1MouseClicked();
				}
			});
			panel1.add(b2X1);

			//---- b0X2 ----
			b0X2.setHorizontalTextPosition(SwingConstants.CENTER);
			b0X2.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			b0X2.setHorizontalAlignment(SwingConstants.CENTER);
			b0X2.setFont(new Font("Segoe UI", Font.BOLD, 170));
			b0X2.setBackground(UIManager.getColor("Button.background"));
			b0X2.setOpaque(true);
			b0X2.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					b0X2MouseClicked();
				}
			});
			panel1.add(b0X2);

			//---- b1X2 ----
			b1X2.setHorizontalTextPosition(SwingConstants.CENTER);
			b1X2.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			b1X2.setHorizontalAlignment(SwingConstants.CENTER);
			b1X2.setFont(new Font("Segoe UI", Font.BOLD, 170));
			b1X2.setBackground(UIManager.getColor("Button.background"));
			b1X2.setOpaque(true);
			b1X2.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					b1X2MouseClicked();
				}
			});
			panel1.add(b1X2);

			//---- b2X2 ----
			b2X2.setHorizontalTextPosition(SwingConstants.CENTER);
			b2X2.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			b2X2.setHorizontalAlignment(SwingConstants.CENTER);
			b2X2.setFont(new Font("Segoe UI", Font.BOLD, 170));
			b2X2.setBackground(UIManager.getColor("Button.background"));
			b2X2.setOpaque(true);
			b2X2.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					b2X2MouseClicked();
				}
			});
			panel1.add(b2X2);
		}
		contentPane.add(panel1, "card1");
		setSize(655, 655);
		setLocationRelativeTo(getOwner());
		// JFormDesigner - End of component initialization  //GEN-END:initComponents
	}

	// JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
	private JMenuBar menuBar1;
	private JMenu menu1;
	private JMenuItem menuItem1;
	private JMenuItem menuItem2;
	private JPanel panel1;
	public JLabel b0X0;
	public JLabel b1X0;
	public JLabel b2X0;
	public JLabel b0X1;
	public JLabel b1X1;
	public JLabel b2X1;
	public JLabel b0X2;
	public JLabel b1X2;
	public JLabel b2X2;
	// JFormDesigner - End of variables declaration  //GEN-END:variable
}
