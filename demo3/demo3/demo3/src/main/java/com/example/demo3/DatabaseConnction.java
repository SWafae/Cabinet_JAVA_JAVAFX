package com.example.demo3;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Driver;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DatabaseConnction {
    public Connection Databaselink;

    public Connection getConnection(){
        String databaseName="centrekine";
        String databaseUser="root";
        String databasePassword="";
        String url="jdbc:mysql://localhost/"+ databaseName;

        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            Databaselink = DriverManager.getConnection(url,databaseUser,databasePassword) ;



        }catch (Exception e){
            e.printStackTrace();

        }

    return  Databaselink;
    }

}