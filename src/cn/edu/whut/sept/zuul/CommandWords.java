/**
 * {@code CommandWords}类保存所有有效的指令字符串，并提供判断指令有效性、显示索引指令的方法。
 */

package cn.edu.whut.sept.zuul;

import java.util.HashMap;

public class CommandWords
{
    /** 有效的指令字符串及其处理类 */
    private static final HashMap<String, CommandProcessor> commandProcessorHashMap
            = Main.currentGame.getCommandProcessorHashMap();


    /**
     * 判断指令的有效性。
     * @param aString 指令字符串
     * @return 若指令有效，返回{@code true}；若指令无效，返回{@code false}。
     */
    public static boolean isCommand(String aString)
    {
//        // 顺序查找
//        for(var item: validCommands) {
//            if(item.equals(aString))
//                return true;
//        }
//        return false;
        return commandProcessorHashMap.get(aString) != null;
    }

    /**
     * 显示所有有效的指令字符串
     */
    public static void showAll()
    {
        for(String command: commandProcessorHashMap.keySet()) {
            System.out.print(command + "  ");
        }
        System.out.println();
    }
}
