package cn.edu.whut.sept.zuul.GUI;

import cn.edu.whut.sept.zuul.Player;
import cn.edu.whut.sept.zuul.mysql.PlayerDao;

import javax.swing.*;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;

public class LoginOrRegisterFrame extends JFrame {

	private final JTextField nameTextField;
	private final JPasswordField passwordField;
//	private LoginOrRegisterFrame frame;

//	/**
//	 * Launch the application.
//	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			@Override
//			public void run() {
//				try {
//					frame = new LoginOrRegisterFrame();
//					frame.setVisible(true);
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//			}
//		});
//	}

	/**
	 * Create the frame.
	 */
	public LoginOrRegisterFrame() {
		setTitle("Log in/Register");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 317, 253);
		JPanel contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JLabel nameLabel = new JLabel("Name");
		nameLabel.setFont(new Font("Arial", Font.PLAIN, 16));
		
		nameTextField = new JTextField();
		nameTextField.setColumns(10);
		
		JLabel passwordLabel = new JLabel("Password");
		passwordLabel.setFont(new Font("Arial", Font.PLAIN, 16));
		
		passwordField = new JPasswordField();
		
		JButton loginButton = new JButton("Log in");
		loginButton.addActionListener(this::loginActionPerformed);
		loginButton.setFont(new Font("Arial", Font.PLAIN, 16));
		
		JButton registerButton = new JButton("Register");
		registerButton.addActionListener(this::registerActionPerformed);
		registerButton.setFont(new Font("Arial", Font.PLAIN, 16));
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
						.addGroup(Alignment.LEADING, gl_contentPane.createSequentialGroup()
							.addGap(54)
							.addComponent(loginButton)
							.addPreferredGap(ComponentPlacement.RELATED, 21, Short.MAX_VALUE)
							.addComponent(registerButton))
						.addGroup(Alignment.LEADING, gl_contentPane.createSequentialGroup()
							.addContainerGap()
							.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
								.addComponent(passwordLabel)
								.addComponent(nameLabel))
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addComponent(passwordField)
								.addComponent(nameTextField, GroupLayout.PREFERRED_SIZE, 153, GroupLayout.PREFERRED_SIZE))))
					.addContainerGap(181, Short.MAX_VALUE))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(12)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
						.addComponent(nameTextField, GroupLayout.PREFERRED_SIZE, 22, GroupLayout.PREFERRED_SIZE)
						.addComponent(nameLabel))
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(20)
							.addComponent(passwordLabel))
						.addGroup(Alignment.TRAILING, gl_contentPane.createSequentialGroup()
							.addGap(18)
							.addComponent(passwordField, GroupLayout.PREFERRED_SIZE, 21, GroupLayout.PREFERRED_SIZE)))
					.addGap(70)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(loginButton)
						.addComponent(registerButton))
					.addContainerGap(85, Short.MAX_VALUE))
		);
		contentPane.setLayout(gl_contentPane);
	}
	
	public void loginActionPerformed(ActionEvent e) {
		String name = nameTextField.getText();
		String password = new String(passwordField.getPassword());
		
		boolean found = false;
        for (var player: MainGUI.currentGameGUI.getPlayerList()) {
            if (player.getName().equals(name) && player.getPassword().equals(password)) {
                found = true;
//                currentPlayer = player;
                MainGUI.currentGameGUI.setCurrentPlayer(player);

				this.setVisible(false);
				new GameFrame().setVisible(true);

                break;
            }
        }

		if (!found) {
			JOptionPane.showMessageDialog(null, "User not found! Unable to log in!");
		}
	}
	
	public void registerActionPerformed(ActionEvent e) {
		try {
			String name = nameTextField.getText();
			String password = new String(passwordField.getPassword());
			
			var player = new Player(name, password, true);
			MainGUI.currentGameGUI.getPlayerList().add(player);
			PlayerDao.insertPlayer(player);
			
			JOptionPane.showMessageDialog(null, "Successfully registered!");
		} catch (Exception ex) {
			ex.printStackTrace();
			JOptionPane.showMessageDialog(null, "Unable to register!");
		}
	}
}
