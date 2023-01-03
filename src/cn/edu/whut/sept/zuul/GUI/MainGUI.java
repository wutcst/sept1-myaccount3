package cn.edu.whut.sept.zuul.GUI;

/**
 * 应用程序GUI的主启动类。
 */
public class MainGUI {
    public static GameGUI currentGameGUI;
    public static void main(String[] args) {
        currentGameGUI = new GameGUI();
        currentGameGUI.playerListInit();
        currentGameGUI.play();
    }

}
