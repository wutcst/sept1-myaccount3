package cn.edu.whut.sept.zuul.GUI;

import cn.edu.whut.sept.zuul.Room;

import javax.swing.*;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;

/**
 * World of Zuul游戏主界面。
 */
public class GameFrame extends JFrame {

	private final JTextArea gameInfoTextArea;
	
	private final JButton goEastButton;
	private final JButton goWestButton;
	private final JButton goNorthButton;
	private final JButton goSouthButton;
	
//	private Player currentPlayer;
	
//	private static GameFrame frame;

	/**
	 * 使用图形界面设计工具{@code WindowBuilder}生成的{@code LoginOrRegisterFrame}构造函数。
	 */
	public GameFrame() {
		setTitle("World of Zuul");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 533, 372);
		JPanel contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JLabel usernameLabel = new JLabel("Username");
		usernameLabel.setFont(new Font("Arial", Font.PLAIN, 16));

		JTextField usernameTextField = new JTextField();
		usernameTextField.setEditable(false);
		usernameTextField.setColumns(10);
		
		JLabel gameInfoLabel = new JLabel("Game Information");
		gameInfoLabel.setFont(new Font("Arial", Font.PLAIN, 16));
		
		gameInfoTextArea = new JTextArea();
		gameInfoTextArea.setEditable(false);
		
		goEastButton = new JButton("Go East");
		goEastButton.addActionListener(this::goEastActionPerformed);
		goEastButton.setFont(new Font("Arial", Font.PLAIN, 16));
		
		goWestButton = new JButton("Go West");
		goWestButton.addActionListener(this::goWestActionPerformed);
		goWestButton.setFont(new Font("Arial", Font.PLAIN, 16));
		
		goNorthButton = new JButton("Go North");
		goNorthButton.addActionListener(this::goNorthActionPerformed);
		goNorthButton.setFont(new Font("Arial", Font.PLAIN, 16));
		
		goSouthButton = new JButton("Go South");
		goSouthButton.addActionListener(this::goSouthActionPerformed);
		goSouthButton.setFont(new Font("Arial", Font.PLAIN, 16));
		
		JButton backButton = new JButton("Back");
		backButton.addActionListener(this::backActionPerformed);
		backButton.setFont(new Font("Arial", Font.PLAIN, 16));
		
		JButton logoutButton = new JButton("Log out");
		logoutButton.addActionListener(this::logoutActionPerformed);
		logoutButton.setFont(new Font("Arial", Font.PLAIN, 16));
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
							.addComponent(gameInfoTextArea, GroupLayout.DEFAULT_SIZE, 487, Short.MAX_VALUE))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addContainerGap()
							.addComponent(goEastButton)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(goWestButton)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addComponent(logoutButton, GroupLayout.PREFERRED_SIZE, 89, GroupLayout.PREFERRED_SIZE)
								.addGroup(gl_contentPane.createSequentialGroup()
									.addComponent(goNorthButton)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(goSouthButton)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(backButton, GroupLayout.PREFERRED_SIZE, 89, GroupLayout.PREFERRED_SIZE)))))
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
					.addComponent(logoutButton, GroupLayout.PREFERRED_SIZE, 27, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(65, Short.MAX_VALUE))
		);
		contentPane.setLayout(gl_contentPane);

		usernameTextField.setText(MainGUI.currentGameGUI.getCurrentPlayer().getName());
		printWelcome();
