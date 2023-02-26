package com.gitdeveloper2;

import java.sql.ResultSet;
import java.sql.SQLException;

public class Main {
    public static void main(String[] args)  {

        DButils dButils=new DButils("root", "#0Security","jdbc:mysql://localhost/test");
        try(
        ResultSet rs=dButils.executeQuery("select * from users");
        ) {
            while (rs.next()) {
                String username = rs.getString("provider");
                System.out.println(username);
                ;
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }


    }
}