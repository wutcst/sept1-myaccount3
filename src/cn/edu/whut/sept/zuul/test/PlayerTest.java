package cn.edu.whut.sept.zuul.test;

import cn.edu.whut.sept.zuul.GUI.GameGUI;
import cn.edu.whut.sept.zuul.GUI.MainGUI;
import cn.edu.whut.sept.zuul.Game;
import cn.edu.whut.sept.zuul.Main;
import cn.edu.whut.sept.zuul.Player;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PlayerTest {

    @BeforeEach
    void setUp() {
        Main.currentGame = new Game();
        MainGUI.currentGameGUI = new GameGUI();
    }

    @AfterEach
    void tearDown() {
        Main.currentGame = null;
        MainGUI.currentGameGUI = null;
    }

    @Test
    void reset() {
        Player player = new Player("abc", "123", false);
        Player guiPlayer = new Player("abcd", "1234", true);

        player.reset(false);
        assertEquals(1, player.getRoomList().size());
        assertEquals(player.getCurrentRoom(), player.getRoomList().get(0));

        guiPlayer.reset(true);
        assertEquals(1, guiPlayer.getRoomList().size());
        assertEquals(guiPlayer.getCurrentRoom(), guiPlayer.getRoomList().get(0));
    }
}