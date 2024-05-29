package gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JLabel;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.ActionEvent;

public class Adresse {

	public JFrame frame;
	public JTextField textField;
	public static String adresse ;
	private JButton btnNewButton_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Adresse window = new Adresse();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Adresse() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JButton btnNewButton = new JButton("Valider");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				adresse = textField.getText();
			}
		});
		btnNewButton.setBounds(156, 204, 89, 23);
		frame.getContentPane().add(btnNewButton);
		
		//****** Définir le bouton par défaut ******
        frame.getRootPane().setDefaultButton(btnNewButton);
        
        btnNewButton.setMnemonic(KeyEvent.VK_ENTER);
		
		textField = new JTextField();
		textField.setBounds(156, 68, 86, 20);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Adresse");
		lblNewLabel.setBounds(59, 71, 46, 14);
		frame.getContentPane().add(lblNewLabel);
		
		btnNewButton_1 = new JButton("Quitter");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.setVisible(false);
			}
		});
		btnNewButton_1.setBounds(297, 204, 89, 23);
		frame.getContentPane().add(btnNewButton_1);
	}
}
