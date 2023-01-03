package cn.edu.whut.sept.zuul.test;

import cn.edu.whut.sept.zuul.Command;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * 测试{@code Command}类中的方法。
 */
class CommandTest {

    @Test
    void getCommandWord() {
        Assertions.assertEquals("help", new Command("help", null).getCommandWord());
        assertEquals("go", new Command("go", "east").getCommandWord());
    }

    @Test
    void getSecondWord() {
        assertNull(new Command("help", null).getSecondWord());
        assertEquals("east", new Command("go", "east").getSecondWord());
    }

    @Test
    void isUnknown() {
        assertTrue(new Command(null, null).isUnknown());
        assertFalse(new Command("go", null).isUnknown());
    }

    @Test
    void hasSecondWord() {
        assertTrue(new Command("go", "north").hasSecondWord());
        assertFalse(new Command("help", null).hasSecondWord());
    }
}