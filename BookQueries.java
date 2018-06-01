package projectBookShop;
/*created by JKinahan 25/03/17*/
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JTextArea;

public class BookQueries {
	
	
	static final String  url = "jdbc:mysql://localhost:3307/";	
	static final String databasename = "bookshop";
	static final String username = "root";
	static final String password = "usbw";
	static String selectitall= "SELECT * FROM book";
	
	public static void selectAllFromDB(JTextArea jt){
		try{
			Connection con = DriverManager.getConnection(url+databasename, username, password);
			PreparedStatement ps1 = con.prepareStatement(selectitall);
			ResultSet rs = ps1.executeQuery();
			while(rs.next()){
				String result1 = rs.getString(2);
				String result2 = rs.getString(3);
				String result3 = rs.getString(4);
				jt.append("Book: "+result1+".     Author: "+result2+".     Price: $"+result3+"\n");
			}	
		} catch(SQLException e){
			e.printStackTrace();
		}
	}
	public static void updatePrice(String title, String latest, JTextArea jt){
		try{
			Connection con = DriverManager.getConnection(url+databasename, username, password);
			PreparedStatement ps1 = con.prepareStatement("UPDATE book SET price = ? WHERE bookName = ?");
			ps1.setString(1,latest); ps1.setString(2, title);
			int rs = ps1.executeUpdate();
			if(rs>0){
				jt.setText("Price updated Successfully");
			}
			
		} catch(SQLException e){
			e.printStackTrace();
		}
	}
	public static void insertNewBook(String name, String writer, String price, JTextArea jt){
		try{
			Connection con = DriverManager.getConnection(url+databasename, username, password);
			PreparedStatement ps1 = con.prepareStatement("INSERT into book (bookName,authorName, price)"
					+ "VALUES (?,?,?)");
			ps1.setString(1,name); ps1.setString(2, writer); ps1.setString(3, price);;
			int rs= ps1.executeUpdate();
			if(rs>0){
				jt.setText("Book entered into Book Database");
			}
		} catch (SQLException e){
			e.printStackTrace();
		}
		
	}
	public static void deleteBook(String forBin, JTextArea jt){
		try{
			Connection con = DriverManager.getConnection(url+databasename, username, password);
			PreparedStatement ps1 = con.prepareStatement("DELETE from book where bookName=?");
			ps1.setString(1,forBin);
			int rs= ps1.executeUpdate();
			if(rs>0){
				jt.setText(forBin+" has been deleted from Book Database");
			}
		} catch (SQLException e){
			e.printStackTrace();
		}
	}
	
	


}
