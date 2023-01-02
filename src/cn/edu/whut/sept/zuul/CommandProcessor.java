package cn.edu.whut.sept.zuul;

/**
 * {@code CommandAction}接口提供用来处理指令的方法接口。
 */
public interface CommandProcessor {
    boolean process(Command command);
}
