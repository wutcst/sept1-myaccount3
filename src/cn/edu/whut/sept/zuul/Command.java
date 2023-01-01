/**
 * {@code Command}类用来存储用户输入的指令。
 */

package cn.edu.whut.sept.zuul;

public class Command
{
    /** 用户输入指令的第一个单词 */
    private String commandWord;
    /** 用户输入指令的第二个单词 */
    private String secondWord;

    /**
     * 构造函数，创建{@code Command}对象。
     * @param firstWord 第一个单词
     * @param secondWord 第二个单词
     */
    public Command(String firstWord, String secondWord)
    {
        commandWord = firstWord;
        this.secondWord = secondWord;
    }

    /**
     * 以字符串形式，返回指令的第一个单词。
     * @return 指令的第一个单词
     */
    public String getCommandWord()
    {
        return commandWord;
    }

    /**
     * 以字符串形式，返回指令的第二个单词。
     * @return 指令的第二个单词
     */
    public String getSecondWord()
    {
        return secondWord;
    }

    /**
     * 判断指令是否是未知指令(无效指令)。
     * @return 若指令未知(无效)，返回{@code true}；若指令已知(有效)，返回{@code false}。
     */
    public boolean isUnknown()
    {
        return (commandWord == null);
    }

    /**
     * 判断指令是否含有第二个单词。
     * @return 若指令含有第二个单词，返回{@code true}；若指令不含第二个单词，返回{@code false}。
     */
    public boolean hasSecondWord()
    {
        return (secondWord != null);
    }
}
