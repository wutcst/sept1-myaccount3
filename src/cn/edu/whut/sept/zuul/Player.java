package cn.edu.whut.sept.zuul;

import cn.edu.whut.sept.zuul.GUI.MainGUI;

import java.util.ArrayList;

/**
 * 玩家类，保存玩家信息
 */
public class Player {
    private final String name;
    private final String password;
    public Room currentRoom;
    public ArrayList<Room> roomList;

    public Player(String name, String password, boolean isGUI) {
        this.name = name;
        this.password = password;

        if (!isGUI) {
            currentRoom = Main.currentGame.getStartRoom();
            roomList = new ArrayList<>();
            roomList.add(Main.currentGame.getStartRoom());
        } else {
            currentRoom = MainGUI.currentGameGUI.getStartRoom();
            roomList = new ArrayList<>();
            roomList.add(MainGUI.currentGameGUI.getStartRoom());
        }

    }

    public String getName() { return name; }

    public String getPassword() { return password; }

    public Room getCurrentRoom() { return currentRoom; }
    public ArrayList<Room> getRoomList() { return roomList; }

    public void reset(boolean isGUI) {
        if (!isGUI) {
            currentRoom = Main.currentGame.getStartRoom();
            roomList.clear();
            roomList.add(Main.currentGame.getStartRoom());
        } else {
            currentRoom = MainGUI.currentGameGUI.getStartRoom();
            roomList.clear();
            roomList.add(MainGUI.currentGameGUI.getStartRoom());
        }
    }
}
