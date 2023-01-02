/**
 * {@code Main}类是“World-of-Zuul”应用程序的启动类。
 * {@code Main}类通过其中的{@code main}方法启动整个应用程序。
 */

package cn.edu.whut.sept.zuul;

public class Main {
    public static Game currentGame;

    public static void main(String[] args) {
        currentGame = new Game(); // 游戏初始化
        currentGame.play();    // 启动游戏
    }
}
