package interfaces;
import java.awt.*;
import java.io.File;
import java.io.IOException;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.*;
import javax.swing.border.*;
/*
 * Created by JFormDesigner on Thu Feb 24 21:48:31 GMT-05:00 2022
 */



/**
 * @author David Alejadro
 */
public class Splash extends JFrame {
	int deph;

	public Splash(boolean audio) {
		initComponents();
		setVisible(true);
		setLocationRelativeTo(null);
		if (audio) {
			playSound("src/resources/arcade.wav");	
		}
	}

	private void playSound(String sound){
		try {
		 AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(new File(sound).getAbsoluteFile());
		 Clip clip = AudioSystem.getClip();
		 clip.open(audioInputStream);
		 clip.start();
		 clip.loop(Integer.MAX_VALUE);
		} catch(UnsupportedAudioFileException | IOException | LineUnavailableException ex) {
		  System.out.println("Error al reproducir el sonido.");
		}
	  }

	private void ok() {
		this.dispose();
		new Board(deph);
	}

	private void comboBox1ItemStateChanged() {
		if (comboBox1.getSelectedIndex()==2) {
			deph = 9;
		}
		else  {
			deph = comboBox1.getSelectedIndex();
		}
		System.out.println("Profundidad de algoritmo: "+ deph);
	}

	private void initComponents() {
		// JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
		dialogPane = new JPanel();
		panel1 = new JPanel();
		label2 = new JLabel();
		contentPanel = new JPanel();
		label1 = new JLabel();
		comboBox1 = new JComboBox<>();
		buttonBar = new JPanel();
		okButton = new JButton();

		//======== this ========
		setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
		setResizable(false);
		setTitle("TicTacToe, Cruz y Raya Vs IA");
		setIconImage(new ImageIcon("src/resources/x.png").getImage());
		Container contentPane = getContentPane();
		contentPane.setLayout(new BorderLayout());

		//======== dialogPane ========
		{
			dialogPane.setBorder(new EmptyBorder(12, 12, 12, 12));
			dialogPane.setLayout(new BorderLayout());

			//======== panel1 ========
			{
				panel1.setLayout(new FlowLayout());

				//---- label2 ----
				label2.setText("TicTacToe, Cruz y Raya Vs IA");
				label2.setFont(new Font("Segoe UI", Font.BOLD, 30));
				panel1.add(label2);
			}
			dialogPane.add(panel1, BorderLayout.NORTH);

			//======== contentPanel ========
			{
				contentPanel.setLayout(new FlowLayout());

				//---- label1 ----
				label1.setText("Dificultad: ");
				label1.setFont(new Font("Segoe UI", Font.PLAIN, 16));
				contentPanel.add(label1);

				//---- comboBox1 ----
				comboBox1.setFont(new Font("Segoe UI", Font.PLAIN, 16));
				comboBox1.setModel(new DefaultComboBoxModel<>(new String[] {
					"F\u00e1cil",
					"Normal",
					"Dif\u00edcil"
				}));
				comboBox1.addItemListener(e -> comboBox1ItemStateChanged());
				contentPanel.add(comboBox1);
			}
			dialogPane.add(contentPanel, BorderLayout.CENTER);

			//======== buttonBar ========
			{
				buttonBar.setBorder(new EmptyBorder(12, 0, 0, 0));
				buttonBar.setLayout(new GridLayout());

				//---- okButton ----
				okButton.setText("Jugar");
				okButton.setFont(new Font("Segoe UI", Font.PLAIN, 16));
				okButton.addActionListener(e -> ok());
				buttonBar.add(okButton);
			}
			dialogPane.add(buttonBar, BorderLayout.SOUTH);
		}
		contentPane.add(dialogPane, BorderLayout.CENTER);
		pack();
		setLocationRelativeTo(getOwner());
		// JFormDesigner - End of component initialization  //GEN-END:initComponents
	}

	// JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
	private JPanel dialogPane;
	private JPanel panel1;
	private JLabel label2;
	private JPanel contentPanel;
	private JLabel label1;
	private JComboBox<String> comboBox1;
	private JPanel buttonBar;
	private JButton okButton;
	// JFormDesigner - End of variables declaration  //GEN-END:variables
}
