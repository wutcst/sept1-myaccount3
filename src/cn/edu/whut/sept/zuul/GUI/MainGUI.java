package cn.edu.whut.sept.zuul.GUI;

import cn.edu.whut.sept.zuul.Game;

public class MainGUI {
    public static GameGUI currentGameGUI;
    public static void main(String[] args) {
        currentGameGUI = new GameGUI();
        currentGameGUI.play();
        currentGameGUI.playerListInit();
    }

}
