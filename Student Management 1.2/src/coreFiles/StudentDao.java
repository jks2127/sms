package coreFiles;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class StudentDao {

//Insert
    
	public static boolean InsertStudentToDB(Connection con) {
        boolean f=false;
        try {
            //jdbc code
            String q="insert into students(Roll,Name,Phone,Address) values(?,?,?,?)";
            //preparedStatement
            PreparedStatement pstmt=con.prepareStatement(q);

            //set the value of parameter
            pstmt.setString(1,Add.getTextField_r().getText());
            pstmt.setString(2,Add.getTextField().getText());
            pstmt.setString(3,Add.getTextField_1().getText());
            pstmt.setString(4,Add.getTextField_2().getText());

            //execute.....
            pstmt.executeUpdate();

        } catch (Exception e) {
        }
        f=true;
        return f;
    }

//Display
	
    public static ResultSet showFromDB(Connection con) throws SQLException {
		String q="select * from students";
		Statement stmt=con.createStatement();
			
		ResultSet rs=stmt.executeQuery(q);
		return rs;		
	}
    

// Delete

	public static void deleteFromDB(int id) {
		Connection con=CP.createC();
	
		String q="delete from students where Roll=?";
		
		try {
			PreparedStatement pstmt=con.prepareStatement(q);
			
			pstmt.setInt(1, id);
			
			pstmt.executeUpdate();
			
			
			
		}catch(SQLException e) {
			//System.out.println("\n\t Query failed !!!");
		}		
	}
	
	public static void deleteFromDB(String id) {
		Connection con=CP.createC();
	
		String q="delete from students where Name=?";
		
		try {
			PreparedStatement pstmt=con.prepareStatement(q);
			
			pstmt.setString(1, id);
			
			pstmt.executeUpdate();
			
			//System.out.println("\n\t Student info deleted successfully");
			
		}catch(SQLException e) {
			//System.out.println("\n\t Query failed !!!");
		}		
	}
	
//Update
	
	public static void update(int id,Students st) throws IOException {
		Connection con= CP.createC();
		String q="update students set Name=?,Phone=?,Address=? where Roll=?";
		try {
			PreparedStatement pstmt= con.prepareStatement(q);
			
			
			pstmt.setString(1, st.getName());
			pstmt.setString(2, st.getPhone());
			pstmt.setString(3, st.getAddress());
			
			pstmt.setInt(4,id);
			
			pstmt.executeUpdate();
			
		}catch(SQLException e) {
		}
	}
}