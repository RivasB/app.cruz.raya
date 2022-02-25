package interfaces;
import java.awt.CardLayout;
import java.awt.Container;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.Rectangle;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.IOException;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.WindowConstants;

import ia.MinMax;



/**
 * @author David Alejadro
 */
public class Board extends JFrame {

	int board[][] = new int[3][3];
	int depth;
	MinMax ia = null;

	public Board(int deph) {
		initComponents();
		setVisible(true);
		setLocationRelativeTo(null);
		prepareBoard();
		this.depth = deph;
		ia = new MinMax(depth, this);
	}

	private void prepareBoard() {
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board.length; j++) {
				board[i][j] = 0;
			}
		}
	}

	private void playMove(JLabel lbl, int i, int j) {
		if (lbl.getText().equals("")) {
			lbl.setIcon(new ImageIcon("src/resources/x.png"));
			this.board[i][j] = 1;
			ia.ia(board);
			playSound("src/resources/x.wav");
		}
		else {
			System.out.println("Aquí ya no se puede jugar");
		}
	}

	private void charReplace (JLabel lbl) {
		if (lbl.getText().equals("1")) {
			lbl.setText("");
			lbl.setIcon(new ImageIcon("src/resources/x.png"));
		} else if (lbl.getText().equals("2")) {
			lbl.setText("");
			lbl.setIcon(new ImageIcon("src/resources/o.png"));
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

	private void playSound(String sound){
		try {
		 AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(new File(sound).getAbsoluteFile());
		 Clip clip = AudioSystem.getClip();
		 clip.open(audioInputStream);
		 clip.start();
		} catch(UnsupportedAudioFileException | IOException | LineUnavailableException ex) {
		  System.out.println("Error al reproducir el sonido.");
		}
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

	private void menuItem1ActionPerformed() {
		dispose();
		new Splash(false);
	}

	private void menuItem2ActionPerformed() {
		dispose();
	}

	private void initComponents() {
		// JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
		menuBar1 = new JMenuBar();
		menu1 = new JMenu();
		menuItem1 = new JMenuItem();
		menuItem2 = new JMenuItem();
		panel2 = new JPanel();
		panel1 = new JPanel();
		b0X0 = new JLabel();
		b0X1 = new JLabel();
		b0X2 = new JLabel();
		b1X0 = new JLabel();
		b1X1 = new JLabel();
		b1X2 = new JLabel();
		b2X0 = new JLabel();
		b2X1 = new JLabel();
		b2X2 = new JLabel();
		label1 = new JLabel();

		//======== this ========
		setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
		setResizable(false);
		setTitle("TicTacToe Cruz y Raya VS IA");
		setIconImage(new ImageIcon("src/resources/x.png").getImage());
		Container contentPane = getContentPane();
		contentPane.setLayout(new CardLayout());

		//======== menuBar1 ========
		{

			//======== menu1 ========
			{
				menu1.setText("Juego");

				//---- menuItem1 ----
				menuItem1.setText("Nuevo");
				menuItem1.addActionListener(e -> menuItem1ActionPerformed());
				menu1.add(menuItem1);

				//---- menuItem2 ----
				menuItem2.setText("Salir");
				menuItem2.addActionListener(e -> menuItem2ActionPerformed());
				menu1.add(menuItem2);
			}
			menuBar1.add(menu1);
		}
		setJMenuBar(menuBar1);

		//======== panel2 ========
		{
			panel2.setLayout(null);

			//======== panel1 ========
			{
				panel1.setOpaque(false);
				panel1.setLayout(new GridLayout(3, 3, 5, 5));

				//---- b0X0 ----
				b0X0.setHorizontalTextPosition(SwingConstants.CENTER);
				b0X0.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
				b0X0.setHorizontalAlignment(SwingConstants.CENTER);
				b0X0.setFont(new Font("Segoe UI", Font.BOLD, 170));
				b0X0.setBackground(UIManager.getColor("Button.background"));
				b0X0.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseClicked(MouseEvent e) {
						b0X0MouseClicked();
					}
				});
				panel1.add(b0X0);

				//---- b0X1 ----
				b0X1.setHorizontalTextPosition(SwingConstants.CENTER);
				b0X1.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
				b0X1.setHorizontalAlignment(SwingConstants.CENTER);
				b0X1.setFont(new Font("Segoe UI", Font.BOLD, 170));
				b0X1.setBackground(UIManager.getColor("Button.background"));
				b0X1.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseClicked(MouseEvent e) {
						b0X1MouseClicked();
					}
				});
				panel1.add(b0X1);

				//---- b0X2 ----
				b0X2.setHorizontalTextPosition(SwingConstants.CENTER);
				b0X2.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
				b0X2.setHorizontalAlignment(SwingConstants.CENTER);
				b0X2.setFont(new Font("Segoe UI", Font.BOLD, 170));
				b0X2.setBackground(UIManager.getColor("Button.background"));
				b0X2.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseClicked(MouseEvent e) {
						b0X2MouseClicked();
					}
				});
				panel1.add(b0X2);

				//---- b1X0 ----
				b1X0.setHorizontalTextPosition(SwingConstants.CENTER);
				b1X0.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
				b1X0.setHorizontalAlignment(SwingConstants.CENTER);
				b1X0.setFont(new Font("Segoe UI", Font.BOLD, 170));
				b1X0.setBackground(UIManager.getColor("Button.background"));
				b1X0.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseClicked(MouseEvent e) {
						b1X0MouseClicked();
					}
				});
				panel1.add(b1X0);

				//---- b1X1 ----
				b1X1.setHorizontalTextPosition(SwingConstants.CENTER);
				b1X1.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
				b1X1.setHorizontalAlignment(SwingConstants.CENTER);
				b1X1.setFont(new Font("Segoe UI", Font.BOLD, 170));
				b1X1.setBackground(UIManager.getColor("Button.background"));
				b1X1.setIcon(null);
				b1X1.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseClicked(MouseEvent e) {
						b1X1MouseClicked();
					}
				});
				panel1.add(b1X1);

				//---- b1X2 ----
				b1X2.setHorizontalTextPosition(SwingConstants.CENTER);
				b1X2.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
				b1X2.setHorizontalAlignment(SwingConstants.CENTER);
				b1X2.setFont(new Font("Segoe UI", Font.BOLD, 170));
				b1X2.setBackground(UIManager.getColor("Button.background"));
				b1X2.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseClicked(MouseEvent e) {
						b1X2MouseClicked();
					}
				});
				panel1.add(b1X2);

				//---- b2X0 ----
				b2X0.setHorizontalTextPosition(SwingConstants.CENTER);
				b2X0.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
				b2X0.setHorizontalAlignment(SwingConstants.CENTER);
				b2X0.setFont(new Font("Segoe UI", Font.BOLD, 170));
				b2X0.setBackground(UIManager.getColor("Button.background"));
				b2X0.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseClicked(MouseEvent e) {
						b2X0MouseClicked();
					}
				});
				panel1.add(b2X0);

				//---- b2X1 ----
				b2X1.setHorizontalTextPosition(SwingConstants.CENTER);
				b2X1.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
				b2X1.setHorizontalAlignment(SwingConstants.CENTER);
				b2X1.setFont(new Font("Segoe UI", Font.BOLD, 170));
				b2X1.setBackground(UIManager.getColor("Button.background"));
				b2X1.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseClicked(MouseEvent e) {
						b2X1MouseClicked();
					}
				});
				panel1.add(b2X1);

				//---- b2X2 ----
				b2X2.setHorizontalTextPosition(SwingConstants.CENTER);
				b2X2.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
				b2X2.setHorizontalAlignment(SwingConstants.CENTER);
				b2X2.setFont(new Font("Segoe UI", Font.BOLD, 170));
				b2X2.setBackground(UIManager.getColor("Button.background"));
				b2X2.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseClicked(MouseEvent e) {
						b2X2MouseClicked();
					}
				});
				panel1.add(b2X2);
			}
			panel2.add(panel1);
			panel1.setBounds(25, 5, 605, 540);

			//---- label1 ----
			label1.setIcon(new ImageIcon("src/resources/board.jpg"));
			label1.setHorizontalAlignment(SwingConstants.CENTER);
			panel2.add(label1);
			label1.setBounds(-10, 0, 675, 585);

			{
				// compute preferred size
				Dimension preferredSize = new Dimension();
				for(int i = 0; i < panel2.getComponentCount(); i++) {
					Rectangle bounds = panel2.getComponent(i).getBounds();
					preferredSize.width = Math.max(bounds.x + bounds.width, preferredSize.width);
					preferredSize.height = Math.max(bounds.y + bounds.height, preferredSize.height);
				}
				Insets insets = panel2.getInsets();
				preferredSize.width += insets.right;
				preferredSize.height += insets.bottom;
				panel2.setMinimumSize(preferredSize);
				panel2.setPreferredSize(preferredSize);
			}
		}
		contentPane.add(panel2, "card2");
		setSize(665, 625);
		setLocationRelativeTo(getOwner());
		// JFormDesigner - End of component initialization  //GEN-END:initComponents
	}

	// JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
	private JMenuBar menuBar1;
	private JMenu menu1;
	private JMenuItem menuItem1;
	private JMenuItem menuItem2;
	private JPanel panel2;
	private JPanel panel1;
	public JLabel b0X0;
	public JLabel b0X1;
	public JLabel b0X2;
	public JLabel b1X0;
	public JLabel b1X1;
	public JLabel b1X2;
	public JLabel b2X0;
	public JLabel b2X1;
	public JLabel b2X2;
	private JLabel label1;
	// JFormDesigner - End of variables declaration  //GEN-END:variables
}
