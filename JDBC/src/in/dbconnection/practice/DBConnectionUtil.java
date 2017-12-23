package in.dbconnection.practice;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.Properties;

import org.apache.log4j.Logger;

public class DBConnectionUtil {
  public static Logger logger = Logger.getLogger(DBConnectionUtil.class);

  public static Connection getConnection() {
    String driver = null;
    String url = null;
    String username = null;
    String password = null;
    Connection connection = null;

    try {

      FileReader fileReader = new FileReader("src/db.properties");
      Properties properties = new Properties();
      properties.load(fileReader);
      driver = properties.getProperty("driver");
      url = properties.getProperty("url");
      username = properties.getProperty("username");
      password = properties.getProperty("password");
      Class.forName(driver);
      connection = DriverManager.getConnection(url, username, password);
      logger.info("Connection Done  on      " + LocalDateTime.now());

    } catch (FileNotFoundException e) {
      logger.error("DB properties file not found", e);
    } catch (SQLException e) {
      logger.error("Connection not created ", e);
    } catch (ClassNotFoundException e) {
      logger.error("Class not found", e);
    } catch (IOException e) {
      logger.error("DB properties file not found", e);
    }
    return connection;
  }

  public static void closeConnection(Connection connection) {
    try {
      connection.close();
    } catch (SQLException e) {
      logger.error("Connection closed", e);
    }
  }

}
