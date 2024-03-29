package cn.edu.whut.sept.zuul;

/**
 * {@code Main}类是“World-of-Zuul”应用程序的启动类。
 * {@code Main}类通过其中的{@code main}方法启动整个应用程序。
 */
public class Main {
    public static Game currentGame;

    public static void main(String[] args) {
        currentGame = new Game(); // 游戏初始化
        currentGame.playerListInit();   // 读取已经注册的玩家
        currentGame.play();    // 启动游戏
    }
}