//		currentPlayer = MainGUI.currentGameGUI.getCurrentPlayer();
	}

	/**
	 * 在用户刚刚进入主界面时在{@code gameInfoTextArea}中显示提示信息。
	 */
	public void printWelcome() {
		String stringBuilder = "Welcome to the World of Zuul!\n" + "World of Zuul is a new, incredibly boring adventure game.\n" +
				MainGUI.currentGameGUI.getCurrentPlayer().currentRoom.getLongDescription();
		
		setGoButtons(MainGUI.currentGameGUI.getCurrentPlayer().currentRoom);
		
		gameInfoTextArea.setText(stringBuilder);
	}

	/**
	 * 用户登出功能实现，相当于控制台应用中的{@code CommandProcessor}对象。
	 * @param e {@code ActionEvent}对象
	 */
	public void logoutActionPerformed(ActionEvent e) {
		var player = MainGUI.currentGameGUI.getCurrentPlayer();
		player.reset(true);
		MainGUI.currentGameGUI.setCurrentPlayer(null);
		
		this.setVisible(false);
//		frame = null;
		new LoginOrRegisterFrame().setVisible(true);
	}

	/**
	 * {@code go east}指令在GUI中的实现。
	 * @param e {@code ActionEvent}对象
	 */
	public void goEastActionPerformed(ActionEvent e) {
		Room nextRoom = MainGUI.currentGameGUI.getCurrentPlayer().currentRoom.getExit("east");
		MainGUI.currentGameGUI.getCurrentPlayer().roomList.add(nextRoom);	// 保存到用户去过的room记录中
		MainGUI.currentGameGUI.getCurrentPlayer().currentRoom = nextRoom;	// 更新currentRoom
		
		setGoButtons(nextRoom);	// 根据更新后玩家所在的room使能go指令按钮
		displayCurrentRoom(nextRoom);	// 显示玩家现在所在room的信息
	}

	/**
	 * {@code go west}指令在GUI中的实现。
	 * @param e {@code ActionEvent}对象
	 */
	public void goWestActionPerformed(ActionEvent e) {
		Room nextRoom = MainGUI.currentGameGUI.getCurrentPlayer().currentRoom.getExit("west");
		MainGUI.currentGameGUI.getCurrentPlayer().roomList.add(nextRoom);
		MainGUI.currentGameGUI.getCurrentPlayer().currentRoom = nextRoom;
		
		setGoButtons(nextRoom);
		displayCurrentRoom(nextRoom);
	}

	/**
	 * {@code go north}指令在GUI中的实现。
	 * @param e {@code ActionEvent}对象
	 */
	public void goNorthActionPerformed(ActionEvent e) {
		Room nextRoom = MainGUI.currentGameGUI.getCurrentPlayer().currentRoom.getExit("north");
		MainGUI.currentGameGUI.getCurrentPlayer().roomList.add(nextRoom);
		MainGUI.currentGameGUI.getCurrentPlayer().currentRoom = nextRoom;
		
		setGoButtons(nextRoom);
		displayCurrentRoom(nextRoom);
	}

	/**
	 * {@code go south}指令在GUI中的实现。
	 * @param e {@code ActionEvent}对象
	 */
	public void goSouthActionPerformed(ActionEvent e) {
		Room nextRoom = MainGUI.currentGameGUI.getCurrentPlayer().currentRoom.getExit("south");
		MainGUI.currentGameGUI.getCurrentPlayer().roomList.add(nextRoom);
		MainGUI.currentGameGUI.getCurrentPlayer().currentRoom = nextRoom;
		
		setGoButtons(nextRoom);
		displayCurrentRoom(nextRoom);
	}

	/**
	 * {@code back}指令在GUI中的实现。
	 * @param e {@code ActionEvent}对象
	 */
	public void backActionPerformed(ActionEvent e) {
		if (MainGUI.currentGameGUI.getCurrentPlayer().roomList.size() <= 1) {
			JOptionPane.showMessageDialog(null, "No previous room!");
			return;
		}
		var roomList = MainGUI.currentGameGUI.getCurrentPlayer().roomList;	// 读取玩家去过的room记录

		// 退回上一个room
		roomList.remove(roomList.size() - 1);
		MainGUI.currentGameGUI.getCurrentPlayer().currentRoom = roomList.get(roomList.size() - 1);
		
		setGoButtons(MainGUI.currentGameGUI.getCurrentPlayer().currentRoom);	// 根据更新后玩家所在的room使能go指令按钮
		displayCurrentRoom(MainGUI.currentGameGUI.getCurrentPlayer().currentRoom);	// 显示玩家现在所在room的信息
	}

	/**
	 * 每进入一个房间{@code currentRoom}，根据房间出口信息，启用出口方向对应按钮，非出口方向对应按钮则停止使用。<br></br>
	 * 例如，若{@code currentRoom}的出口包含{@code east}，{@code west}，则设置{@code goEastButton}、{@code goWestButton}为{@code enabled},
	 * {@code goNorthButton}、{@code goSouthButton}为{@code disabled}。
	 * @param currentRoom 玩家当前所在的{@code Room}对象
	 */
	public void setGoButtons(Room currentRoom) {
		goEastButton.setEnabled(currentRoom.getExit("east") != null);
		goWestButton.setEnabled(currentRoom.getExit("west") != null);
		goNorthButton.setEnabled(currentRoom.getExit("north") != null);
		goSouthButton.setEnabled(currentRoom.getExit("south") != null);
	}

	/**
	 * 显示玩家当前所在的{@code Room}对象的相关信息。
	 * @param currentRoom 玩家当前所在的{@code Room}对象
	 */
	public void displayCurrentRoom(Room currentRoom) {
		gameInfoTextArea.setText(currentRoom.getLongDescription());
	}
}
