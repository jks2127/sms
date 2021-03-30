package coreFiles;

import java.sql.Connection;
import java.sql.DriverManager;

import javax.swing.JOptionPane;


public class CP {
 	static Connection con;
    public static Connection createC(){
        try {
            //step 1- load JDBC driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            //step 2- create connection
            String user="root";
            String password="Boomer#5678";
            String url="jdbc:mysql://localhost:3306/student_manage";
            con=DriverManager.getConnection(url, user, password);

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Failded Accessing Database");
        }
        return con;
    }
}

