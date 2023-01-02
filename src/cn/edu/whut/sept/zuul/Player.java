package cn.edu.whut.sept.zuul;

import java.util.ArrayList;

/**
 * 玩家类，保存玩家信息
 */
public class Player {
    private final String name;
    private final String password;
    public Room currentRoom;
    public final ArrayList<Room> roomList;

    public Player(String name, String password) {
        this.name = name;
        this.password = password;

        currentRoom = Main.currentGame.getStartRoom();
        roomList = new ArrayList<>();
    }

    public String getName() { return name; }

    public String getPassword() { return password; }

    public void reset() {
        currentRoom = Main.currentGame.getStartRoom();
        roomList.clear();
    }
}
