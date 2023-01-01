/**
 * {@code CommandWords}类保存所有有效的指令字符串，并提供判断指令有效性、显示索引指令的方法。
 */

package cn.edu.whut.sept.zuul;

public class CommandWords
{
    /** 有效的指令字符串 */
    private static final String[] validCommands = {
            "go", "quit", "help"
    };

    /**
     * 构造函数。
     */
    public CommandWords()
    {
        // nothing to do at the moment...
    }

    /**
     * 判断指令的有效性。
     * @param aString 指令字符串
     * @return 若指令有效，返回{@code true}；若指令无效，返回{@code false}。
     */
    public boolean isCommand(String aString)
    {
        // 顺序查找
        for(int i = 0; i < validCommands.length; i++) {
            if(validCommands[i].equals(aString))
                return true;
        }
        return false;
    }

    /**
     * 显示所有有效的指令字符串
     */
    public void showAll()
    {
        for(String command: validCommands) {
            System.out.print(command + "  ");
        }
        System.out.println();
    }
}
