/*
DBManager file is responsible for getting the connection to the databaste and 
also used to interact with the data using the ResultSets and calling the
myQuery or myUpdate on it.
 */
package eventticketing;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


/**
 *
 * @author Adhay
 */
public final class DBManager {

    private static final String USER_NAME = "eventdb";
    private static final String PASSWORD = "pdccomp603";

    private static final String URL = "jdbc:derby:EventsDB;create=true";

    Connection conn;
    static DBManager dbmanager;

    private DBManager() {
        establishConnection();
    }

    public static void makeConnection() {
        DBManager dbManager = new DBManager();

    }

    public static DBManager getInstance() {
        if (dbmanager == null) {
            dbmanager = new DBManager();
        }
        return dbmanager;
    }

    public Connection getConnection() {
        return this.conn;
    }

    public void establishConnection() {
        if (this.conn == null) {
            try {
                conn = DriverManager.getConnection(URL, USER_NAME, PASSWORD);
                System.out.println(URL + " connected");

            } catch (SQLException ex) {
                System.out.println(ex.getMessage());
            }
        }
    }

    public void closeConnections() {
        if (conn != null) {
            try {
                conn.close();
            } catch (SQLException ex) {
                System.out.println(ex);
            }
        }
    }

    public ResultSet myQuery(String sql) {

        Connection connection = this.conn;
        Statement statement = null;
        ResultSet resultSet = null;

        try {
            statement = connection.createStatement();
            resultSet = statement.executeQuery(sql);

        } catch (Exception e) {
            e.printStackTrace();
        }
        return resultSet;
    }

    public void myUpdate(String sql) {

        Connection connection = this.conn;
        Statement statement = null;
        ResultSet resultSet = null;

        try {
            statement = connection.createStatement();
            statement.executeUpdate(sql);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
