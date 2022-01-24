package peaksoft.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Util {
    // реализуйте настройку соеденения с БД
    private final static String url="jdbc:postgresql://localhost:5432/postgres";
    private final static String user="postgres";
    private final static String password="123123";

    public static Connection connections(){
        Connection connection1=null;
        try {
            connection1= DriverManager.getConnection(url,user,password);
            System.out.println("PostgreSQL ге ийгиликтуу кошулдуу☻♥");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return connection1;
    }

}
