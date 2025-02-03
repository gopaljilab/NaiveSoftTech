package studentManagementSystem;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class Conn {
    Connection connection;
    Statement statement;

    Conn(){
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/universitymanagement","root","Gopal@8650");
            statement = connection.createStatement();
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}

