package cn.edu.whut.sept.zuul.mysql;

import cn.edu.whut.sept.zuul.Player;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class PlayerDao {
    public static ArrayList<Player> searchAllPlayers() {
        Connection connection = null;
        ArrayList<Player> playerArrayList = new ArrayList<>();

        try {
            String sql = "select name,password from user";

            connection = DatabaseUtil.getConnection();

            ResultSet resultSet = DatabaseUtil.executeQuery(connection, sql);

            while (resultSet.next()) {
                String name = resultSet.getString("name");
                String password = resultSet.getString("password");

                playerArrayList.add(new Player(name, password));
            }

        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            DatabaseUtil.close(connection);
        }

        return playerArrayList;
    }

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
