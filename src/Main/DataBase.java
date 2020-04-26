package Main;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class DataBase {

	static Connection conn = null;
	static Statement stmt = null;
	static ResultSet rs = null;

    public static boolean IS_correnct_ID(String ID) {
		
    	try{
    		conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/client?serverTimezone=UTC&useSSL=false","root","1514");
			stmt = conn.createStatement();
			String sql = "Select Client_ID from client where client_ID = \"" + ID + "\"";
			System.out.println(sql);

			rs = stmt.executeQuery(sql);
			rs.next();
			System.out.println("ERROR2\n");

			System.out.println(rs.getString(1));
				
			if(rs.getString(1) ==null) {return false;}
			return true;
		}
		catch(Exception e) {
			System.out.println("ERROR2\n"+e);
			
			
			return false;
		}		
		
		
		
	}

    public static Customer fill_in_information(String ID) {
    	try{
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/client?serverTimezone=UTC&useSSL=false","root","1514");
			stmt = conn.createStatement();
			String sql = "Select Client_ID, Client_PW, Client_name,Client_phone_num, ifnull(year(Client_Bdate),year(now())),RemainingTime from client where client_ID = \"" + ID + "\"";
			System.out.println(sql);
			
			
			rs = stmt.executeQuery(sql);
			rs.next();
			Customer C = new Customer(rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(6));
			
			return C;
		}
		catch(Exception e) {
			System.out.println("ERROR\n"+e);
			return null;
			
		}		
    	
    }

    public static void Charge_time(String ID, int Time) {
    	try{
    		conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/client?serverTimezone=UTC&useSSL=false","root","1514");
			stmt = conn.createStatement();
			String sql = "update client set RemainingTime = DATE_ADD(RemainingTime, INTERVAL "+ Time +" HOUR) where client_id = '" + ID + "'";
			System.out.println(sql);
			stmt.executeUpdate(sql);
    	}
		catch(Exception e) {
			System.out.println("ERROR Charge Time\n"+e);
		}		
		
    }
    
    public static int[] get_color(int size) {
    	int []color = new int[size];
    	try{
    		conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/Seat?serverTimezone=UTC&useSSL=false","root","1514");
			stmt = conn.createStatement();
			String sql = "select is_empty from seat order by Seat_ID";
			System.out.println(sql);

			rs = stmt.executeQuery(sql);
			int temp = 0;
			while(rs.next()){
				color[temp++] = Integer.parseInt(rs.getString(1));
			}

			System.out.println("SUCCESS\n");

				
			return color;
		}
		catch(Exception e) {
			System.out.println("ERROR2\n"+e);
			
			
			return color;
		}		
		
    	
    	
    	
    	
    }
    
    public static String Check_Seat_time(int seat_num) {
    	String str = null;
    	try{
    		conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/Seat?serverTimezone=UTC&useSSL=false","root","1514");
			stmt = conn.createStatement();
			String sql = "select reamain_time from seat where seat_ID = '"+ seat_num +"'";
			System.out.println(sql);

			rs = stmt.executeQuery(sql);
			rs.next();
			str = rs.getString(1);
			

			System.out.println("SUCCESS\n");

				
			return str;
		}
		catch(Exception e) {
			System.out.println("ERROR2\n"+e);
			
			
			return str;
		}		
    	
    }

    public static String PrintGiftCard(String price) {
    	String Code = null;
    	try{
    		conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/GiftCard?serverTimezone=UTC&useSSL=false","root","1514");
			stmt = conn.createStatement();
			String sql = "select GiftCardNum from GiftCard where GiftCardPrice = " + price +" && Used = false limit 1";
			System.out.println(sql);

			rs = stmt.executeQuery(sql);
			rs.next();
			Code = rs.getString(1);
			

			sql = "update GiftCard set Used = false where GiftCardNum = '" + Code + "'";
			stmt.executeUpdate(sql);
			
			
			System.out.println("SUCCESS\n");

			
			return Code;
		}
		catch(Exception e) {
			System.out.println("ERROR2\n"+e);
			
			
			return Code;
		}		
    	
    	
    }
}
