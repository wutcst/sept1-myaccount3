package cn.edu.whut.sept.zuul.mysql;

import cn.edu.whut.sept.zuul.Player;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 * 使{@code Player}类与数据库交互。
 */
public class PlayerDao {
    /**
     * 从数据库中查找并返回所有已注册的用户。
     * @param isGUI 是否在GUI中调用，若是则为{@code true}，不是则为{@code false}
     * @return 所有已注册的用户
     */
    public static ArrayList<Player> searchAllPlayers(boolean isGUI) {
        Connection connection = null;
        ArrayList<Player> playerArrayList = new ArrayList<>();

        try {
            String sql = "select name,password from user";

            connection = DatabaseUtil.getConnection();

            ResultSet resultSet = DatabaseUtil.executeQuery(connection, sql);

            while (resultSet.next()) {
                String name = resultSet.getString("name");
                String password = resultSet.getString("password");

                playerArrayList.add(new Player(name, password, isGUI));
            }

        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            DatabaseUtil.close(connection);
        }

        return playerArrayList;
    }

    /**
     * 在数据库中新增一个{@code Player}对象。
     * @param player 新增的{@code Player}对象
     */
    public static void insertPlayer(Player player) {
        Connection connection = null;

        try {
            String sql = "insert into user(name,password) values(?,?)";

            connection = DatabaseUtil.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(sql);

            preparedStatement.setString(1, player.getName());
            preparedStatement.setString(2, player.getPassword());

            preparedStatement.executeUpdate();
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            DatabaseUtil.close(connection);
        }
    }
}
