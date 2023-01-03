package cn.edu.whut.sept.zuul;

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
public class Game
{
    private final Parser parser;
    private final HashMap<String, CommandProcessor> commandProcessorHashMap;
    private Player currentPlayer;
    private ArrayList<Player> playerList;
    private Room startRoom;

    /**
     * 构造函数，创建游戏并初始化内部数据和解析器.
     */
    public Game()
    {
        createRooms();
        parser = new Parser();
        commandProcessorHashMap = new HashMap<>();

        commandProcessorHashMap.put("help", new HelpCommandProcessor());
        commandProcessorHashMap.put("go", new GoCommandProcessor());
        commandProcessorHashMap.put("quit", new QuitCommandProcessor());
        commandProcessorHashMap.put("back", new BackCommandProcessor());
        commandProcessorHashMap.put("register", new RegisterCommandProcessor());
        commandProcessorHashMap.put("login", new LoginCommandProcessor());
        commandProcessorHashMap.put("logout", new LogoutCommandProcessor());

//        currentPlayer = null;
//        playerList = null;
//        startRoom = null;
    }

    /**
     * 读取已经注册的玩家。<br></br>
     * 将该方法放在{@code Game()}构造函数外面，避免{@code main}函数中{@code Game}对象未返回而造成{@code NullPointerException}。
     */
    public void playerListInit() {
        playerList = PlayerDao.searchAllPlayers(false);
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
        printWelcome();

        // Enter the main command loop.  Here we repeatedly read commands and
        // execute them until the game is over.

        boolean finished = false;
        while (! finished) {
            Command command = parser.getCommand();
            finished = processCommand(command);
        }
        System.out.println("Thank you for playing.  Good bye.");
    }

    /**
     * 向用户输出欢迎信息.
     */
    private void printWelcome()
    {
        System.out.println();
        System.out.println("Welcome to the World of Zuul!");
        System.out.println("World of Zuul is a new, incredibly boring adventure game.");
        System.out.println("Type 'help' if you need help.");
        System.out.println();
//        System.out.println(currentRoom.getLongDescription());
    }

    /**
     * 执行用户输入的游戏指令.
     * @param command 待处理的游戏指令，由解析器从用户输入内容生成.
     * @return 如果执行的是游戏结束指令，则返回 {@code true}，否则返回 {@code false}.
     */
    private boolean processCommand(Command command)
    {
//        boolean wantToQuit = false;

        if(command.isUnknown()) {
            System.out.println("I don't know what you mean...");
            return false;
        }

        String commandWord = command.getCommandWord();
        var processor = commandProcessorHashMap.get(commandWord);
        if (processor != null) {
            return processor.process(command);
        }

        // else command not recognised.
        return false;

//        switch (commandWord) {
//            case "help" -> printHelp();
//            case "go" -> goRoom(command);
//            case "quit" -> wantToQuit = quit(command);
//        }

    }

    // implementations of user commands:

    /**
     * 执行help指令，在终端打印游戏帮助信息.
     * 此处会输出游戏中用户可以输入的命令列表
     */
    private void printHelp()
    {
        System.out.println("You are lost. You are alone. You wander");
        System.out.println("around at the university.");
        System.out.println();
        System.out.println("Your command words are:");
        parser.showCommands();
    }

    /**
     * 执行go指令，向房间的指定方向出口移动，如果该出口连接了另一个房间，则会进入该房间，
     * 否则打印输出错误提示信息.
     * @param command 待处理的游戏指令，由解析器从用户输入内容生成.
     */
    private void goRoom(Command command)
    {
        if(!command.hasSecondWord()) {
            // if there is no second word, we don't know where to go...
            System.out.println("Go where?");
            return;
        }

        String direction = command.getSecondWord();

        // Try to leave current room.
        Room nextRoom = currentPlayer.currentRoom.getExit(direction);

        if (nextRoom == null) {
            System.out.println("There is no door!");
        }
        else {
            currentPlayer.currentRoom = nextRoom;
            System.out.println(currentPlayer.currentRoom.getLongDescription());

            currentPlayer.roomList.add(currentPlayer.currentRoom);
        }
    }

