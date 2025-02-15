package main;
import pages.*;
import config.ConnDB;
import pages.User.Home;

public class Main {
    
    public static void main(String[] args) {

//        new Home();
        new Login();
        ConnDB con = ConnDB.getInstance();
//        con.creat
        con.getConnection();
    }
    
}