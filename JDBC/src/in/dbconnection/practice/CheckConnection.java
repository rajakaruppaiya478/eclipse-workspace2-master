package in.dbconnection.practice;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;

public class CheckConnection {

  static Connection connection = null;

  public static void main(String[] args) {

    connection = DBConnectionUtil.getConnection();
    try (PreparedStatement preparedStatement = connection
        .prepareStatement("select * from Employee")) {
      ResultSet resultSet = preparedStatement.executeQuery();
      ResultSetMetaData resultSetMetaData = resultSet.getMetaData();
      int number = resultSetMetaData.getColumnCount();
      System.out.println();
      for (int i = 1; i <= number; i++) {
        System.out.print(resultSetMetaData.getColumnName(i).toUpperCase() + "\t\t");
      }
      System.out.println();
      while (resultSet.next()) {
        System.out.println();
        System.out.print(resultSet.getInt(1) + "\t\t");
        System.out.print(resultSet.getString(2) + "\t\t");
        System.out.println();
      }
    } catch (SQLException e) {
      e.printStackTrace();
    }

  }

}
