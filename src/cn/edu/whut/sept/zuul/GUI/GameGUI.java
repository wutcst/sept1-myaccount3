package cn.edu.whut.sept.zuul.GUI;

import cn.edu.whut.sept.zuul.Parser;
import cn.edu.whut.sept.zuul.Player;
import cn.edu.whut.sept.zuul.Room;
import cn.edu.whut.sept.zuul.mysql.PlayerDao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

/**
 * {@code Game}类是“World-of-Zuul”应用程序的主类。
 * 《World of Zuul》是一款简单的文本冒险游戏。用户可以在一些房间组成的迷宫中探险。
 * 你们可以通过扩展该游戏的功能使它更有趣!.
 * 如果想开始执行这个游戏，用户需要创建Game类的一个实例并调用“play”方法。
 * Game类的实例将创建并初始化所有其他类:它创建所有房间，并将它们连接成迷宫；它创建解析器
 * 接收用户输入，并将用户输入转换成命令后开始运行游戏。
 *
 * @author Michael Kölling and David J. Barnes
 * @version 1.0
 */
public class GameGUI
{
    private final Parser parser;
//    private final HashMap<String, CommandProcessor> commandProcessorHashMap;
    private Player currentPlayer;
    private ArrayList<Player> playerList;
    private Room startRoom;

    /**
     * 构造函数，创建游戏并初始化内部数据和解析器.
     */
    public GameGUI()
    {
        createRooms();
        parser = new Parser();
//        commandProcessorHashMap = new HashMap<>();
//
//        commandProcessorHashMap.put("help", new HelpCommandProcessor());
//        commandProcessorHashMap.put("go", new GoCommandProcessor());
//        commandProcessorHashMap.put("quit", new QuitCommandProcessor());
//        commandProcessorHashMap.put("back", new BackCommandProcessor());
//        commandProcessorHashMap.put("register", new RegisterCommandProcessor());
//        commandProcessorHashMap.put("login", new LoginCommandProcessor());
//        commandProcessorHashMap.put("logout", new LogoutCommandProcessor());

        currentPlayer = null;
        playerList = null;
        startRoom = null;
    }

    /**
     * 读取已经注册的玩家。<br></br>
     * 将该方法放在{@code Game()}构造函数外面，避免{@code main}函数中{@code Game}对象未返回而造成{@code NullPointerException}。
     */
    public void playerListInit() {
        playerList = PlayerDao.searchAllPlayers();
    }

    /**
     * 创建所有房间对象并连接其出口用以构建迷宫.
     */
    private void createRooms()
    {
        Room outside, theater, pub, lab, office;

        // create the rooms
        outside = new Room("outside the main entrance of the university");
        theater = new Room("in a lecture theater");
        pub = new Room("in the campus pub");
        lab = new Room("in a computing lab");
        office = new Room("in the computing admin office");

        // initialise room exits
        outside.setExit("east", theater);
        outside.setExit("south", lab);
        outside.setExit("west", pub);

        theater.setExit("west", outside);

        pub.setExit("east", outside);

        lab.setExit("north", outside);
        lab.setExit("east", office);

        office.setExit("west", lab);

        startRoom = outside;  // start game outside
    }

    /**
     *  游戏主控循环，直到用户输入退出命令后结束整个程序.
     */
    public void play()
    {
        new LoginOrRegisterFrame().setVisible(true);
//        printWelcome();
//
//        // Enter the main command loop.  Here we repeatedly read commands and
//        // execute them until the game is over.
//
//        boolean finished = false;
//        while (! finished) {
//            Command command = parser.getCommand();
//            finished = processCommand(command);
//        }
//        System.out.println("Thank you for playing.  Good bye.");
    }

}