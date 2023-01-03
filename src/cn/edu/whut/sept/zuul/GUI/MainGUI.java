package cn.edu.whut.sept.zuul.GUI;

public class MainGUI {
    public static GameGUI currentGameGUI;
    public static void main(String[] args) {
        currentGameGUI = new GameGUI();
        currentGameGUI.playerListInit();
        currentGameGUI.play();
    }

}
