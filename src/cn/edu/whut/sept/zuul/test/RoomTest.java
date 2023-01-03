package cn.edu.whut.sept.zuul.test;

import cn.edu.whut.sept.zuul.Room;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class RoomTest {
    @Test
    void setExit() {
        Room room1 = new Room("room1");
        Room room2 = new Room("room2");
        room1.setExit("east", room2);

        assertEquals(room2, room1.getExit("east"));
    }

    @Test
    void getLongDescription() {
        Room room1 = new Room("room1");
        Room room2 = new Room("room2");
        room1.setExit("east", room2);

//        System.out.println(room1.getLongDescription());
        assertEquals("You are room1.\nExits: east", room1.getLongDescription());
    }

//    setExit()方法测试中已经对getExit()方法进行了测试。
//    @Test
//    void getExit() {
//        setExit();
//    }
}