    /**
     * 执行Quit指令，用户退出游戏。如果用户在命令中输入了其他参数，则进一步询问用户是否真的退出.
     * @return 如果游戏需要退出则返回 {@code true}，否则返回 {@code false}.
     */
    private boolean quit(Command command)
    {
        if(command.hasSecondWord()) {
            System.out.println("Quit what?");
            return false;
        }
        else {
            currentPlayer = null;
            return true;  // signal that we want to quit
        }
    }

    /**
     *
     * @return {@code Game}类中保存的有效指令及其处理类的{@code HashMap}对象{@code commandProcessorHashMap}
     */
    public HashMap<String, CommandProcessor> getCommandProcessorHashMap() { return commandProcessorHashMap; }

    /**
     *
     * @return {@code Game}类中保存的已经注册的{@code Player}对象的{@code ArrayList<Player>}集合。
     */
    public ArrayList<Player> getPlayerList() {
        return playerList;
    }

    /**
     *
     * @return 玩家最初所在的 {@code Room}对象
     */
    public Room getStartRoom() { return startRoom; }

    // 指令处理类
    /**
     * {@code help}指令的处理类
     */
    private class HelpCommandProcessor implements CommandProcessor {
        @Override
        public boolean process(Command command) {
            printHelp();
            return false;
        }
    }

    /**
     * {@code go}指令处理类
     */
    private class GoCommandProcessor implements CommandProcessor {
        @Override
        public boolean process(Command command) {
            if (currentPlayer == null) {
                System.out.println("Please log in!");
                return false;
            }
            goRoom(command);
            return false;
        }
    }

    /**
     * {@code quit}指令处理类
     */
    private class QuitCommandProcessor implements CommandProcessor {
        @Override
        public boolean process(Command command) {
            return quit(command);
        }
    }

    /**
     * {@code back}指令处理类
     */
    private class BackCommandProcessor implements CommandProcessor {
        @Override
        public boolean process(Command command) {
            if (currentPlayer == null) {
                System.out.println("Please log in!");
                return false;
            }

            if (currentPlayer.roomList.size() <= 1) {
                System.out.println("No previous room!");
            } else {
                currentPlayer.roomList.remove(currentPlayer.roomList.size() - 1);
                currentPlayer.currentRoom = currentPlayer.roomList.get(currentPlayer.roomList.size() - 1);
            }
            System.out.println(currentPlayer.currentRoom.getLongDescription());
            return false;
        }
    }

    /**
     * {@code register}指令处理类，玩家注册
     */
    private class RegisterCommandProcessor implements CommandProcessor {
        @Override
        public boolean process(Command command) {
            if (currentPlayer != null) {
                System.out.println("Please logout first!");
                return false;
            }

            System.out.println("Enter name and password to register");
            System.out.print("name:");

            Scanner scanner = new Scanner(System.in);
            String name = scanner.nextLine();
            System.out.print("password:");
            String password = scanner.nextLine();

            var player = new Player(name, password, false);
            playerList.add(player);
            PlayerDao.insertPlayer(player); // 玩家数据写入数据库

            System.out.println("Successfully registered!");

            return false;
        }
    }

    /**
     * {@code login}指令处理类，玩家登录
     */
    private class LoginCommandProcessor implements CommandProcessor {
        @Override
        public boolean process(Command command) {
            System.out.println("Enter name and password to log in");
            System.out.print("name:");

            Scanner scanner = new Scanner(System.in);
            String name = scanner.nextLine();
            System.out.print("password:");
            String password = scanner.nextLine();

            boolean found = false;
            for (var player: playerList) {
                if (player.getName().equals(name) && player.getPassword().equals(password)) {
                    found = true;
                    currentPlayer = player;
                    System.out.println("Successfully logged in!");
                    System.out.println(player.currentRoom.getLongDescription());
                    break;
                }
            }

            if (!found) {
                System.out.println("User not found! Unable to log in!");
            }

            return false;
        }
    }

    /**
     * {@code logout}指令处理类，玩家登出
     */
    private class LogoutCommandProcessor implements CommandProcessor {
        @Override
        public boolean process(Command command) {
            if (currentPlayer == null) {
                System.out.println("Not logged in! Unable to log out!");
                return false;
            }

            currentPlayer.reset(false);
            currentPlayer = null;
            System.out.println("Successfully logged out!");

            return false;
        }
    }
}