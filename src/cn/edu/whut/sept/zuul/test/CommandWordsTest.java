package cn.edu.whut.sept.zuul.test;

import cn.edu.whut.sept.zuul.CommandWords;
import cn.edu.whut.sept.zuul.Game;
import cn.edu.whut.sept.zuul.Main;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class CommandWordsTest {

    @BeforeEach
    void setUp() {
        Main.currentGame = new Game();
    }
    @Test
    void isCommand() {
//        Game game = new Game();
//        HashMap<String, CommandProcessor> commandProcessorHashMap = game.getCommandProcessorHashMap();

        assertTrue(CommandWords.isCommand("help"));
        assertTrue(CommandWords.isCommand("go"));
        assertTrue(CommandWords.isCommand("quit"));

        assertFalse(CommandWords.isCommand("of"));
        assertFalse(CommandWords.isCommand("hell"));
    }

    @AfterEach
    void tearDown() {
        Main.currentGame = null;
    }
}