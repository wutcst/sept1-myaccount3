package cn.edu.whut.sept.zuul.GUI;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JTextArea;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class GameFrame extends JFrame {

	private JPanel contentPane;
	private JTextField usernameTextField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GameFrame frame = new GameFrame();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public GameFrame() {
		setTitle("World of Zuul");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 533, 372);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JLabel usernameLabel = new JLabel("Username");
		usernameLabel.setFont(new Font("Arial", Font.PLAIN, 16));
		
		usernameTextField = new JTextField();
		usernameTextField.setEditable(false);
		usernameTextField.setColumns(10);
		
		JLabel gameInfoLabel = new JLabel("Game Information");
		gameInfoLabel.setFont(new Font("Arial", Font.PLAIN, 16));
		
		JTextArea gameInfoTextArea = new JTextArea();
		gameInfoTextArea.setEditable(false);
		
		JButton goEastButton = new JButton("Go East");
		goEastButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		goEastButton.setFont(new Font("Arial", Font.PLAIN, 16));
		
		JButton goWestButton = new JButton("Go West");
		goWestButton.setFont(new Font("Arial", Font.PLAIN, 16));
		
		JButton goNorthButton = new JButton("Go North");
		goNorthButton.setFont(new Font("Arial", Font.PLAIN, 16));
		
		JButton goSouthButton = new JButton("Go South");
		goSouthButton.setFont(new Font("Arial", Font.PLAIN, 16));
		
		JButton backButton = new JButton("Back");
		backButton.setFont(new Font("Arial", Font.PLAIN, 16));
		
		JButton logoutButton = new JButton("Log out");
		logoutButton.setFont(new Font("Arial", Font.PLAIN, 16));
		
		JButton quitButton = new JButton("Quit");
		quitButton.setFont(new Font("Arial", Font.PLAIN, 16));
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addContainerGap()
							.addComponent(usernameLabel)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(usernameTextField, GroupLayout.PREFERRED_SIZE, 146, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(179)
							.addComponent(gameInfoLabel))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addContainerGap()
							.addComponent(gameInfoTextArea, GroupLayout.DEFAULT_SIZE, 474, Short.MAX_VALUE))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addContainerGap()
							.addComponent(goEastButton)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_contentPane.createSequentialGroup()
									.addComponent(goWestButton)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(goNorthButton))
								.addComponent(logoutButton, GroupLayout.PREFERRED_SIZE, 89, GroupLayout.PREFERRED_SIZE))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING, false)
								.addComponent(quitButton, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(goSouthButton, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(backButton, GroupLayout.PREFERRED_SIZE, 89, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap())
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(usernameLabel)
						.addComponent(usernameTextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(gameInfoLabel)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(gameInfoTextArea, GroupLayout.PREFERRED_SIZE, 68, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
							.addComponent(goEastButton)
							.addComponent(goWestButton, GroupLayout.PREFERRED_SIZE, 27, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
							.addComponent(goNorthButton, GroupLayout.PREFERRED_SIZE, 27, GroupLayout.PREFERRED_SIZE)
							.addComponent(goSouthButton, GroupLayout.PREFERRED_SIZE, 27, GroupLayout.PREFERRED_SIZE))
						.addComponent(backButton, GroupLayout.PREFERRED_SIZE, 27, GroupLayout.PREFERRED_SIZE))
					.addGap(51)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(logoutButton, GroupLayout.PREFERRED_SIZE, 27, GroupLayout.PREFERRED_SIZE)
						.addComponent(quitButton, GroupLayout.PREFERRED_SIZE, 27, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(65, Short.MAX_VALUE))
		);
		contentPane.setLayout(gl_contentPane);
	}
}
