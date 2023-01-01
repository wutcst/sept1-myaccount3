/**
 * {@code Room}类用来保存程序中用到的各个房间的相关信息。
 */

package cn.edu.whut.sept.zuul;

import java.util.Set;
import java.util.HashMap;

public class Room
{
    /** {@code Room}类对象的描述信息 */
    private String description;
    /** 该{@code Room}类对象在东、西、南、北方向的其他{@code Room}类对象 */
    private HashMap<String, Room> exits;

    /**
     * 构造函数。
     * @param description {@code Room}类对象的描述信息
     */
    public Room(String description)
    {
        this.description = description;
        exits = new HashMap<>();
    }

    /**
     * 为{@code Room}类对象设置在东、西、南、北方向的其他{@code Room}类对象。
     * @param direction 方向
     * @param neighbor 其他{@code Room}类对象
     */
    public void setExit(String direction, Room neighbor)
    {
        exits.put(direction, neighbor); // 将其他Room对象及其方位加入到当前Room对象的exits中
    }

    /**
     * 返回{@code Room}类对象自身的描述信息。
     * @return {@code Room} 类对象自身的描述信息
     */
    public String getShortDescription()
    {
        return description;
    }

    /**
     * 返回{@code Room}类对象自身的描述信息和出口信息。
     * @return {@code Room} 类对象自身的描述信息和出口信息
     */
    public String getLongDescription()
    {
        return "You are " + description + ".\n" + getExitString();
    }

    /**
     * 返回{@code Room}类对象的出口信息。
     * @return {@code Room}类对象的出口信息
     */
    private String getExitString()
    {
        String returnString = "Exits:";
        Set<String> keys = exits.keySet();  // 获取Room类对象的所有出口方位字符串
        for(String exit : keys) {
            returnString += " " + exit; // 将" "和keys中的字符串拼接到returnString上，以返回所有出口方位
        }
        return returnString;
    }

    /**
     * 返回{@code Room}类对象在某方向的另一个{@code Room}类对象。
     * @param direction 方向
     * @return {@code Room}类对象在{@code direction}方向的另一个{@code Room}类对象。若该对象在该方向上没有{@code Room}类对象，返回{@code null}。
     */
    public Room getExit(String direction)
    {
        return exits.get(direction);
    }
}


