/**
 * {@code Parser}类接收用户输入，并对用户输入进行分析。
 */

package cn.edu.whut.sept.zuul;

import java.util.Scanner;

public class Parser
{
    /** 有效指令 */
    private CommandWords commands;
    /** 接收用户输入 */
    private Scanner reader;

    /**
     * 构造函数。
     */
    public Parser()
    {
        commands = new CommandWords();  // 初始化commands对象
        reader = new Scanner(System.in);    // 接收用户在控制台端的输入
    }

    /**
     * 根据用户输入生成指令。
     * @return 生成的 {@code Command} 类对象
     */
    public Command getCommand()
    {
        String inputLine;
        String word1 = null;
        String word2 = null;

        System.out.print("> ");

        inputLine = reader.nextLine();  // 接收用户输入

        Scanner tokenizer = new Scanner(inputLine);
        if(tokenizer.hasNext()) {
            word1 = tokenizer.next();   // 获取用户输入的第一个单词
            if(tokenizer.hasNext()) {
                word2 = tokenizer.next();   // 获取用户输入的第二个单词
            }
            // 输入的其他内容忽略
        }

        // 判断用户输入是不是合法的指令
        if(commands.isCommand(word1)) {
            return new Command(word1, word2);
        }
        else {
            return new Command(null, word2);
        }
    }

    /**
     * 显示所有有效指令字符串。
     */
    public void showCommands()
    {
        commands.showAll();
    }
}
