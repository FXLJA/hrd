package main;

import java.sql.*;

public class Koneksi 
{
private static Connection c;
private static final String URL = "jdbc:mysql://localhost:3306/hrd";
private static final String DRIVERNAME = "com.mysql.cj.jdbc.Driver";
private static final String USERNAME = "root";
private static final String PASSWORD = "";

    public static Connection openConnection()
    {
        if (c == null)
        {
            try
            {
                Class.forName(DRIVERNAME);
                
                try
                {
                    c = DriverManager.getConnection(URL, USERNAME, PASSWORD);
                }
                    catch (SQLException sqle)
                    {
                        System.out.println("Tidak terhubung ke database \n" + sqle);
                    }
            }
            catch (ClassNotFoundException e)
            {
                System.out.println("Driver not found ");
            }
        }
        
        return c;
    }

    public static Connection closeConnection()
    {
        if (c == null)
        {
            try
            {
                c.close();
            }
            catch (SQLException sqle)
            {
                System.out.println("Error: " + sqle);
            }
        }
        
        return c;
    }
    
    public static void main(String[] args) 
    {
        new Koneksi();
    }
}