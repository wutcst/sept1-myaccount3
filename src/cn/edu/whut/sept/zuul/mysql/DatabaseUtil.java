package cn.edu.whut.sept.zuul.mysql;

import java.sql.*;

/**
 * 数据库操作工具类。
 */
public class DatabaseUtil {
    /**
     * 数据库驱动
     */
    private static final String driver="com.mysql.cj.jdbc.Driver";
    /**
     * 数据库连接地址
     */
    private static final String url="jdbc:mysql://localhost:3306/game_of_zuul";
    /**
     * 数据库连接用户
     */
    private static final String user="root";
    /**
     * 数据库连接密码
     */
    private static final String password="111111";

    /**
     * 获取数据库连接
     * @return 数据库连接对象
     * @throws SQLException 提醒调用者捕获异常,并在{@code finally}中关闭关闭异常
     * @throws ClassNotFoundException 提醒调用者捕获异常
     */
    public static Connection getConnection() throws SQLException, ClassNotFoundException {
        Class.forName(driver);
        //通过DriverManager获得数据库连接
        return DriverManager.getConnection(url, user, password);
    }
    /**
     * 关闭数据库连接
     * @param con 数据库连接对象
     */
    public static void close(Connection con) {
        if(con != null) { //如果数据连接不为空
            try {
                //关闭数据库连接
                con.close();
            } catch (SQLException e) {
                e.printStackTrace();
                throw new RuntimeException("数据库关闭失败",e);
            }
        }
    }

//    public static int executeUpdate(Connection connection, String sql) throws SQLException {
//        PreparedStatement preparedStatement = connection.prepareStatement(sql);
//        return preparedStatement.executeUpdate();
//    }

    public static ResultSet executeQuery(Connection connection, String sql) throws SQLException {
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        return preparedStatement.executeQuery();
    }
}
