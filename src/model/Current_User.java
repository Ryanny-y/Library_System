package model;

public class Current_User {
    public static String getUser_Id() {
        return User_Id;
    }

    public static void setUser_Id(String aUser_Id) {
        User_Id = aUser_Id;
    }
    private static User_Model currentUser;
    private static String User_Id;
    
    
    
    private Current_User() {};
    
    public static void setCurrentUser(User_Model user) {
        currentUser = user;
    }
    
    public static User_Model getCurrentUser() {
        return currentUser;
    }
}
