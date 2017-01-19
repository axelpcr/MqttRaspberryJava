//package mqtt.raspbery;
//
//import java.sql.Connection;
//import java.sql.DriverManager;
//import java.sql.PreparedStatement;
//import java.sql.ResultSet;
//import java.sql.SQLException;
//import java.sql.Statement;
//
///**
// * Created by axel on 19/01/17.
// */
//public class H2Configuration {
//
//    private static final String DB_DRIVER = "org.h2.Driver";
//    private static final String DB_CONNECTION = "jdbc:h2:~/test";
//    private static final String DB_USER = "";
//    private static final String DB_PASSWORD = "";
//
//    // H2 SQL Prepared Statement Example
//    private static void createTable() throws SQLException {
//        PreparedStatement createPreparedStatement = null;
//        PreparedStatement insertPreparedStatement = null;
//        PreparedStatement selectPreparedStatement = null;
//
//        String CreateQuery = "CREATE TABLE MQTT(id int primary key, msg varchar(255))";
//        try (Connection connection = getDBConnection()) {
//            connection.setAutoCommit(false);
//
//            createPreparedStatement = connection.prepareStatement(CreateQuery);
//            createPreparedStatement.executeUpdate();
//            createPreparedStatement.close();
//
//
//            connection.commit();
//        } catch (SQLException e) {
//            System.out.println("Exception Message " + e.getLocalizedMessage());
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }
//
//    // H2 SQL Statement Example
//    private static void insertWithStatement() throws SQLException {
//        Connection connection = getDBConnection();
//        Statement stmt = null;
//        try {
//            connection.setAutoCommit(false);
//            stmt = connection.createStatement();
//            stmt.execute("CREATE TABLE PERSON(id int primary key, name varchar(255))");
//            stmt.execute("INSERT INTO PERSON(id, name) VALUES(1, 'Anju')");
//            stmt.execute("INSERT INTO PERSON(id, name) VALUES(2, 'Sonia')");
//            stmt.execute("INSERT INTO PERSON(id, name) VALUES(3, 'Asha')");
//
//            ResultSet rs = stmt.executeQuery("select * from PERSON");
//            System.out.println("H2 Database inserted through Statement");
//            while (rs.next()) {
//                System.out.println("Id "+rs.getInt("id")+" Name "+rs.getString("name"));
//            }
//            stmt.close();
//            connection.commit();
//        } catch (SQLException e) {
//            System.out.println("Exception Message " + e.getLocalizedMessage());
//        } catch (Exception e) {
//            e.printStackTrace();
//        } finally {
//            connection.close();
//        }
//    }
//
//    private static Connection getDBConnection() {
//        Connection dbConnection = null;
//        try {
//            Class.forName(DB_DRIVER);
//        } catch (ClassNotFoundException e) {
//            System.out.println(e.getMessage());
//        }
//        try {
//            dbConnection = DriverManager.getConnection(DB_CONNECTION, DB_USER,
//                    DB_PASSWORD);
//            return dbConnection;
//        } catch (SQLException e) {
//            System.out.println(e.getMessage());
//        }
//        return dbConnection;
//    }
//}
