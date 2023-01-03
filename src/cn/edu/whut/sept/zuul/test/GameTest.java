package cn.edu.whut.sept.zuul.test;

import cn.edu.whut.sept.zuul.Game;
import cn.edu.whut.sept.zuul.Main;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GameTest {

    @BeforeEach
    void setUp() {
        Main.currentGame = new Game();
    }

    @AfterEach
    void tearDown() {
        Main.currentGame = null;
    }

    @Test
    void playerListInit() {
        Main.currentGame.playerListInit();
        assertNotNull(Main.currentGame.getPlayerList());
    }

    @Test
    void getCommandProcessorHashMap() {
        assertNotNull(Main.currentGame.getCommandProcessorHashMap());
    }

    @Test
    void getStartRoom() {
        assertNotNull(Main.currentGame.getStartRoom());
    }
}